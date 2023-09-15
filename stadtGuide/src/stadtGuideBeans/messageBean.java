package stadtGuideBeans;

public class messageBean {

	String actionMessage;

	public String getAuswahlText() {
		this.actionMessage = "Bitte waehle eine Stadt oder lege eine neue an";
		return actionMessage;
	}
	
	public String getAddStadtText(){
		this.actionMessage = "Bitte lege eine neue Stadt an";
		return actionMessage;
	}
	
	public String getAddToStadtText(){
		this.actionMessage = "Was moechten Sie hinzufuegen?";
		return actionMessage;
	}
	
	public String getAddAktivitaetText(){
		this.actionMessage = "Bitte lege eine neue Aktivitaet an";
		return actionMessage;
	}
	
	public String getAddKulturText(){
		this.actionMessage = "Bitte lege eine neue Kulturunternehmung an";
		return actionMessage;
	}
	
	public String getAddRestaurantText(){
		this.actionMessage = "Bitte lege ein neues Restaurant an";
		return actionMessage;
	}
	
	public String getAddUnterkunftText(){
		this.actionMessage = "Bitte lege eine neue Unterkunft an";
		return actionMessage;
	}
	public String getActionMessage() {
		return actionMessage;
	}
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

}
