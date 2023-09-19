package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class unterkunftBean {
	String newStayName;
	String newStayAdresse;
	String newStay;
	String stayPreis;
	
	Connection dbConn;

	public unterkunftBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newStayName = "";
		this.newStayAdresse = "";
		this.newStay = "";
		this.stayPreis = "";
	}
	
//	public boolean unterkunftCheck() throws SQLException{
//		//true - Stadt existiert - liegt in der Datenbank vor
//		//false - Stadt existiert - liegt nicht in der Datenbank vor
//		String sql = "select name from addons where name = ?";
//		System.out.println(sql);
//		PreparedStatement prep = this.dbConn.prepareStatement(sql);
//		prep.setString(1, this.newStayName);
//		ResultSet dbRes = prep.executeQuery();
//		boolean check = dbRes.next();
//		return check;
//	}
	
	public void unterkunftAnlegen() throws SQLException {
		String sql = "insert into unterkunft (name, adresse unterkunftsart, kategorie, preisklasse) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newStayName);
		prep.setString(2, this.newStayAdresse);
		prep.setString(3, this.newStay);
		prep.setString(4, "Unterkunft");
		prep.setString(5, this.stayPreis);
		prep.executeUpdate();
		System.out.println();
	}

	public String getNewStayName() {
		return newStayName;
	}

	public void setNewStayName(String newStayName) {
		this.newStayName = newStayName;
	}

	public String getNewStayAdresse() {
		return newStayAdresse;
	}

	public void setNewStayAdresse(String newStayAdresse) {
		this.newStayAdresse = newStayAdresse;
	}

	public String getNewStay() {
		return newStay;
	}

	public void setNewStay(String newStay) {
		this.newStay = newStay;
	}

	public String getStayPreis() {
		return stayPreis;
	}

	public void setStayPreis(String stayPreis) {
		this.stayPreis = stayPreis;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
}
