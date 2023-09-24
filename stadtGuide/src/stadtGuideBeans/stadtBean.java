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
	String gesucht; 
	String[] preise;
	String[] options;
	String[] unterkunft;
	String[] kultur;
	String[] aktivitaet;
	boolean firstset;
	
	Connection dbConn;
	
	public stadtBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	//Setzt zu Anfang die gegebenen Variablen auf einen leeren String
	public void initialize() {
		this.stadt = "";
		this.stadtPLZ = "";
		this.stadtLand = "";
		this.stadtKreis = "";
		this.stadtEinwohner = "";
		this.stadtSchauen = "";
		this.gesucht = "";
		this.firstset = false;

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
	
	
	public String getSearchResults(){
		return "";
	}
	
	//Suche nach Datenbank einträgen mit gegebenen Kriterien	
	public void searchResults() throws NoConnectionException, SQLException{
			String output = "";
			String sql = "SELECT * FROM " + this.gesucht;
			
			//Suchoptionen für Restaurant
			if(options!=null){
				sql += "WHERE ( ";
				for(int i=0;i<options.length;i++){
					if(options[i].equals("pescetarisch")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "pescetarisch = true";
					}else if(options[i].equals("vegetarisch")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "vegetarisch = true";
					}else if(options[i].equals("vegan")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "vegan = true";
					}else if(options[i].equals("halal")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "halal = true";
					}else if(options[i].equals("glutenfrei")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "glutenfrei = true";
					}	
			}
			sql += ")";
			firstset=false;
		}
			else if(unterkunft!=null){
				sql += "WHERE ( ";
				for(int i=0;i<unterkunft.length;i++){
					if(unterkunft[i].equals("hotel")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "hotel = true";
					}else if(unterkunft[i].equals("airbnb")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "airbnb = true";
					}else if(unterkunft[i].equals("ferienwohnung")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "ferienwohnung = true";
					}
				}
				sql += ")";
				firstset=false;				
			}
			else if(kultur!=null){
				sql += "WHERE ( ";
				for(int i=0;i<kultur.length;i++){
						if(kultur[i].equals("museum")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "museum = true";
						}else if(kultur[i].equals("historischerplatz")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "historischerplatz = true";
						}else if(kultur[i].equals("tour")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "tour = true";
						}else if(kultur[i].equals("sehenswuerdigkeit")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "sehenswuerdigkeit = true";
						}
					}
					sql += ")";
					firstset=false;
				}
			
			else if(aktivitaet!=null){
				sql += "WHERE ( ";
				for(int i=0;i<aktivitaet.length;i++){
						if(aktivitaet[i].equals("sportlich")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "sportlich = true";
						}else if(aktivitaet[i].equals("unterhaltung")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "unterhaltung = true";
						}else if(aktivitaet[i].equals("bildung")){
							if(firstset==true){
								sql += " OR ";
							}else{
								firstset=true;
							}
							sql += "bildung = true";
						}
					}
				sql += ")";
				firstset=false;
				}
			
			if(preise!=null){
				sql+=" AND (";
				for(int i=0;i<preise.length;i++){
					if(preise[i].equals("cheap")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "guenstig = true";
					}else if(preise[i].equals("normal")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "normal = true";
					}else if(preise[i].equals("expensive")){
						if(firstset==true){
							sql += " OR ";
						}else{
							firstset=true;
						}
						sql += "teuer = true";
					}
				sql+= ")";
				}
			}
			
		
			
			
		//Abfrage der SQL-Query und Speicherung in ResultSet 
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
					prepareStatement(sql).executeQuery();
		
		//Ausgabe der Daten im ResultSet für auflistung
		while (dbRes.next()){
		output += "test " + dbRes.getString("name");
		System.out.println(output);
		}
		if(dbRes.next()==false){
			System.out.println("Leider noch keine Daten vorhanden");
		}
	}
	
	public void setOptionsBoolean(String Options){
		System.out.println(Options);
	}
	
	
	
	
	//Suchfilter HTML Code
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
									"<label><input type='checkbox' name='preis' value='cheap' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='normal' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='expensive' />Teuer<br></label>" +
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
									"<label><input type='checkbox' name='preis' value='cheap' />Günstig<br></label>" +
									"<label><input type='checkbox' name='preis' value='normal' />Normal<br></label>" +
									"<label><input type='checkbox' name='preis' value='expensive' />Teuer<br></label>" +
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

	public String getGesucht() {
		return gesucht;
	}

	public void setGesucht(String gesucht) {
		this.gesucht = gesucht;
	}


	public boolean isFirstset() {
		return firstset;
	}

	public void setFirstset(boolean firstset) {
		this.firstset = firstset;
	}

	public String[] getPreise() {
		return preise;
	}

	public void setPreise(String[] preise) {
		this.preise = preise;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String[] getUnterkunft() {
		return unterkunft;
	}

	public void setUnterkunft(String[] unterkunft) {
		this.unterkunft = unterkunft;
	}

	public String[] getKultur() {
		return kultur;
	}

	public void setKultur(String[] kultur) {
		this.kultur = kultur;
	}

	public String[] getAktivitaet() {
		return aktivitaet;
	}

	public void setAktivitaet(String[] aktivitaet) {
		this.aktivitaet = aktivitaet;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

	
	
	
	
}