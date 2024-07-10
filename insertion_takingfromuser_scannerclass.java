// TAKING DATA FROM USER USING SCANNER CLASS

import java.util.*;
import java.sql.*;

class connect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1) Load Drivers.
        String drivername = "com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);

        // 2) Create Connection
        String dburl = "jdbc:mysql://localhost:3306/ishan_database";
        String dbuser = "root";
        String dbpass = "";
        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        if (con != null) {
            System.out.println("Connection Succesfull");
        } else {
            System.out.println("Connection Failed");
        }

        // 3) Create Statement
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Student data you have to Insert");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Name of Student " + (i + 1) + ": ");
            String name = sc.next();

            System.out.println("Enter Age of Student " + (i + 1) + ": ");
            int age = sc.nextInt();

            System.out.println("Enter Mobile number of Student " + (i + 1) + ": ");
            long mob = sc.nextLong();

            Statement st = con.createStatement();

            String sql = "insert into student_detail(name,age,phone_no) values('" + name + "'," + age + ","
                    + mob + ")";
            int r = st.executeUpdate(sql);

            if (r > 0) {
                System.out.println("Insertiom Succesfull");
            } else {
                System.out.println("Insertion failed");
            }
        }
    }
}
