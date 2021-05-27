import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class test {

    public static void main(String[] args) throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airflight", "root", "123456789");
        System.out.println("connect the driver");
        Statement state = con.createStatement();
        System.out.println("Create statement");
        ResultSet rs = state.executeQuery("select Emp_Name,password From employees;");
        System.out.println("execute statement");
        while (rs.next()){
            String name=rs.getString("Emp_Name");
            String pas=rs.getString("password");
            System.out.println(" "+name+" "+pas);
        }
    }
}
