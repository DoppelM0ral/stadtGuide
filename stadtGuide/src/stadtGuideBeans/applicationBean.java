package stadtGuideBeans;

public class applicationBean {
	//Dient Funktionalit�ten die f�r jede Seite der Application relevant sind.
	
	String status = "0";
	
	public applicationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void activate(){
		this.status = "1";
	}

}
