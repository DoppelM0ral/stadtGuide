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
	String newStay;
	String stayPreis;
	String stadtPLZ;
	
	Connection dbConn;

	public unterkunftBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idUnterkunft = "";
		this.newStayName = "";
		this.newStayAdresse = "";
		this.newStay = "";
		this.stayPreis = "";
		this.stadtPLZ = "";
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
		String sql = "insert into unterkunft (id, name, adresse, plz, unterkunftsart, preisklasse) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idUnterkunft);
		prep.setString(2, this.newStayName);
		prep.setString(3, this.newStayAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setString(5, this.newStay);
		prep.setString(6, this.stayPreis);
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
