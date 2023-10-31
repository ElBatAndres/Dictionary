package co.edu.uptc.model;

public class Translation {
	private String spanish, english, french;

	public Translation(String spanish, String english, String french) {
		this.spanish = spanish;
		this.english = english;
		this.french = french;
	}
	
	public Translation() {
		
	}

	public String getSpanish() {
		return spanish;
	}

	public String getEnglish() {
		return english;
	}

	public String getFrench() {
		return french;
	}

	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public void setFrench(String french) {
		this.french = french;
	}

	@Override
	public String toString() {
		return "Translation [spanish=" + spanish + ", english=" + english + ", french=" + french + "]";
	}
	
}
