package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class addBean {

	String stadtName;
	String stadtPLZ;
	String stadtLand;
	String stadtKreis;
	String stadtEinwohner;
	String stadtSchauen;
	
	Connection dbConn;
	
	public addBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	//Setzt zu Anfang die gegebenen Variablen auf einen leeren String
	public void initialize() {
		this.stadtName = "";
		this.stadtPLZ = "";
		this.stadtLand= "";
		this.stadtKreis = "";
		this.stadtEinwohner = "";
		this.stadtSchauen = "";
	}

	//Check ob Stadt schon angelegt ist
	public boolean stadtCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select stadt from staedte where plz = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.stadtPLZ);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	//Stadt in Datenbank anlegen
	public void stadtAnlegen() throws SQLException{
		String sql = "insert into staedte (stadt, plz, bundesland, kreis, einwohner, schauen) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.stadtName);
		prep.setString(2, this.stadtPLZ);
		prep.setString(3, this.stadtLand);
		prep.setString(4, this.stadtKreis);
		prep.setString(5, this.stadtEinwohner);
		prep.setString(6, this.stadtSchauen);
		prep.executeUpdate();
		System.out.println("Die Stadt " + this.stadtName + " mit der Postleitzahl " + this.stadtPLZ + " wurde erfolgreich angelegt.");
	}

	
	
	//Getter und Setter
	public String getStadtName() {
		return stadtName;
	}

	public void setStadtName(String stadtName) {
		this.stadtName = stadtName;
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