package tetrisProcessing;

public enum Colour {
	GREY("element_grey_square.png"),
	BLUE("element_blue_square.png"),
	GREEN("element_green_square.png"),
	PURPLE("element_purple_square.png"),
	RED("element_red_square.png"),
	YELLOW("element_yellow_square.png");
	
	private String URL;
	
	Colour(String URL) {
		this.URL = URL;
	}
	
	public String getURL() {
		return "data/" + URL;
	}
	
}
