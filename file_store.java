import java.io.File;
import java.io.FileReader;
import java.sql.*;

class fw {
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

        // Create Statement

        Statement st = con.createStatement();
        String sql = "insert into file_store(f_name,f_size,f_extension,f_content) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        // For f_name

        File f = new File("F://ex6.java");
        String fn = f.getName();
        ps.setString(1, fn);

        // For f_size

        Long l = f.length();
        Double fs_kb = l / 1024.0;
        ps.setDouble(2, fs_kb);

        // For f_extension

        String ex = fn.substring(fn.lastIndexOf("."));
        ps.setString(3, ex);

        // For f_content

        FileReader fr = new FileReader(f);
        ps.setCharacterStream(4, fr);

        int r = ps.executeUpdate();

        if (r > 0) {
            System.out.println("Insertion Succesfull");
        } else {
            System.out.println("Insertion failed");
        }

    }
}
