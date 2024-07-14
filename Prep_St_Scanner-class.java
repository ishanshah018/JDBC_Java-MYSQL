// import java.sql.*;

// class prep {
//     public static void main(String[] args) throws ClassNotFoundException, SQLException {
//         String drivername = "com.mysql.cj.jdbc.Driver";
//         Class.forName(drivername);

//         String dburl = "jdbc:mysql://localhost:3306/ishan_database";
//         String dbuser = "root";
//         String dbpass = "";

//         Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

//         if (con != null) {
//             System.out.println("Connection Succesfull");
//         } else {
//             System.out.println("Connection Failed");
//         }

//         Statement st = con.createStatement();
//         String sql = "insert into student_detail(name,age,phone_no)values(?,?,?)";

//         PreparedStatement pst = con.prepareStatement(sql);
//         pst.setString(1, "Prepare2");
//         pst.setInt(2, 18);
//         pst.setLong(3, 9090908767l);

//         int r = pst.executeUpdate();

//         if (r > 0) {
//             System.out.println("Insertion Succesfull");
//         } else {
//             System.out.println("Insertion failed");
//         }

//     }
// }

//Using Scanner class

import java.sql.*;
import java.util.*;

class prep {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String drivername = "com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);

        String dburl = "jdbc:mysql://localhost:3306/ishan_database";
        String dbuser = "root";
        String dbpass = "";

        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        if (con != null) {
            System.out.println("Connection Succesfull");
        } else {
            System.out.println("Connection Failed");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String nm = sc.next();

        System.out.println("Enter Age");
        int ag = sc.nextInt();

        System.out.println("Enter Phone No.: ");
        Long ph = sc.nextLong();

        Statement st = con.createStatement();
        String sql = "insert into student_detail(name,age,phone_no)values(?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nm);
        pst.setInt(2, ag);
        pst.setLong(3, ph);

        int r = pst.executeUpdate();

        if (r > 0) {
            System.out.println("Insertion Succesfull");
        } else {
            System.out.println("Insertion failed");
        }

    }
}
