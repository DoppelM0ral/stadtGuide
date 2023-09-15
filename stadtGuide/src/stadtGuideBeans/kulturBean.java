package stadtGuideBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class kulturBean {
	String newCultName;
	String newCultCity;
	String newCultPlz;
	String newCult;
	String cultPrice;
	
	Connection dbConn;

	public kulturBean() throws NoConnectionException {
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.initialize();
	}
	
	public void initialize() {
		this.newCultName = "";
		this.newCultCity = "";
		this.newCultPlz = "";
		this.newCult = "";
		this.cultPrice = "";
	}
	
	public boolean stadtCheck() throws SQLException{
		//true - Stadt existiert - liegt in der Datenbank vor
		//false - Stadt existiert - liegt nicht in der Datenbank vor
		String sql = "select stadt from staedte where plz = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newCultPlz);
		ResultSet dbRes = prep.executeQuery();
		boolean check = dbRes.next();
		return check;
	}
	
	public void kulturAnlegen() throws SQLException {
		String sql = "insert into staedte (stadt, plz, bundesland, kreis, einwohner, schauen) values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.newCultName);
		prep.setString(2, this.newCultCity);
		prep.setString(3, this.newCultPlz);
		prep.setString(4, this.newCult);
		prep.setString(5, "Kultur");
		prep.setString(6, this.cultPrice);
		prep.executeUpdate();
		System.out.println();
	}

	public String getNewCultName() {
		return newCultName;
	}

	public void setNewCultName(String newCultName) {
		this.newCultName = newCultName;
	}

	public String getNewCultCity() {
		return newCultCity;
	}

	public void setNewCultCity(String newCultCity) {
		this.newCultCity = newCultCity;
	}

	public String getNewCultPlz() {
		return newCultPlz;
	}

	public void setNewCultPlz(String newCultPlz) {
		this.newCultPlz = newCultPlz;
	}

	public String getNewCult() {
		return newCult;
	}

	public void setNewCult(String newCult) {
		this.newCult = newCult;
	}

	public String getCultPrice() {
		return cultPrice;
	}

	public void setCultPrice(String cultPrice) {
		this.cultPrice = cultPrice;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	
}
