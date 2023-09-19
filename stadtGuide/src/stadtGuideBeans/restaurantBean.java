package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class restaurantBean {
	String newRestName;
	String newRestAdresse;
	String restPreis;
	boolean vegan;
	boolean vegetarisch;
	boolean halal;
	
	Connection dbConn;

	public restaurantBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newRestName = "";
		this.newRestAdresse = "";
		this.restPreis = "";
	}
	
//	public boolean restaurantCheck() throws SQLException{
//		//true - Stadt existiert - liegt in der Datenbank vor
//		//false - Stadt existiert - liegt nicht in der Datenbank vor
//		String sql = "select name from restaurants where plz = ?";
//		System.out.println(sql);
//		PreparedStatement prep = this.dbConn.prepareStatement(sql);
//		prep.setString(1, this.newRestName);
//		ResultSet dbRes = prep.executeQuery();
//		boolean check = dbRes.next();
//		return check;
//	}
	
	public void restaurantAnlegen() throws SQLException {
		String sql = "insert into restaurants (name, adresse, vegan, vegetarisch, halal, kategorie, preisklasse) values (?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newRestName);
		prep.setString(2, this.newRestAdresse);
		prep.setBoolean(3, this.vegan);
		prep.setBoolean(4, this.vegetarisch);
		prep.setBoolean(5, this.halal);
		prep.setString(6, "Restaurant");
		prep.setString(7, this.restPreis);
		prep.executeUpdate();
		System.out.println();
	}
	
	public Connection getDbConn() {
		return dbConn;
	}
	
	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isVegetarisch() {
		return vegetarisch;
	}

	public void setVegetarisch(boolean vegetarisch) {
		this.vegetarisch = vegetarisch;
	}

	public boolean isHalal() {
		return halal;
	}

	public void setHalal(boolean halal) {
		this.halal = halal;
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

	public String getNewRestAdresse() {
		return newRestAdresse;
	}

	public void setNewRestAdresse(String newRestAdresse) {
		this.newRestAdresse = newRestAdresse;
	}

	
	public String getRestPreis() {
		return restPreis;
	}

	public void setRestPreis(String restPreis) {
		this.restPreis = restPreis;
	}
	
	
}
