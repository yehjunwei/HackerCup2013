package com.facebook.hackercup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.math.*;

public class CardGame {
	public static long strength = 0;
	//public static int handsToGo = 0;
	public static long m = 1000000007;
	
	public static void main(String args[]) {
		FileInputStream fstream;
		try {
			fstream = new FileInputStream("card_game.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			int numLines = Integer.valueOf(strLine);
			//System.out.println(numLines);
			for(int i = 0 ; i < numLines ; ++i) {
				strLine = br.readLine();
				String[] strs = strLine.split(" ");
				int n = Integer.valueOf(strs[0]);
				int k = Integer.valueOf(strs[1]);
				long[] array = new long [n];
				strLine = br.readLine();
				String[] tmp = strLine.split(" ");
				for(int j = 0 ; j < tmp.length ; ++j)
				   array[j] = Integer.valueOf(tmp[j]);
				Arrays.sort(array);
				
				strength = 0;
				for(int j=n-1 ; j>=0 ; j--) {
					strength += (array[j] * calCombinationNumbers(j, k-1));
					if (strength > m)
						strength %= m;
					if(j==k-1) 
						break;
				}
				System.out.println("Case #"+(i+1)+": "+strength);
			}
			//outbuf.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static long calCombinationNumbers(long n, long k) {
		long a = 1; 
	    for (int i=0; i<k; i++) {
	    	a = (a * (n-i) ) % m;
	    }
	    long b = 1;
	    for (int i=1; i<=k; i++) {
	    	b = (b * i) % m;
	    }
	    // calculate a/b mod m
	    BigInteger bigb, bigm, bModInverse;
	    bigb = new BigInteger(String.valueOf(b));
	    bigm = new BigInteger(String.valueOf(m));
	    bModInverse = bigb.modInverse(bigm);
	    return (a * bModInverse.longValue()) % m;
	}
}
