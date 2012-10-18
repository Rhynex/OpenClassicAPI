package ch.spacebase.openclassic.api.util.map;

public class LongHash {
	
    public static long toLong(int first, int second) {
        return ((long) first << 32) + second - Integer.MIN_VALUE;
    }

    public static int getFirst(long l) {
        return (int) (l >> 32);
    }

    public static int getSecond(long l) {
        return (int) (l & 0xFFFFFFFF) + Integer.MIN_VALUE;
    }
    
}
