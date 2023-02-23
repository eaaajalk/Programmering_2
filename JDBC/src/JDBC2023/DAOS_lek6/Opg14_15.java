package JDBC2023.DAOS_lek6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Opg14_15 {

    /**
     * @param args
     */
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;


    //Opgave 1
    public static void selectmedparm() {
        try {
            // Indlæser søgestreng
            System.out.println("Indtast søgestreng");
            String inString = inLine.readLine();
            // Laver sql-sætning og får den udført
            String sql = "select aarstal, plac from placering where init like '" + inString + "'";
            System.out.println("SQL-streng er " + sql);
            ResultSet res = stmt.executeQuery(sql);
            //gennemløber svaret
            while (res.next()) {
               String c1 = res.getString(1);
               String c2 = res.getString(2);
               if (c2 == null) {
                   c2 = "UDGÅET";
               }
                System.out.println(c1 + "    " + c2);
            }
            // pæn lukning
            if (!minConnection.isClosed()) minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

    // OPGAVE 2
        public static void insertmedstring() {
            try {
                // indlæsning
                System.out.println("Vi vil nu oprette et nyt resultat");
                System.out.println("Indtast initialer");
                String cprstr=inLine.readLine();
                System.out.println("Indtast placering");
                String firmastr=inLine.readLine();

                // sender insert'en til db-serveren
                String sql = "insert into placering values ('2022','" + cprstr + "'," + firmastr + ")";
                System.out.println("SQL-streng er "+ sql);
                stmt.execute(sql);
                // pænt svar til brugeren
                System.out.println("Ansættelsen er nu registreret");
                if (!minConnection.isClosed()) minConnection.close();
            }
            catch (SQLException e) {
                switch (e.getErrorCode())
                // fejl-kode 547 svarer til en foreign key fejl
                { case 547 : {if (e.getMessage().contains("cprforeign"))
                    System.out.println("cpr-nummer er ikke oprettet");
                else
                if (e.getMessage().contains("firmaforeign"))
                    System.out.println("firmaet er ikke oprettet");
                else
                    System.out.println("ukendt fremmednøglefejl");
                    break;
                }
                // fejl-kode 2627 svarer til primary key fejl
                    case 2627: {System.out.println("den pågældende ansættelse er allerede oprettet");
                        break;
                    }
                    default: System.out.println("fejlSQL:  "+e.getMessage());
                };
            }
            catch (Exception e) {
                System.out.println("fejl:  "+e.getMessage());
            }
        };

    // OPGAVE 15
    public static void insertprepared() {
        try {
            // indl�sning
            System.out.println("Vi vil nu indsætte nye resultater ");
            System.out.println("Indtast initialer");
            String cprstr=inLine.readLine();
            System.out.println("Indtast placeringsnummer");
            String firmastr=inLine.readLine();
            // Anvendelse af prepared statement
            String sql = "insert into placering values (?,?,?)";
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();
            prestmt.setString(1, "2022");
            prestmt.setString(2,cprstr);
            prestmt.setInt(3,Integer.parseInt(firmastr));
            // Udf�rer s�tningen
            prestmt.execute();
            // p�nt svar til brugeren
            System.out.println("Placeringen er nu registreret");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            { case 547 : {if (e.getMessage().contains("initforeign"))
                System.out.println("init er ikke oprettet");
            else
            if (e.getMessage().contains("aarstalforeign"))
                System.out.println("aarstal er ikke oprettet");
            else
                System.out.println("ukendt fremmednøglefejl");
                break;
            }
            // fejl-kode 2627 svarer til primary key fejl
                case 2627: {System.out.println("den pågældende ansættelse er allerede oprettet");
                    break;
                }
                default: System.out.println("fejlSQL:  "+e.getMessage());
            };
        }
        catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            inLine = new BufferedReader(new InputStreamReader(System.in));
            //generel opsætning
            //via native driver
            String server="localhost"; //virker måske hos dig
            //virker det ikke - prøv kun med localhost
            String dbnavn="lektion3";            //virker måske hos dig
            String login="sa";                     //skal ikke ændres
            String password="Jeger25%datamatiker";            //skal ændres

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
                    ";user=" + login + ";password=" + password + ";");
            //minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
            stmt = minConnection.createStatement();
            //Indlæsning og kald af den rigtige metode
            System.out.println("Indtast  ");
            System.out.println("s for select uden parameter  ");
            System.out.println("sp for select med parameter  ");
            System.out.println("i for insert med strengmanipulation");
            System.out.println("ps for insert med prepared statement ");
            String in=inLine.readLine();
            switch (in)
            {
                //case "s"  : {selectudenparm();break;}
                case "sp" : {selectmedparm();break;}
                case "i"  : {insertmedstring();break;}
                case "ps"  : {insertprepared();break;}
                default : System.out.println("ukendt indtastning");
            }
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }

}
