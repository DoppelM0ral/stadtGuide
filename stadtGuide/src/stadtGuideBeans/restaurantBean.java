package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class restaurantBean {
	String idRestaurant;
	String newRestName;
	String newRestAdresse;
	String restPreis;
	String stadtPLZ;
	String veganString = "true";
	boolean vegan;
	String vegetarischString = "true";
	boolean vegetarisch;
	String halalString = "true";
	boolean halal;
	String pescetarischString = "true";
	boolean pescetarisch;
	String glutenfreiString = "true";
	boolean glutenfrei;
	
	Connection dbConn;

	public restaurantBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idRestaurant = "";
		this.newRestName = "";
		this.newRestAdresse = "";
		this.restPreis = "";
		this.stadtPLZ = "";
	}
	
//	public boolean restaurantCheck() throws SQLException{
//		//true - Stadt existiert - liegt in der Datenbank vor
//		//false - Stadt existiert - liegt nicht in der Datenbank vor
//		String sql = "select name from restaurants where plz = ?";
//		System.out.println(sql);
//		PreparedStatement prep = this.dbConn.prepareStatement(sql);
//		prep.setString(1, this.stadtPLZ);
//		ResultSet dbRes = prep.executeQuery();
//		boolean check = dbRes.next();
//		return check;
//	}
	
	public void restaurantAnlegen() throws SQLException {
		String sql = "insert into restaurants (id, name, adresse, vegan, vegetarisch, halal, pescetarisch, glutenfrei, preisklasse) values (?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idRestaurant);
		prep.setString(2, this.newRestName);
		prep.setString(3, this.newRestAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setBoolean(5, this.vegan);
		prep.setBoolean(6, this.vegetarisch);
		prep.setBoolean(7, this.halal);
		prep.setBoolean(8, this.pescetarisch);
		prep.setBoolean(9, this.glutenfrei);
		prep.setString(10, this.restPreis);
		prep.executeUpdate();
		System.out.println();
	}
	
	public String getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(String idRestaurant) {
		this.idRestaurant = idRestaurant;
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

	public boolean isPescetarisch() {
		return pescetarisch;
	}

	public void setPescetarisch(boolean pescetarisch) {
		this.pescetarisch = pescetarisch;
	}

	public boolean isGlutenfrei() {
		return glutenfrei;
	}

	public void setGlutenfrei(boolean glutenfrei) {
		this.glutenfrei = glutenfrei;
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
	
	public String getStadtPLZ() {
		return stadtPLZ;
	}

	public void setStadtPLZ(String stadtPLZ) {
		this.stadtPLZ = stadtPLZ;
	}

	public String getRestPreis() {
		return restPreis;
	}

	public void setRestPreis(String restPreis) {
		this.restPreis = restPreis;
	}
	
	
}
