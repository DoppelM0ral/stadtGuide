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
	String stadtPLZ;
	String guenstigString = "true";
	boolean guenstig;
	String normalString = "true";
	boolean normal;
	String teuerString = "true";
	boolean teuer;
	boolean sportlich;
	boolean unterhaltung;
	boolean bildung;
	
	Connection dbConn;

	public aktivitaetBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idAktiv = "";
		this.newActivName = "";
		this.newActivAdresse = "";
		this.stadtPLZ = "";
		this.sportlich = false;
		this.unterhaltung = false;
		this.bildung = false;
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
	
	private void convertRadioButtonsToBooleans(String selectedValue) {
        guenstig = "guenstig".equals(selectedValue);
        normal = "normal".equals(selectedValue);
        teuer = "teuer".equals(selectedValue);
    }
	
	public void aktivitaetAnlegen() throws SQLException {
		this.idAktiv = findNextAvailableId();
		String sql = "insert into aktivitaet (id, name, adresse, plz, sportlich, unterhaltung, bildung, guenstig, normal, teuer) values (?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idAktiv);
		prep.setString(2, this.newActivName);
		prep.setString(3, this.newActivAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setBoolean(5, this.sportlich);
		prep.setBoolean(6, this.unterhaltung);
		prep.setBoolean(7, this.bildung);
		prep.setBoolean(8, this.guenstig);
		prep.setBoolean(9, this.normal);
		prep.setBoolean(10, this.teuer);
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

	public boolean isSportlich() {
		return sportlich;
	}

	public void setSportlich(boolean sportlich) {
		this.sportlich = sportlich;
	}

	public boolean isUnterhaltung() {
		return unterhaltung;
	}

	public void setUnterhaltung(boolean unterhaltung) {
		this.unterhaltung = unterhaltung;
	}

	public boolean isBildung() {
		return bildung;
	}

	public void setBildung(boolean bildung) {
		this.bildung = bildung;
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
