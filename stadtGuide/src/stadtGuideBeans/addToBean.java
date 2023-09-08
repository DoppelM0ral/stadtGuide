package stadtGuideBeans;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;


import jdbc.NoConnectionException;
import jdbc.PostgreSQLAccess;

public class addToBean {

	String addToStadt;
	
	public addToBean() throws NoConnectionException {

		this.initialize();
	}
	
	//Setzt zu Anfang die gegebenen Variablen auf einen leeren String
	public void initialize() {
		this.addToStadt = "";

	}




	
	
	//Getter und Setter

	public String getAddToStadt() {
		return addToStadt;
	}

	public void setAddToStadt(String addToStadt) {
		this.addToStadt = addToStadt;
	}
	
}