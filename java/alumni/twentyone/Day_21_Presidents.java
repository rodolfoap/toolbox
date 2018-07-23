package org.rap.prgtests.twentyone;

import java.sql.*;

public class Day_21_Presidents {
    public static void main(String[] arguments) {
        String data = "jdbc:JDataConnect://localhost:1150/Presidents";
        try {
            Class.forName("JData2_0.sql.$Driver");
            Connection conn = DriverManager.getConnection(
                data, "", "");
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery(
                "SELECT NAME, ADDRESS1, ADDRESS2, PHONE, E-MAIL " +
                "FROM People Contacts " +
                "ORDER BY NAME");
            while(rec.next()) {
                System.out.println(rec.getString("NAME") +  "\n"
                    + rec.getString("ADDRESS1") + "\n"
                    + rec.getString("ADDRESS2") + "\n"
                    + rec.getString("PHONE") + "\n"
                    + rec.getString("E-MAIL") + "\n");
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}

