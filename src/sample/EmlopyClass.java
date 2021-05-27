package sample;

import sample.AlertBox;

import java.sql.*;


//utilty calss
public class EmlopyClass {
	 String user,pass,agent,dateTime,arrival,departure;
	 int ID,flight_id;
	 String agent1;
	 Connection con =null;
	 int val;
	 EmlopyClass(String user, String pass){
		 this.user=user;
		 this.pass=pass;
		// this.agent=agent;
	 }
	 EmlopyClass(String user, String pass, String agent, int ID){
		 this.user=user;
		 this.pass=pass;
		 this.agent=agent;
		 this.ID=ID;
	 }
	 EmlopyClass(String user){
		 this.user=user;
		 
	 }
	EmlopyClass(String dateTime, int flight_id,String arrival , String departure){
		this.dateTime=dateTime;
		this.arrival=arrival;
		this.flight_id=flight_id;
		this.departure=departure;
	}

	public EmlopyClass(int flight_id) {
	 	this.flight_id=flight_id;
	}

	boolean checkUser() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airflight", "root", "123456789");
	
	System.out.println("connect the driver");
	Statement state = con.createStatement();
	System.out.println("Create statement");
	ResultSet rs = state.executeQuery("select Emp_Name,passwords From employees;");
	System.out.println("execute statement");
	boolean isAuth=false;

	while(rs.next()) {
		if(user.equals(rs.getString("Emp_Name"))&& pass.equals(rs.getString("passwords"))) {
			System.out.println("lol");
			//agent1 =rs.getString(3);
			//System.out.println(agent);
			isAuth=true;
			break;
			
		}

	}
	if(isAuth==false) {
		AlertBox.display("registration error", "username or password is wrong");
	}
	return isAuth;
}
public String getAgent() {
	return agent1;
}
void addUser() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/smartcity", "root", "123456789");
	String query = "INSERT INTO `smartcity`.`actors` (`personId`, `Username`, `Agent`, `pass`) VALUES (?,?,?,?)";
    System.out.println("query string done!!");
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
	        preparedStmt.setInt (1, ID);
	        preparedStmt.setString (2, user);
	        preparedStmt.setString (3, agent);
	        preparedStmt.setString (4, pass);
	        preparedStmt.execute();
	        con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.print("error 704");
	}
	}
	void deleteUser() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/smartcity", "root", "123456789");
		String sql = "DELETE FROM `smartcity`.`actors` WHERE Username=?";
        PreparedStatement stmt1 = con.prepareStatement(sql);
        stmt1.setString(1, user);
        stmt1.executeUpdate();
		
		
	}
	public void addFlight() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airflight", "root", "123456789");
		String sql = "insert into flight_schedule (FL_ID, Flight_Data, Departure, Arrival) values(?,?,?,?);";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt (1, flight_id);
			preparedStmt.setString (2, dateTime);
			preparedStmt.setString (3, departure);
			preparedStmt.setString (4, arrival);
			preparedStmt.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("error 704");
		}

	}
	public void deleteFlight() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airflight", "root", "123456789");
		String sql = "delete from flight_schedule where FL_ID=?;";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt (1, flight_id);
			preparedStmt.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("error 704");
		}

	}
}
