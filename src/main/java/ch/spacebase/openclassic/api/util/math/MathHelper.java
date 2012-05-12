package ch.spacebase.openclassic.api.util.math;

/**
 * A math utility class.
 */
public class MathHelper {

	public static final double DBL_EPSILON = Double.longBitsToDouble(0x3cb0000000000000L);

	public static final float FLT_EPSILON = Float.intBitsToFloat(0x34000000);

	public static final double PI = Math.PI;

	public static final double SQUARED_PI = PI * PI;

	public static final double HALF_PI = 0.5 * PI;

	public static final double QUATER_PI = 0.5 * HALF_PI;

	public static final double TWO_PI = 2.0 * PI;

	public static final double THREE_PI_HALVES = TWO_PI - HALF_PI;

	public static double lerp(double a, double b, double percent) {
		return (1 - percent) * a + percent * b;
	}

	public static float lerp(float a, float b, float percent) {
		return (1 - percent) * a + percent * b;
	}

	public static int lerp(int a, int b, double percent) {
		return (int) ((1 - percent) * a + percent * b);
	}

	public static double clamp(double value, double low, double high) {
		if (value < low) {
			return low;
		}
		if (value > high) {
			return high;
		}
		return value;
	}

	public static int clamp(int value, int low, int high) {
		if (value < low) {
			return low;
		}
		if (value > high) {
			return high;
		}
		return value;
	}

	public final static double cos(final double x) {
		return sin(x + (x > HALF_PI ? -THREE_PI_HALVES : HALF_PI));
	}

	public final static double sin(double x) {
		x = sin_a * x * Math.abs(x) + sin_b * x;
		return sin_p * (x * Math.abs(x) - x) + x;
	}

	public final static double tan(final double x) {
		return sin(x) / cos(x);
	}

	public final static double asin(final double x) {
		return x * (Math.abs(x) * (Math.abs(x) * asin_a + asin_b) + asin_c) + Math.signum(x) * (asin_d - Math.sqrt(1 - x * x));
	}

	public final static double acos(final double x) {
		return HALF_PI - asin(x);
	}

	public final static double atan(final double x) {
		return Math.abs(x) < 1 ? x / (1 + atan_a * x * x) : Math.signum(x) * HALF_PI - x / (x * x + atan_a);
	}

	public final static double inverseSqrt(double x) {
		final double xhalves = 0.5d * x;
		x = Double.longBitsToDouble(0x5FE6EB50C7B537AAl - (Double.doubleToRawLongBits(x) >> 1));
		return x * (1.5d - xhalves * x * x);
	}

	public final static double sqrt(final double x) {
		return x * inverseSqrt(x);
	}

	private static final double sin_a = -4 / SQUARED_PI;

	private static final double sin_b = 4 / PI;

	private static final double sin_p = 9d / 40;

	private final static double asin_a = -0.0481295276831013447d;

	private final static double asin_b = -0.343835993947915197d;

	private final static double asin_c = 0.962761848425913169d;

	private final static double asin_d = 1.00138940860107040d;

	private final static double atan_a = 0.280872d;

	public static int floor(double x) {
		int y = (int) x;
		if (x < y) {
			return y - 1;
		}
		return y;
	}

	public static int floor(float x) {
		int y = (int) x;
		if (x < y) {
			return y - 1;
		}
		return y;
	}

	public static int roundUpPow2(int x) {
		if (x <= 0) {
			return 1;
		} else if (x > 0x40000000) {
			throw new IllegalArgumentException("Rounding " + x + " to the next highest power of two would exceed the int range");
		} else {
			x--;
			x |= x >> 1;
			x |= x >> 2;
			x |= x >> 4;
			x |= x >> 8;
			x |= x >> 16;
			x++;
			return x;
		}
	}

	/**
	 * Casts the given object to an integer if applicable.
	 * @param Object to cast.
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
	 * @param Object to cast.
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
	 * @param Object to cast.
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
	 * @param Object to cast.
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
