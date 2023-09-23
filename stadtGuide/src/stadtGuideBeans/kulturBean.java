package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class kulturBean {
	String idKultur;
	String newCultName;
	String newCultAdresse;
	String cultPreis;
	String stadtPLZ;
	boolean museum;
	boolean historisch;
	boolean tour;
	boolean sehenswuerdigkeit;
	
	Connection dbConn;

	public kulturBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idKultur = "";
		this.newCultName = "";
		this.newCultAdresse = "";
		this.cultPreis = "";
		this.stadtPLZ = "";
		this.museum = false;
		this.historisch = false;
		this.tour = false;
		this.sehenswuerdigkeit = false;
	}
	
	public boolean kulturCheck() throws SQLException {
	    String sql = "SELECT id FROM kultur WHERE UPPER(name) = UPPER(?)";
	    PreparedStatement prep = this.dbConn.prepareStatement(sql);
	    prep.setString(1, this.newCultName);
	    ResultSet dbRes = prep.executeQuery();
	    boolean check = dbRes.next();
	    return check;
	}

	 public String findNextAvailableId() throws SQLException {
	        String sql = "SELECT id FROM kultur";
	        PreparedStatement prep = this.dbConn.prepareStatement(sql);
	        ResultSet resultSet = prep.executeQuery();

	        List<String> existingIds = new ArrayList<>();

	        while (resultSet.next()) {
	            existingIds.add(resultSet.getString("id"));
	        }

	        // Schleife, um die nächste verfügbare ID zu finden
	        int counter = 1;
	        while (true) {
	            String potentialId = "k" + counter;
	            if (!existingIds.contains(potentialId)) {
	                return potentialId; // Die nächste verfügbare ID gefunden
	            }
	            counter++;
	        }
	    }

	public void kulturAnlegen() throws SQLException {
		this.idKultur = findNextAvailableId();
		String sql = "insert into kultur (id, name, adresse, plz, museum, historischerPlatz, tour, sehenswuerdigkeit, preisklasse) values (?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idKultur);
		prep.setString(2, this.newCultName);
		prep.setString(3, this.newCultAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setBoolean(5, this.museum);
		prep.setBoolean(6, this.historisch);
		prep.setBoolean(7, this.tour);
		prep.setBoolean(8, this.sehenswuerdigkeit);
		prep.setString(9, this.cultPreis);
		prep.executeUpdate();
		System.out.println();
	}
	
	public String getIdKultur() {
		return idKultur;
	}

	public void setIdKultur(String idKultur) {
		this.idKultur = idKultur;
	}

	public String getNewCultName() {
		return newCultName;
	}

	public void setNewCultName(String newCultName) {
		this.newCultName = newCultName;
	}

	public String getNewCultAdresse() {
		return newCultAdresse;
	}

	public void setNewCultAdresse(String newCultAdresse) {
		this.newCultAdresse = newCultAdresse;
	}

	public String getStadtPLZ() {
		return stadtPLZ;
	}

	public void setStadtPLZ(String stadtPLZ) {
		this.stadtPLZ = stadtPLZ;
	}

	public boolean isMuseum() {
		return museum;
	}

	public void setMuseum(boolean museum) {
		this.museum = museum;
	}

	public boolean isHistorisch() {
		return historisch;
	}

	public void setHistorisch(boolean historisch) {
		this.historisch = historisch;
	}

	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public boolean isSehenswuerdigkeit() {
		return sehenswuerdigkeit;
	}

	public void setSehenswuerdigkeit(boolean sehenswuerdigkeit) {
		this.sehenswuerdigkeit = sehenswuerdigkeit;
	}

	public String getCultPreis() {
		return cultPreis;
	}

	public void setCultPreis(String cultPrice) {
		this.cultPreis = cultPrice;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	
}
