package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class aktivitaetBean {
	String newActivName;
	String newActivAdresse;
	String newActivity;
	String activePreis;
	
	Connection dbConn;

	public aktivitaetBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newActivName = "";
		this.newActivAdresse = "";
		this.newActivity = "";
		this.activePreis = "";
	}
	
	public boolean aktivitaetCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select name from addons where name = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newActivName);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	public void aktivitaetAnlegen() throws SQLException {
		String sql = "insert into addons (name, adresse, art, kategorie, preisklasse) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newActivName);
		prep.setString(2, this.newActivAdresse);
		prep.setString(3, this.newActivity);
		prep.setString(4, "Aktivitaet");
		prep.setString(5, this.activePreis);
		prep.executeUpdate();
		System.out.println();
	}
	
	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
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
}
