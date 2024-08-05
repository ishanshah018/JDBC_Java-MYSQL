import java.io.*;
import java.sql.*;
import java.util.*;

class BFS2 {
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

        String sql = "select filedetail from bfs";
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Blob b = rs.getBlob(1);
            byte[] b1 = b.getBytes(1, (int) b.length());

            FileOutputStream fos = new FileOutputStream("retrive.png");
            fos.write(b1);
            fos.close();
        }
    }
}
