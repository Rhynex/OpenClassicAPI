package ch.spacebase.openclassic.api;

/**
 * Represents a chat color.
 */
public enum Color {

	/** Represents the color code prefix. */
	COLOR_CHARACTER("&"),
	/** Represents the color black. */
	BLACK(COLOR_CHARACTER + "0"),
	/** Represents the color dark blue. */
	DARK_BLUE(COLOR_CHARACTER + "1"),
	/** Represents the color dark green. */
	DARK_GREEN(COLOR_CHARACTER + "2"),
	/** Represents the color cyan. */
	CYAN(COLOR_CHARACTER + "3"),
	/** Represents the color dark red. */
	DARK_RED(COLOR_CHARACTER + "4"),
	/** Represents the color purple. */
	PURPLE(COLOR_CHARACTER + "5"),
	/** Represents the color gold. */
	GOLD(COLOR_CHARACTER + "6"),
	/** Represents the color gray. */
	GRAY(COLOR_CHARACTER + "7"),
	/** Represents the color dark gray. */
	DARK_GRAY(COLOR_CHARACTER + "8"),
	/** Represents the color blue. */
	BLUE(COLOR_CHARACTER + "9"),
	/** Represents the color green. */
	GREEN(COLOR_CHARACTER + "a"),
	/** Represents the color aqua. */
	AQUA(COLOR_CHARACTER + "b"),
	/** Represents the color red. */
	RED(COLOR_CHARACTER + "c"),
	/** Represents the color pink. */
	PINK(COLOR_CHARACTER + "d"),
	/** Represents the color yellow. */
	YELLOW(COLOR_CHARACTER + "e"),
	/** Represents the color white. */
	WHITE(COLOR_CHARACTER + "f");
	
	private String code;
	
	private Color(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the color code string.
	 * @return The color code.
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Gets the symbol following the color code prefix.
	 * @return The color code's symbol.
	 */
	public String getSymbol() {
		return this.code.replace(COLOR_CHARACTER.getCode(), "");
	}
	
	@Override
	public String toString() {
		return this.code;
	}
	
	/**
	 * Strips a message of all color codes.
	 * @param Message to strip from.
	 * @return Message without color codes.
	 */
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
