package ch.spacebase.openclassic.api.util.math;

/**
 * A math utility class.
 */
public class MathHelper {

	/**
	 * Casts the given object to an integer if applicable.
	 * @param o Object to cast.
	 * @return The resulting integer.
	 */
	public static Integer castInt(Object o) {
		if (o instanceof Number) {
			return ((Number) o).intValue();
		}

		return null;
	}

	/**
	 * Casts the given object to a double if applicable.
	 * @param o Object to cast.
	 * @return The resulting double.
	 */
	public static Double castDouble(Object o) {
		if (o instanceof Number) {
			return ((Number) o).doubleValue();
		}

		return null;
	}

	/**
	 * Casts the given object to a float if applicable.
	 * @param o Object to cast.
	 * @return The resulting float.
	 */
	public static Float castFloat(Object obj) {
		if (obj instanceof Number) {
			return ((Number) obj).floatValue();
		}

		return null;
	}

	/**
	 * Casts the given object to a boolean if applicable.
	 * @param o Object to cast.
	 * @return The resulting boolean.
	 */
	public static Boolean castBoolean(Object o) {
		if (o instanceof Boolean) {
			return (Boolean) o;
		} else if (o instanceof String) {
			try {
				return Boolean.parseBoolean((String) o);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}

		return null;
	}

}
