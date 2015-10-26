package com.capgemini.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-01-23.
 * F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	  F18	F19
 1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597  2584	4181
 */
public class Fibonacci {
	
    public static long fib(int n) throws TooLargeNumberException {
    	List<Long> fib = new ArrayList<Long>();
    	
    	if (n == 1 || n == 2) {
    		return 1;
    	} else if(n > 91) {
    		throw new TooLargeNumberException("Too large number - answer too large for long type");
    	} else if(n < 1) {
    		throw new TooLargeNumberException("Argument cannot be smaller than 1");
    	} else {
        	fib.add(new Long(1));
        	fib.add(new Long(1));
        	
        	for (int i = 2; i <= n; i++) {
        		Long next = fib.get(i-1) + fib.get(i-2);
        		fib.add(next);
        	}
        	return fib.get(n);
    	}
    }
    
    public static void main(String[] argv) {
    	try {
			System.out.println(fib(-1));
		} catch (TooLargeNumberException e) {
			e.printStackTrace();
		}
    }
}
