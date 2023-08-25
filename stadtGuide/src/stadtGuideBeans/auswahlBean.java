package stadtGuideBeans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.PostgreSQLAccess;

public class auswahlBean {
	
	public auswahlBean() {

	}
	
	public String getOptionsSelect() throws SQLException{
		String output = "";
		String sql = "SELECT * FROM staedte";
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
					prepareStatement(sql).executeQuery();
		while (dbRes.next()){
		output += "<option>" + dbRes.getString("stadt") + "</option> \n";
		}
		return output;
	}
}
