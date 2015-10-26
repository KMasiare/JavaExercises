package com.capgemini.coins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. 
 * The adjacency of these coins is the number of adjacent pairs of coins with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by reversing exactly one coin 
 * (that is, one of the coins must be reversed). Consecutive elements of array A represent consecutive 
 * coins in the row. Array A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 
 * 1 represents a coin with tails facing up. For example, given array A consisting of six numbers, such that:
 * <p/>
 * A[0] = 1
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 0
 * A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two pairs of adjacent coins with the same side facing up, 
 * namely (0, 1) and (4, 5). After reversing the coin represented by A[2], the adjacency equals 4, 
 * as there are four pairs of adjacent coins with the same side facing up, namely: (0, 1), (1, 2), (2, 3) and (4, 5), 
 * and it is not possible to obtain a higher adjacency. The same adjacency can be obtained by reversing the coin represented by A[3].
 */
public class Coins {
	
    public int solution(List<Integer> coins) {
    	int marker = 0;
    	List<Integer> sums = new ArrayList<Integer>();
    	
    	for (marker = 0; marker < coins.size(); marker ++) {
    		reverseCoin(marker, coins);
    		
    		int counter = countPairs(coins);
    		
    		reverseCoin(marker, coins);
    		
    		marker ++;
    		sums.add(counter);
    	}
    	return Collections.max(sums);
    }
    
    private int countPairs(List<Integer> coins) {
		int counter = 0, coin;
		int i = 0;
		while (i < coins.size() - 1) {
			coin = coins.get(i);
			if (coin == coins.get(i+1))
				counter ++;
			i ++;
		}
		return counter;
    }
    
    List<Integer> reverseCoin(int position, List<Integer> coins) {
		if (coins.get(position) == 0)
			coins.set(position, 1);
		else 
			coins.set(position, 0);
		return coins;
    }
    
    public static void main(String[] argv) {
    	Coins coins = new Coins();
    	List<Integer> A = new ArrayList<Integer>();
    	A.add(1);
    	A.add(1);
    	A.add(1);
    	A.add(1);
    	A.add(0);
    	A.add(0);
    	
    	for (Integer coin : A) {
    		System.out.println(coin);
    	}
    	System.out.println("wynik:");
    	int x = coins.solution(A);
    	System.out.println(x);
    }
}
