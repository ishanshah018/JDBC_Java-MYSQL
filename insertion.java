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
        Statement st = con.createStatement();
        String sql = "insert into student_detail(roll_no,name,age,phone_no) values(1,'Ishan',18,9876543210)";
        int r = st.executeUpdate(sql);

        if (r > 0) {
            System.out.println("Insertiom Succesfull");
        } else {
            System.out.println("Insertion failed");
        }
    }
}
