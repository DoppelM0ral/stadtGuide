package stadtGuideBeans;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class stadtBean {

	String stadt;
	String stadtPLZ;
	String stadtLand;
	String stadtKreis;
	String stadtEinwohner;
	String stadtSchauen;
	
	Connection dbConn;
	
	public stadtBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	//Setzt zu Anfang die gegebenen Variablen auf einen leeren String
	public void initialize() {
		this.stadt = "";
		this.stadtPLZ = "";
		this.stadtLand= "";
		this.stadtKreis = "";
		this.stadtEinwohner = "";
		this.stadtSchauen = "";
	}

	//Setzt die Variablen auf die Ausgaben der Datenbank
	public void data() throws NoConnectionException, SQLException{
		String sql = "SELECT * FROM bwi520_633877.staedte WHERE stadt = '" + this.stadt + "'";
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
					prepareStatement(sql).executeQuery();
			if(dbRes.next()){
			this.stadtPLZ = dbRes.getString("plz");
			this.stadtLand= dbRes.getString("bundesland");
			this.stadtKreis = dbRes.getString("kreis");
			this.stadtEinwohner = dbRes.getString("einwohner");
			this.stadtSchauen = dbRes.getString("schauen");
			}
	}
	
	
	
	
	
	
	//Getter und Setter
	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStadtPLZ() {
		return stadtPLZ;
	}

	public void setStadtPLZ(String stadtPLZ) {
		this.stadtPLZ = stadtPLZ;
	}

	public String getStadtLand() {
		return stadtLand;
	}

	public void setStadtLand(String stadtLand) {
		this.stadtLand = stadtLand;
	}

	public String getStadtKreis() {
		return stadtKreis;
	}

	public void setStadtKreis(String stadtKreis) {
		this.stadtKreis = stadtKreis;
	}

	public String getStadtEinwohner() {
		return stadtEinwohner;
	}

	public void setStadtEinwohner(String stadtEinwohner) {
		this.stadtEinwohner = stadtEinwohner;
	}

	public String getStadtSchauen() {
		return stadtSchauen;
	}

	public void setStadtSchauen(String stadtSchauen) {
		this.stadtSchauen = stadtSchauen;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	
}