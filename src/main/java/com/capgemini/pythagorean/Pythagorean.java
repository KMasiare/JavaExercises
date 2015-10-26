package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Pythagorean { // od tego zadania mozg mi skrzypi
	private static final int sum = 1000;
	
	public static long findABC() {
		for(int a = 1; a < sum / 3; a++) {
			int b;
			for(b = a + 1; b <= sum / 2; b++) {
				int c = sum - (a + b);
				if (a*a + b*b == c*c) {
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					return a*b*c;
				}
			}
		}
			
		return 0;
	}
	
    public static void main(String[] argv) {
    	findABC();
    }

	
}
