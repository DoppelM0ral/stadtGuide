package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class unterkunftBean {
	String newStayName;
	String newStayCity;
	String newStayPlz;
	String newStay;
	String stayPreis;
	
	Connection dbConn;

	public unterkunftBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newStayName = "";
		this.newStayCity = "";
		this.newStayPlz = "";
		this.newStay = "";
		this.stayPreis = "";
	}
	
	public boolean unterkunftCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select name from addons where plz = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newStayPlz);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	public void unterkunftAnlegen() throws SQLException {
		String sql = "insert into addons (name, stadt, plz, art, kategorie, preisklasse) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newStayName);
		prep.setString(2, this.newStayCity);
		prep.setString(3, this.newStayPlz);
		prep.setString(4, this.newStay);
		prep.setString(5, "Unterkunft");
		prep.setString(6, this.stayPreis);
		prep.executeUpdate();
		System.out.println();
	}

	public String getNewStayName() {
		return newStayName;
	}

	public void setNewStayName(String newStayName) {
		this.newStayName = newStayName;
	}

	public String getNewStayCity() {
		return newStayCity;
	}

	public void setNewStayCity(String newStayCity) {
		this.newStayCity = newStayCity;
	}

	public String getNewStayPlz() {
		return newStayPlz;
	}

	public void setNewStayPlz(String newStayPlz) {
		this.newStayPlz = newStayPlz;
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
