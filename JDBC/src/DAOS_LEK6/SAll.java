package DAOS_LEK6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class SAll {
    /**
     * @param args
     */
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;

    public static void opgave6c() {
        try {

            System.out.println("Du skal til at placere et fad på en hylde");

           System.out.println("Indtast fadID ");
            String fadID=inLine.readLine();

            System.out.println("Indtast hyldeID");
            String hyldeID = inLine.readLine();


            // Anvendelse af prepared statement ind i destillerings tabellen.
            String sql = "update fad set hyldeID = " + hyldeID + "where fadID = " + fadID;
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();
            // Udf�rer s�tningen
            prestmt.execute();
            // p�nt svar til brugeren
            System.out.println("Fadet er nu placeret");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            { case 547 : {if (e.getMessage().contains("destillatIDconstraint"))
                System.out.println("destillatet findes ikke");
            else
            if (e.getMessage().contains("destilleringsIDconstraint"))
                System.out.println("Destilleringen er ikke oprettet");
            else
                System.out.println("ukendt fremmednøglefejl");
                break;
            }
                case 2627: {System.out.println("Primary key er allerede brugt");
                    break;
                }
                default: System.out.println("fejlSQL:  "+e.getMessage());
            };
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }
    public static void opgave6b () {
        try {
            // Indlæser søgestreng
            System.out.println("Indtast medarbejderID");
            String inString = inLine.readLine();
            // Laver sql-sætning og får den udført
            String sql = "select count(de.destilleringsID), sum(d.startMængde) " +
                    "from medarbejder m join destillering de on m.medarbejderID = de.medarbejderID join blanding b on " +
                    "de.destilleringsID = b.destilleringsID join destillat d on b.destillatID = d.destillatID " +
                    "where m.medarbejderID = '" + inString + "'";
            System.out.println("SQL-streng er "+ sql);
            ResultSet res=stmt.executeQuery(sql);
            //gennemløber svaret
            while (res.next()) {
                System.out.println("Antal destilleringer: " + res.getString(1) + " | Antal destilleret liter: " + res.getString(2));
            }
            // pæn lukning
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
                System.out.println("fejlSQL:  " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }

    public static void insertDestillering() {
        try {
            // indl�sning
            String getID = "select top 1 destilleringsID from destillering ORDER BY destilleringsID DESC";
            ResultSet res=stmt.executeQuery(getID);
            int id = 0;
            if (res.next()) {
                id = res.getInt("destilleringsID");
            }

            System.out.println("Du skal til at oprette et destillering");
//
//            System.out.println("Indtast destilleringsID ");
//            String destilleringsID=inLine.readLine();

            System.out.println("Indtast startDato (YYYY-MM-DD)");
            String startDato = inLine.readLine();

            System.out.println("Indtast slutDato (YYYY-MM-DD)");
            String slutDato=inLine.readLine();

            System.out.println("Indtast alkoholProcent");
            String alkoProcent=inLine.readLine();

            System.out.println("Indtast mængde");
            String mængde=inLine.readLine();

            System.out.println("Indtast medarbejderID");
            String medarbejder=inLine.readLine();

            // Anvendelse af prepared statement ind i destillerings tabellen.
            String sql = "insert into destillering values (?,?,?,?,?,?)";
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setInt(1, id+1);

            if (startDato.length() == 10) {
                prestmt.setString(2,startDato);
            } else {
               //==
            }
            if (slutDato.length() == 10) {
                prestmt.setString(3,slutDato);
            } else {
                //==
            }
            prestmt.setString(4, alkoProcent);

            prestmt.setInt(5, Integer.parseInt(mængde));

            prestmt.setInt(6, Integer.parseInt((medarbejder)));
            // Udf�rer s�tningen
            prestmt.execute();
            // p�nt svar til brugeren
            System.out.println("Destilleringen er nu oprettet");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            { case 547 : {if (e.getMessage().contains("destillatIDconstraint"))
                System.out.println("destillatet findes ikke");
            else
            if (e.getMessage().contains("destilleringsIDconstraint"))
                System.out.println("Destilleringen er ikke oprettet");
            else
                System.out.println("ukendt fremmednøglefejl");
                break;
            }

                case 2627: {System.out.println("Primary key er allerede brugt");
                    break;
                }
                default: System.out.println("fejlSQL:  "+e.getMessage());
            };
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
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
            String dbnavn="SALL";            //virker måske hos dig
            String login="sa";                     //skal ikke ændres
            String password="Jeger25%datamatiker";            //skal ændres

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
                    ";user=" + login + ";password=" + password + ";");
            //minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
            stmt = minConnection.createStatement();
            //Indlæsning og kald af den rigtige metode
            System.out.println("Indtast  ");
            System.out.println("a for opgave 6.a  ");
            System.out.println("b for opgave 6.b  ");
            System.out.println("c for opgave 6.c");
            String in=inLine.readLine();
            switch (in)
            {case "a"  : {insertDestillering();break;}
                case "b" : {opgave6b();break;}
                case "c"  : {
                    opgave6c();break;}
                default : System.out.println("ukendt indtastning");
            }
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }
}
