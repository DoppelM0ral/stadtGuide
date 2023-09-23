package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class unterkunftBean {
	String idUnterkunft;
	String newStayName;
	String newStayAdresse;
	String stadtPLZ;
	String guenstigString = "true";
	boolean guenstig;
	String normalString = "true";
	boolean normal;
	String teuerString = "true";
	boolean teuer;
	boolean hotel;
	boolean airbnb;
	boolean ferienwohnung;
	
	Connection dbConn;

	public unterkunftBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idUnterkunft = "";
		this.newStayName = "";
		this.newStayAdresse = "";
		this.stadtPLZ = "";
		this.hotel = false;
		this.airbnb = false;
		this.ferienwohnung = false;
	}
	
	public boolean unterkunftCheck() throws SQLException {
	    String sql = "SELECT id FROM unterkunft WHERE UPPER(name) = UPPER(?)";
	    PreparedStatement prep = this.dbConn.prepareStatement(sql);
	    prep.setString(1, this.newStayName);
	    ResultSet dbRes = prep.executeQuery();
	    boolean check = dbRes.next();
	    return check;
	}
	
	public String findNextAvailableId() throws SQLException {
        String sql = "SELECT id FROM unterkunft";
        PreparedStatement prep = this.dbConn.prepareStatement(sql);
        ResultSet resultSet = prep.executeQuery();

        List<String> existingIds = new ArrayList<>();

        while (resultSet.next()) {
            existingIds.add(resultSet.getString("id"));
        }

        // Schleife, um die nächste verfügbare ID zu finden
        int counter = 1;
        while (true) {
            String potentialId = "u" + counter;
            if (!existingIds.contains(potentialId)) {
                return potentialId; // Die nächste verfügbare ID gefunden
            }
            counter++;
        }
    }
	
	public void unterkunftAnlegen() throws SQLException {
		this.idUnterkunft = findNextAvailableId();
		String sql = "insert into unterkunft (id, name, adresse, plz, hotel, airbnb, ferienwohnung, guenstig, normal, teuer) values (?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idUnterkunft);
		prep.setString(2, this.newStayName);
		prep.setString(3, this.newStayAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setBoolean(5, this.hotel);
		prep.setBoolean(6, this.airbnb);
		prep.setBoolean(7, this.ferienwohnung);
		prep.setBoolean(8, this.guenstig);
		prep.setBoolean(9, this.normal);
		prep.setBoolean(10, this.teuer);
		prep.executeUpdate();
		System.out.println();
	}

	public String getIdUnterkunft() {
		return idUnterkunft;
	}

	public void setIdUnterkunft(String idUnterkunft) {
		this.idUnterkunft = idUnterkunft;
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

	public String getStadtPLZ() {
		return stadtPLZ;
	}

	public void setStadtPLZ(String stadtPLZ) {
		this.stadtPLZ = stadtPLZ;
	}

	public boolean isHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public boolean isAirbnb() {
		return airbnb;
	}

	public void setAirbnb(boolean airbnb) {
		this.airbnb = airbnb;
	}

	public boolean isFerienwohnung() {
		return ferienwohnung;
	}

	public void setFerienwohnung(boolean ferienwohnung) {
		this.ferienwohnung = ferienwohnung;
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

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
}
