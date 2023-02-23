package JDBC2023.DAOS_lek6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class OPG16 {
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;

    public static void tabelTilList() {
        ArrayList<Person> list = new ArrayList<>();
        try {
            String sql = "select rytternavn, init from rytter";
            System.out.println("SQL-streng er " + sql);
            ResultSet res = stmt.executeQuery(sql);
            //gennemløber svaret
            while (res.next()) {
                list.add(new Person(res.getString(1), res.getString(2)));
            }
            System.out.println(list);

            // pæn lukning
            if (!minConnection.isClosed()) minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            inLine = new BufferedReader(new InputStreamReader(System.in));
            String server = "localhost";
            String dbnavn = "lektion3";
            String login = "sa";
            String password = "Jeger25%datamatiker";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://" + server + ";databaseName=" + dbnavn +
                    ";user=" + login + ";password=" + password + ";");
            stmt = minConnection.createStatement();
            tabelTilList();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




}
