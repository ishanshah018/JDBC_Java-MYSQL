/*
Parameters
1  IN nm Varchar
2  IN ag  INT
3  IN ph  BIGINT
4  IN rl INT
5  IN nam Varchar
Procedure Queries
BEGIN
INSERT INTO student_detail(name,age,phone_no) values(nm,ag,ph);

UPDATE student_detail SET name=nam WHERE roll_no=rl;
END
*/

import java.util.*;
import java.sql.*;

class Callabale3 {
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

        String sql = "{call manipulate_emp_data(?,?,?,?,?)}";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, "Callable");
        cst.setInt(2, 35);
        cst.setLong(3, 9898989898l);
        cst.setInt(4, 3);
        cst.setString(5, "Upd_by_callable");
        cst.executeUpdate();
    }
}
