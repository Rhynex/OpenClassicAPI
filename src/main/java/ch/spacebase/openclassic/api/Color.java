package ch.spacebase.openclassic.api;

public enum Color {

	COLOR_CHARACTER("&"),
	BLACK(COLOR_CHARACTER + "0"),
	DARK_BLUE(COLOR_CHARACTER + "1"),
	DARK_GREEN(COLOR_CHARACTER + "2"),
	CYAN(COLOR_CHARACTER + "3"),
	DARK_RED(COLOR_CHARACTER + "4"),
	PURPLE(COLOR_CHARACTER + "5"),
	GOLD(COLOR_CHARACTER + "6"),
	GRAY(COLOR_CHARACTER + "7"),
	DARK_GRAY(COLOR_CHARACTER + "8"),
	BLUE(COLOR_CHARACTER + "9"),
	GREEN(COLOR_CHARACTER + "a"),
	AQUA(COLOR_CHARACTER + "b"),
	RED(COLOR_CHARACTER + "c"),
	PINK(COLOR_CHARACTER + "d"),
	YELLOW(COLOR_CHARACTER + "e"),
	WHITE(COLOR_CHARACTER + "f");
	
	private String code;
	
	private Color(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getLetter() {
		return this.code.replace(COLOR_CHARACTER.getCode(), "");
	}
	
	public String toString() {
		return this.code;
	}
	
	public static String stripColor(String message) {
		StringBuilder builder = new StringBuilder();
		
		for(int index = 0; index < message.length(); index++) {
			char curr = message.charAt(index);
			
			if(curr == COLOR_CHARACTER.getCode().charAt(0)) {
				index++;
				continue;
			}
			
			builder.append(curr);
		}
		
		return builder.toString();
	}
	
}
