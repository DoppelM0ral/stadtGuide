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
	String nourish;
	String restPreis;
	
	Connection dbConn;

	public restaurantBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newRestName = "";
		this.newRestAdresse = "";
		this.nourish = "";
		this.restPreis = "";
	}
	
	public boolean restaurantCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select name from addons where name = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newRestName);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	public void restaurantAnlegen() throws SQLException {
		String sql = "insert into addons (name, adresse, art, kategorie, preisklasse) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newRestName);
		prep.setString(2, this.newRestAdresse);
		prep.setString(3, this.nourish);
		prep.setString(4, "Restaurant");
		prep.setString(5, this.restPreis);
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

	public String getNewRestAdresse() {
		return newRestAdresse;
	}

	public void setNewRestAdresse(String newRestAdresse) {
		this.newRestAdresse = newRestAdresse;
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
