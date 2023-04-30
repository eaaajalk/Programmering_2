package DAOS_LEK6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Miniprojekt {

    /**
     * @param args
     */
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;

    public static void insertEksamensforsøg() {
        try {
            // indl�sning
            String getID = "select top 1 forsøgsID from eksamensforsøg ORDER BY forsøgsID DESC";
            ResultSet res=stmt.executeQuery(getID);
            int id = 0;
            if (res.next()) {
                id = res.getInt("forsøgsID");
            }

            System.out.println("Du skal til at oprette et eksamensforsøg");

            System.out.println("Indtast eksamens ID ");
            String idstr=inLine.readLine();

            System.out.println("Indtast termin");
            String terminstr = inLine.readLine();

            System.out.println("Indtast den studerendes cpr-nummer.");
            String cprstr=inLine.readLine();

            System.out.println("Indtast bedømmelse");
            String bedstr=inLine.readLine();

            // Anvendelse af prepared statement ind i eksamenforsøgs tabellen.
            String sql = "insert into eksamensforsøg values (?,?,?,?,?,?)";
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            if (bedstr.contains("[0,2,4,7,10,12]")) {

                prestmt.setInt(2,Integer.parseInt(bedstr));
                prestmt.setString(3, null);
            } else {
               prestmt.setString(2,(null));
                prestmt.setString(3, bedstr);
            }
            prestmt.setInt(1,(id+1));
            prestmt.setString(4, terminstr);
            prestmt.setInt(5, Integer.parseInt(idstr));
            prestmt.setString(6, (cprstr));

            // Udf�rer s�tningen
            prestmt.execute();
            // p�nt svar til brugeren
            System.out.println("Bedømmelsen er nu regisreret");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            { case 547 : {if (e.getMessage().contains("eksamensidforeign"))
                System.out.println("Den pågældende eksamen er ikke oprettet");
            else
            if (e.getMessage().contains("cprforerign"))
                System.out.println("Den studerende er ikke oprettet");
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
            String dbnavn="lektion4";            //virker måske hos dig
            String login="sa";                     //skal ikke ændres
            String password="Jeger25%datamatiker";            //skal ændres

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
                    ";user=" + login + ";password=" + password + ";");
            //minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
            stmt = minConnection.createStatement();
            //Indlæsning og kald af den rigtige metode
            insertEksamensforsøg();
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }
}
