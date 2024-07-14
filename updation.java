import java.sql.*;

class upd1 {
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
        String sql = "update student_detail set name='Yash' where roll_no=5";
        int r = st.executeUpdate(sql);

        if (r > 0) {
            System.out.println("Updation Succesfull");
        } else {
            System.out.println("Updation failed");
        }
    }
}
