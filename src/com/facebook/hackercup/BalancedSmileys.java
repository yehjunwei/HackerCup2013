package com.facebook.hackercup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

// Save as BalancedSmileys.java 
public class BalancedSmileys {
	public static void main(String args[]) {
		// A message has balanced parentheses if it consists of one of the
		// following:
		//
		// - An empty string ""
		// - One or more of the following characters: 'a' to 'z', ' ' (a space)
		// or ':' (a colon)
		// - An open parenthesis '(', followed by a message with balanced
		// parentheses, followed by a close parenthesis ')'.
		// - A message with balanced parentheses followed by another message
		// with balanced parentheses.
		// - A smiley face ":)" or a frowny face ":("
		
		FileInputStream fstream;
		try {
			// Create output file
			FileWriter outstream = new FileWriter("balanced_smileys_output.txt");
			BufferedWriter outbuf = new BufferedWriter(outstream);
			
			fstream = new FileInputStream("balanced_smileys.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			int numLines = Integer.valueOf(strLine);
			for(int i = 0 ; i < numLines ; ++i) {
				strLine = br.readLine();
				boolean result = isBalanced(strLine);
				if(result) {
					outbuf.write("Case #"+(i+1)+": YES");
					outbuf.newLine();
				} else {
					outbuf.write("Case #"+(i+1)+": NO");
					outbuf.newLine();
				}
			}
			outbuf.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
    public static boolean isBalanced(String input) {
        int i = -1;
         
        //First check if there non-allowed characters, not using length knowingly
        try {
            while (true) {
                i++;
                Character c = input.charAt(i);
                if (c < 'a' || c > 'z') {
                    if (c != ':' && c != ' ' && c != '(' && c != ')')
                        return false;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Reached @ the end of the string");
        }
        // S for Sad emoticon H for happy emoticon */
        input = input.replace(":(", "S");// Sad
        input = input.replace(":)", "H");// Happy
 
        // Keep only (, ), S and H, replace everything else by empty string */
        input = input.replaceAll("[a-z :]", "");
        System.out.println("Converted Input Str =" + input);
 
        return isBalancesPerenthesis(input);
    }
 
    private static boolean isBalancesPerenthesis(String input) {
        boolean isBalancedFromLeft = isBalancesPerenthesisFromLeft(input);
        boolean isBalancedFromRight = isBalancesPerenthesisFromRight(input);
        return isBalancedFromLeft && isBalancedFromRight;
    }
 
    // It only considers sad count, openCount and closedCount */
    private static boolean isBalancesPerenthesisFromLeft(String input) {
        int openCount = 0;
        int closedCount = 0;
        int sadCount = 0;
        int happyCount = 0;
 
        for (Character c : input.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                closedCount++;
                if (openCount + sadCount - closedCount < 0) {
                    return false;
                }
            } else if (c == 'S') {
                sadCount++;
            } else if (c == 'H') {
                happyCount++;
            }
        }
        return true;
    }
 
    // It only considers happy count, openCount and closedCount */
    private static boolean isBalancesPerenthesisFromRight(String input) {
        int openCount = 0;
        int closedCount = 0;
        int sadCount = 0;
        int happyCount = 0;
 
        for (int i = input.length() - 1; i >= 0; i--) {
            Character c = input.charAt(i);
            if (c == '(') {
                openCount++;
                if (closedCount + happyCount - openCount < 0) {
                    return false;
                }
            } else if (c == ')') {
                closedCount++;
            } else if (c == 'S') {
                sadCount++;
            } else if (c == 'H') {
                happyCount++;
            }
        }
        return true;
    }
}
