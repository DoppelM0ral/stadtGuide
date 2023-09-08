package stadtGuideBeans;

public class applicationBean {
	//Dient Funktionalitäten die für jede Seite der Application relevant sind.
	
	String status = "0";
	
	public applicationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void activate(){
		this.status = "1";
	}

}
