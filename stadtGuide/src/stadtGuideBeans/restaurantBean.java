package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class restaurantBean {
	String idRestaurant;
	String newRestName;
	String newRestAdresse;
	String stadtPLZ;
	String guenstigString = "true";
	boolean guenstig;
	String normalString = "true";
	boolean normal;
	String teuerString = "true";
	boolean teuer;
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
		this.stadtPLZ = "";
	}
	
	public boolean restaurantCheck() throws SQLException {
	    String sql = "SELECT id FROM restaurant WHERE UPPER(name) = UPPER(?)";
	    PreparedStatement prep = this.dbConn.prepareStatement(sql);
	    prep.setString(1, this.newRestName);
	    ResultSet dbRes = prep.executeQuery();
	    boolean check = dbRes.next();
	    return check;
	}
	
	public String findNextAvailableId() throws SQLException {
        String sql = "SELECT id FROM restaurant";
        PreparedStatement prep = this.dbConn.prepareStatement(sql);
        ResultSet resultSet = prep.executeQuery();

        List<String> existingIds = new ArrayList<>();

        while (resultSet.next()) {
            existingIds.add(resultSet.getString("id"));
        }

        // Schleife, um die nächste verfügbare ID zu finden
        int counter = 1;
        while (true) {
            String potentialId = "r" + counter;
            if (!existingIds.contains(potentialId)) {
                return potentialId; // Die nächste verfügbare ID gefunden
            }
            counter++;
        }
    }
	
	public void restaurantAnlegen() throws SQLException {
		this.idRestaurant = findNextAvailableId();
		String sql = "insert into restaurant (id, name, adresse, plz, vegan, vegetarisch, halal, pescetarisch, glutenfrei, guenstig, normal, teuer) values (?,?,?,?,?,?,?,?,?,?,?,?)";
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
		prep.setBoolean(10, this.guenstig);
		prep.setBoolean(11, this.normal);
		prep.setBoolean(12, this.teuer);
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

	public boolean isGuenstig() {
		return guenstig;
	}

	public void setGuenstig(boolean guenstig) {
		this.guenstig = guenstig;
	}

	public boolean isNormal() {
		return normal;
	}

	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	public boolean isTeuer() {
		return teuer;
	}

	public void setTeuer(boolean teuer) {
		this.teuer = teuer;
	}
	
}
