package com.facebook.hackercup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class FindTheMin {
	public static void main(String args[]) {
		FileInputStream fstream;
		try {
			// Create output file
			//FileWriter outstream = new FileWriter("output03.txt");
			//BufferedWriter outbuf = new BufferedWriter(outstream);
			
			fstream = new FileInputStream("find_the_min.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			int numLines = Integer.valueOf(strLine);
			int n, k, a, b, c, r;
			for(int i = 0 ; i < 5 ; ++i) {
				strLine = br.readLine();
				String[] nk = strLine.split(" ");
				n = Integer.valueOf(nk[0]);
				k = Integer.valueOf(nk[1]);
				strLine = br.readLine();
				String[] abcr = strLine.split(" ");
				a = Integer.valueOf(abcr[0]);
				b = Integer.valueOf(abcr[1]);
				c = Integer.valueOf(abcr[2]);
				r = Integer.valueOf(abcr[3]);
				System.out.println("array "+(i+1));
				int[] array = new int[n];
				int[] sorted_array = new int[k];
				array[0] = a;
				//System.out.print(array[0]+" ");
				for(int j = 1 ; j < k ; ++j) {
					array[j] = (b * array[j-1] + c) % r;
					//System.out.print(array[j]+" ");
				}
				sorted_array = Arrays.copyOf(array, k);
				Arrays.sort(sorted_array);
				System.out.println("original: ");
				for(int j = 0 ; j < k ; ++j) {
					System.out.print(array[j]+" ");
				}
				System.out.println("sorted: ");
				for(int j = 0 ; j < k ; ++j) {
					System.out.print(sorted_array[j]+" ");
				}
				System.out.println();
				array = null;
			}
			//System.out.println(numLines);
			//outbuf.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}			
	}
}

