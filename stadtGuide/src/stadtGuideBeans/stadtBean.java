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
	
	
	
	
	
	//Suchfilter
	public String getHiddenRestaurant(){
		String output =
						"<table id='restaurant' class='hidden'>\n" +
							"<tr>\n" +
								"<td colspan='2' >\n" + 
									"Variationen" +
								"</td>\n" + 
								"<td colspan='2'>\n" +
									"Preise" +
								"</td>\n" +
							"</tr>\n" +
							"<tr>\n" +
								"<td>\n" + 
									"<label><input type='checkbox' name='options' value='pescetarisch' />Pescetarisch<br></label>\n" +
									"<label><input type='checkbox' name='options' value='vegetarisch' />Vegetarisch<br></label>" +
									"<label><input type='checkbox' name='options' value='vegan' />Vegan<br></label>\n" +
								"</td>\n" +
								"<td>\n" +
									"<label><input type='checkbox' name='options' value='glutenfrei' />Glutenfrei<br></label>\n" +
									"<label><input type='checkbox' name='options' value='halal' />Halal<br></label>" +
								"</td>\n" +
								"<td width='35%'>\n" +
									"<label><input type='checkbox' name='preis' value='cheap' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='normal' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='expensive' />Teuer<br></label>" +
								"</td>\n" +				
							"</tr>\n" +
						"</table>";		
		return output;
	}
	
	public String getHiddenUnterkunft(){
		String output =
						"<table id='unterkunft' class='hidden'>\n" +
							"<tr>\n" +
								"<td colspan='2' >\n" + 
									"Art der Unterkunft" +
								"</td>\n" + 
								"<td colspan='2'>\n" +
									"Preise" +
								"</td>\n" +
							"</tr>\n" +
							"<tr>\n" +
								"<td>\n" + 
									"<label><input type='checkbox' name='unterkunft' value='hotel' />Hotel<br></label>\n" +
									"<label><input type='checkbox' name='unterkunft' value='airbnb' />AirBnB<br></label>" +
									"<label><input type='checkbox' name='unterkunft' value='ferienwohnung' />Ferienwohnung<br></label>\n" +
								"</td>\n" +
								"<td width='35%'>\n" +
									"<label><input type='checkbox' name='preis' value='cheap' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='normal' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='expensive' />Teuer<br></label>" +
								"</td>\n" +				
							"</tr>\n" +
						"</table>";		
		return output;
	}
	public String getHiddenKultur(){
		String output =
						"<table id='kultur' class='hidden'>\n" +
							"<tr>\n" +
								"<td colspan='2' >\n" + 
									"Art der Kultur" +
								"</td>\n" + 
								"<td colspan='2'>\n" +
									"Preise" +
								"</td>\n" +
							"</tr>\n" +
							"<tr>\n" +
								"<td '>\n" + 
									"<label><input type='checkbox' name='kultur' value='museum' />Museum<br></label>\n" +
									"<label><input type='checkbox' name='kultur' value='historischerplatz' />Historischer Platz<br></label>" +
									"<label><input type='checkbox' name='kultur' value='tour' />Tour<br></label>\n" +
								"</td>\n" +
								"<td>\n" + 
									"<label><input type='checkbox' name='kultur' value='sehenswuerdigkeit' />Sehenswürdigkeit<br></label>\n" +
									"<label><input type='checkbox' name='kultur' value='sonstiges' />Sonstiges<br></label>" +
							"</td>\n" +	
								"<td >\n" +
									"<label><input type='checkbox' name='preis' value='' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='' />Teuer<br></label>" +
								"</td>\n" +				
							"</tr>\n" +
						"</table>";		
		return output;
	}
	public String getHiddenAktivitaet(){
		String output =
						"<table id='aktivitaet' class='hidden'>\n" +
							"<tr>\n" +
								"<td colspan='2'>\n" +
									"Preise" +
								"</td>\n" +
							"</tr>\n" +
							"<tr>\n" +
								"<td width='35%'>\n" +
									"<label><input type='checkbox' name='preis' value='' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='' />Teuer<br></label>" +
								"</td>\n" +				
							"</tr>\n" +
						"</table>";		
		return output;
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