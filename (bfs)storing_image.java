import java.io.*;
import java.sql.*;
import java.util.*;

class BFS1 {
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

        String sql = "insert into bfs(filedetail) values(?)";
        PreparedStatement pst = con.prepareStatement(sql);

        File f = new File("Screenshot (116).png");
        FileInputStream fis = new FileInputStream(f);
        pst.setBinaryStream(1, fis);
        int r = pst.executeUpdate();

        if (r > 0) {
            System.out.println("Insertion Succesfull");
        } else {
            System.out.println("Insertion failed");
        }
    }
}
