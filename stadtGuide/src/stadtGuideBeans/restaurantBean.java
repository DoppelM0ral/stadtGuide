package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class restaurantBean {
	String newRestName;
	String newRestCity;
	String newRestPlz;
	String newRestFood;
	String nourish;
	String restPreis;
	
	Connection dbConn;

	public restaurantBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newRestName = "";
		this.newRestCity = "";
		this.newRestPlz = "";
		this.newRestFood = "";
		this.nourish = "";
		this.restPreis = "";
	}
	
	public boolean restaurantCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select name from addons where plz = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newRestPlz);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	public void restaurantAnlegen() throws SQLException {
		String sql = "insert into addons (name, stadt, plz, art, kategorie) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newRestName);
		prep.setString(2, this.newRestCity);
		prep.setString(3, this.newRestPlz);
		prep.setString(4, this.newRestFood);
		prep.setString(5, "Restaurant");
		prep.setString(6, this.restPreis);
		prep.executeUpdate();
		System.out.println();
	}
	
	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

	public String getNewRestName() {
		return newRestName;
	}

	public void setNewRestName(String newRestName) {
		this.newRestName = newRestName;
	}

	public String getNewRestCity() {
		return newRestCity;
	}

	public void setNewRestCity(String newRestCity) {
		this.newRestCity = newRestCity;
	}

	public String getNewRestPlz() {
		return newRestPlz;
	}

	public void setNewRestPlz(String newRestPlz) {
		this.newRestPlz = newRestPlz;
	}

	public String getNewRestFood() {
		return newRestFood;
	}

	public void setNewRestFood(String newRestFood) {
		this.newRestFood = newRestFood;
	}

	public String getNourish() {
		return nourish;
	}

	public void setNourish(String nourish) {
		this.nourish = nourish;
	}

	public String getRestPreis() {
		return restPreis;
	}

	public void setRestPreis(String restPreis) {
		this.restPreis = restPreis;
	}
	
	
}
