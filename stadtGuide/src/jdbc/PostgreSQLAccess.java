package jdbc;

public class PostgreSQLAccess extends JDBCAccess {

	public PostgreSQLAccess() throws NoConnectionException {
		super();
	}
	public void setDBParms(){
		dbDrivername = "org.postgresql.Driver";
		dbURL        = "jdbc:postgresql://143.93.200.243:5435/BWUEBDB";
		dbUser       = "user1";
		dbPassword   = "pgusers";
		dbSchema     = "bwi520_633877"; // Schema in dem wir arbeiten
		
	}
	public static void main(String[] args) throws NoConnectionException { 
		new PostgreSQLAccess().getConnection();
	}
}