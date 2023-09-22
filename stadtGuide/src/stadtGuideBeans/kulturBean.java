package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class kulturBean {
	String idKultur;
	String newCultName;
	String newCultAdresse;
	String newCult;
	String cultPreis;
	String stadtPLZ;
	
	Connection dbConn;

	public kulturBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.idKultur = "";
		this.newCultName = "";
		this.newCultAdresse = "";
		this.newCult = "";
		this.cultPreis = "";
		this.stadtPLZ = "";
	}
	
//	public boolean kulturCheck() throws SQLException{
//		//true - Stadt existiert - liegt in der Datenbank vor
//		//false - Stadt existiert - liegt nicht in der Datenbank vor
//		String sql = "select name from kultur where plz = ?";
//		System.out.println(sql);
//		PreparedStatement prep = this.dbConn.prepareStatement(sql);
//		prep.setString(1, this.stadtPLZ);
//		ResultSet dbRes = prep.executeQuery();
//		boolean check = dbRes.next();
//		return check;
//	}
//	public void data() throws NoConnectionException, SQLException{
//		String sql = "SELECT plz FROM staedte WHERE stadt = '" + this.stadt+ "'";
//		ResultSet dbRes = new PostgreSQLAccess().getConnection().
//					prepareStatement(sql).executeQuery();
//			if(dbRes.next()){
//			this.stadtPLZ = dbRes.getString("plz");
//			}
//	}
	
//	public int zaehler() {
//		int counter = 0;
//		counter++;
//		return counter;
//	}
	int counter = 0;
	public String zaehlerID() {
		this.counter++;
		String idKultur = "k" + this.counter;
	    return idKultur;
	}
	
	public void kulturAnlegen() throws SQLException {
		String sql = "insert into kultur (id, name, adresse, plz, kulturaktivitaet, preisklasse) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.idKultur);
		prep.setString(2, this.newCultName);
		prep.setString(3, this.newCultAdresse);
		prep.setString(4, this.stadtPLZ);
		prep.setString(5, this.newCult);
		prep.setString(6, this.cultPreis);
		prep.executeUpdate();
		System.out.println();
	}
//	public void insertUser(String name) {
//        try {
//            String insertQuery = "INSERT INTO kultur (unique_id, name) VALUES (DEFAULT, ?)";
//            PreparedStatement preparedStatement = this.dbConn.prepareStatement(insertQuery);
//            preparedStatement.setString(1, name);
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//	public String plz() {
//	try {
//	    
//	    // Abfrage zum Abrufen des Strings aus der Quelltabelle
//	    String sqlSelect = "SELECT plz FROM staedte WHERE plz = '"+this.stadtPLZ+"'";
//	    PreparedStatement selectStatement = this.dbConn.prepareStatement(sqlSelect);
//	    selectStatement.setString(1, this.stadtPLZ); // Anpassen
//	    ResultSet resultSet = selectStatement.executeQuery();
//	    
//	    if (resultSet.next()) {
//	        String gespeicherterString = resultSet.getString("plz");
//	        
//	        // Abfrage zum Einfügen des Strings in die Ziel-Tabelle
//	        String sqlInsert = "INSERT INTO restaurants (plz) VALUES (?)";
//	        PreparedStatement insertStatement = this.dbConn.prepareStatement(sqlInsert);
//	        insertStatement.setString(1, gespeicherterString);
//	        
//	        // SQL-Abfrage zum Einfügen ausführen
//	        insertStatement.executeUpdate();
//	        
//	        // Ressourcen schließen
//	        insertStatement.close();
//	    }
//	    
//	    // Ressourcen schließen
//	    resultSet.close();
//	    selectStatement.close();
//	} catch (SQLException e) {
//	    e.printStackTrace();
//	}
//	
//	}
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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

	public String getNewCult() {
		return newCult;
	}

	public void setNewCult(String newCult) {
		this.newCult = newCult;
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
