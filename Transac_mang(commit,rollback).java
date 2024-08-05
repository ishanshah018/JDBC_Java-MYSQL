import java.sql.*;
import java.util.*;

class Transaction1 {
    public static void main(String[] args) throws Exception {
        String drivername = "com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);

        String dburl = "jdbc:mysql://localhost:3306/ishan_database";
        String dbname = "root";
        String dbpass = "";

        Connection con = DriverManager.getConnection(dburl, dbname, dbpass);

        if (con != null) {
            System.out.println("Connection Successfull..");
        } else {
            System.out.println("Connection Failed !!");
        }

        con.setAutoCommit(false);

        String sql = "delete from student_detail where roll_no=3";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.executeUpdate();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Choice \n 1)Commit \n 2)Rollback ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                con.commit();
                break;

            case 2:
                con.rollback();
                break;

            default:
                System.out.println("Enter Valid Choice..");
                break;
        }
    }
}
