package com.capgemini.pascalrectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-01-23.
 * 0                     1
 * 1                   1   1
 * 2                 1   2   1
 * 3               1   3   3   1
 * 4             1   4   6   4   1
 * 5           1   5   10  10   5   1
 * 6         1   6   15  20  15   6   1
 * 7       1   7   21  35  35   21  7   1
 * 8     1   8   28  56  70  56   28  8   1
 * 9   1   9  36   84  126 126  84  36  9   1
 */
public class PascalRectangle {
	List<List<Long>> pasRec = new ArrayList<List<Long>>();
	
    public long pascal(int c, int r) throws BadNumberException { // zakladam, ze jest to liczba kolumn i rzedow liczby, jaka chce uzyskac
    	if(c < 1 || r < 1) {
    		throw new BadNumberException("dimensions must be greater than 0!");
    	}
    	
    	pasRec.add(new ArrayList<Long>());
    	for(int i = 0; i < c; i++) {
    		pasRec.get(0).add((long) 1);
    	}
    	for(int i = 1; i < r; i++) {
    		pasRec.add(new ArrayList<Long>());
    		for(int j = 0; j < c; j++) {
    			if(j == 0) {
    				Long n = pasRec.get(i-1).get(j) + pasRec.get(i-1).get(j+1);
    				pasRec.get(i).add(n);
    			} else if(j == c-1) {
    				Long n = pasRec.get(i-1).get(j) + pasRec.get(i-1).get(j-1);
    				pasRec.get(i).add(n);
    			} else {
    				Long n = pasRec.get(i-1).get(j-1) + pasRec.get(i-1).get(j) + pasRec.get(i-1).get(j+1);
    				pasRec.get(i).add(n);
    			}
    		}
    	}
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			System.out.print(pasRec.get(i).get(j));
    			System.out.print("\t");
    		}
    		System.out.println();
    	}
        return 0;
    }
    
    public static void main(String[] argv) {
    	PascalRectangle ps = new PascalRectangle();
    	try {
			ps.pascal(0,  0);
		} catch (BadNumberException e) {
			e.printStackTrace();
		}
    }
}
