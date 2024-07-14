import java.sql.*;

class selc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String drivername = "com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);

        String dburl = "jdbc:mysql://localhost:3306/ishan_database";
        String dbuser = "root";
        String dbpass = "";

        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        if (con != null) {
            System.out.println("Connection Succesfull !");
        } else {
            System.out.println("Connection Failed");
        }

        Statement st = con.createStatement();
        String sql = "select * from student_detail";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Roll No: " + rs.getInt("roll_no"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Mobile no.: " + rs.getLong("phone_no"));
            System.out.println("______________________________________________________");
        }
    }
}
