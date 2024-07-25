/* I made get_Emp_Data
Procedure:
Select * from student_detail*/


import java.util.*;
import java.sql.*;

class Callabale1 {
    public static void main(String[] args) throws Exception {
        String drivername = "com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);

        String dburl = "jdbc:mysql://localhost:3306/ishan_database";
        String dbuser = "root";
        String dbpass = "";

        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        if (con != null) {
            System.out.println("Connection succesfull");
        } else {
            System.out.println("Connection Failed");
        }

        // Create Callable Statement
        String sql = "{call get_Emp_Data()}";
        CallableStatement cst = con.prepareCall(sql);
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            System.out.println("Roll No: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Age: " + rs.getInt(3));
            System.out.println("Mobile No: " + rs.getLong(4));
        }

    }
}
