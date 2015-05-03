package com.facebook.hackercup;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BeautifulStrings{
	
	public static void main(String args[]) {
		HashMap<Integer, Integer> value = new HashMap<Integer, Integer>();
		
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("beautiful_strings.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			int numLines = Integer.valueOf(strLine);
			for(int i = 0 ; i < numLines ; ++i) {
				value.clear();
				strLine = br.readLine();
				//System.out.println(strLine);
				int length = strLine.length();
				byte[] chars = strLine.getBytes();
				int index = 0;
				for(int j = 0 ; j < length ; ++j) {
					if(chars[j] >='a' && chars[j]<='z') {
						index = (chars[j] - 'a');
					} else if(chars[j] >='A' && chars[j]<='Z') {
						index = (chars[j] - 'A');
					} else {
						continue;
					}
					int put_value;
					if(value.get(index) == null) {
						put_value = 1;
					} else {
						put_value = value.get(index) + 1;
					}
					value.put(index, put_value);
				}
				
				// sort this map by value
				List<Map.Entry<Integer, Integer>> list_Data = new ArrayList<Map.Entry<Integer, Integer>>(value.entrySet());
				Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>(){
		            public int compare(Map.Entry<Integer, Integer> entry1,
		                               Map.Entry<Integer, Integer> entry2){
		                return (entry2.getValue() - entry1.getValue());
		            }
		        });
				
				// calculate the beauty value
				int beauty = 26;
				int sum = 0;
		        for (Map.Entry<Integer, Integer> entry:list_Data) {
		        	sum += (entry.getValue() * beauty);
		        	beauty -= 1;
		        }
				System.out.println("Case #"+(i+1)+": "+sum);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
