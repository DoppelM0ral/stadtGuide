package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class aktivitaetBean {
	String idAktiv;
	String newActivName;
	String newActivAdresse;
	String newActivity;
	String activePreis;
	String stadtPLZ;
	
	Connection dbConn;

	public aktivitaetBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idAktiv = "";
		this.newActivName = "";
		this.newActivAdresse = "";
		this.newActivity = "";
		this.activePreis = "";
		this.stadtPLZ = "";
	}
	
	public boolean aktivitaetCheck() throws SQLException {
	    String sql = "SELECT id FROM aktivitaet WHERE UPPER(name) = UPPER(?)";
	    PreparedStatement prep = this.dbConn.prepareStatement(sql);
	    prep.setString(1, this.newActivName);
	    ResultSet dbRes = prep.executeQuery();
	    boolean check = dbRes.next();
	    return check;
	}
	
	public String findNextAvailableId() throws SQLException {
        String sql = "SELECT id FROM aktivitaet";
        PreparedStatement prep = this.dbConn.prepareStatement(sql);
        ResultSet resultSet = prep.executeQuery();

        List<String> existingIds = new ArrayList<>();

        while (resultSet.next()) {
            existingIds.add(resultSet.getString("id"));
        }

        // Schleife, um die nächste verfügbare ID zu finden
        int counter = 1;
        while (true) {
            String potentialId = "a" + counter;
            if (!existingIds.contains(potentialId)) {
                return potentialId; // Die nächste verfügbare ID gefunden
            }
            counter++;
        }
    }
	
	public void aktivitaetAnlegen() throws SQLException {
		this.idAktiv = findNextAvailableId();
		String sql = "insert into aktivitaet (id, name, adresse, plz, aktivitaetsart, preisklasse) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idAktiv);
		prep.setString(2, this.newActivName);
		prep.setString(3, this.newActivAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setString(5, this.newActivity);
		prep.setString(6, this.activePreis);
		prep.executeUpdate();
		System.out.println();
	}

	public String getIdAktiv() {
		return idAktiv;
	}

	public void setIdAktiv(String idAktiv) {
		this.idAktiv = idAktiv;
	}

	public String getNewActivName() {
		return newActivName;
	}

	public void setNewActivName(String newActivName) {
		this.newActivName = newActivName;
	}

	public String getNewActivAdresse() {
		return newActivAdresse;
	}

	public void setNewActivAdresse(String newActivAdresse) {
		this.newActivAdresse = newActivAdresse;
	}

	public String getStadtPLZ() {
		return stadtPLZ;
	}

	public void setStadtPLZ(String stadtPLZ) {
		this.stadtPLZ = stadtPLZ;
	}

	public String getNewActivity() {
		return newActivity;
	}

	public void setNewActivity(String newActivity) {
		this.newActivity = newActivity;
	}

	public String getActivePreis() {
		return activePreis;
	}

	public void setActivePreis(String activePreis) {
		this.activePreis = activePreis;
	}
	
	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
}
