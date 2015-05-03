# HackerCup2013

<H2>Beautiful Strings

When John was a little kid he didn't have much to do. There was no internet, no Facebook, and no programs to hack on. So he did the only thing he could... he evaluated the beauty of strings in a quest to discover the most beautiful string in the world.  

Given a string s, little Johnny defined the beauty of the string as the sum of the beauty of the letters in it.  

The beauty of each letter is an integer between 1 and 26, inclusive, and no two letters have the same beauty. Johnny doesn't care about whether letters are uppercase or lowercase, so that doesn't affect the beauty of a letter. (Uppercase 'F' is exactly as beautiful as lowercase 'f', for example.)  

You're a student writing a report on the youth of this famous hacker. You found the string that Johnny considered most beautiful. What is the maximum possible beauty of this string?  

**Input**  
 
The input file consists of a single integer m followed by m lines.
 
**Output**  
 
Your output should consist of, for each test case, a line containing the string "Case #x: y" where x is the case number (with 1 being the first case in the input file, 2 being the second, etc.) and y is the maximum beauty for that test case.
 
**Constraints**  
5 ≦ m ≦ 50  
2 ≦ length of s ≦ 500  

**Sample Input**  
5  
ABbCcc  
Good luck in the Facebook Hacker Cup this year!  
Ignore punctuation, please :)  
Sometimes test cases are hard to make up.  
So I just go consult Professor Dalves  

**Sample Output**  
Case #1: 152  
Case #2: 754  
Case #3: 491  
Case #4: 729  
Case #5: 646  

<H2>Balanced Smileys

Your friend John uses a lot of emoticons when you talk to him on Messenger. In addition to being a person who likes to express himself through emoticons, he hates unbalanced parenthesis so much that it makes him go :(  

Sometimes he puts emoticons within parentheses, and you find it hard to tell if a parenthesis really is a parenthesis or part of an emoticon.  

A message has balanced parentheses if it consists of one of the following:  

– An empty string ""  
– One or more of the following characters: "a" to "z", " " (a space) or ":" (a colon)  
– An open parenthesis "(", followed by a message with balanced parentheses, followed by a close parenthesis ")".  
– A message with balanced parentheses followed by another message with balanced parentheses.  
– A smiley face ":)" or a frowny face ":("  
Write a program that determines if there is a way to interpret his message while leaving the parentheses balanced.  

**Input**  
 
The first line of the input contains a number T (1 ≦ T ≦ 50), the number of test cases.
The following T lines each contain a message of length s that you got from John.
 
**Output**  
 
For each of the test cases numbered in order from 1 to T, output 「Case #i: 」 followed by a string stating whether or not it is possible that the message had balanced parentheses. If it is, the string should be 「YES」, else it should be 「NO」 (all quotes for clarity only)
 
**Constraints**  
1 ≦ length of s ≦ 100 

**Sample Input**  
5  
:((  
i am sick today (:()  
(:)  
hacker cup: started :):)  
)(  

**Sample Output**  
Case #1: NO  
Case #2: YES  
Case #3: YES  
Case #4: YES  
Case #5: NO  

<H2>Find The Min

After sending smileys, John decided to play with arrays. Did you know that hackers enjoy playing with arrays? John has a zero-based index array, m, which contains n non-negative integers. However, only the first k values of the array are known to him, and he wants to figure out the rest.  

John knows the following: for each index i, where k <= i < n, m[i] is the minimum non-negative integer which is *not* contained in the previous *k* values of m.  

For example, if k = 3, n = 4 and the known values of m are [2, 3, 0], he can figure out that m[3] = 1.  
John is very busy making the world more open and connected, as such, he doesn't have time to figure out the rest of the array. It is your task to help him.  

Given the first k values of m, calculate the nth value of this array. (i.e. m[n – 1]).  

Because the values of n and k can be very large, we use a pseudo-random number generator to calculate the first k values of m. Given non-negative integers a, b, c and positive integer r, the known values of m can be calculated as follows:  

* m[0] = a  
* m[i] = (b * m[i – 1] + c) % r, 0 < i < k  

**Input**  
 
The first line contains an integer T (T <= 20), the number of test cases.  
This is followed by T test cases, consisting of 2 lines each.  
The first line of each test case contains 2 space separated integers, n, k (1 <= k <= 105, k < n <= 109).  
The second line of each test case contains 4 space separated integers a, b, c, r (0 <= a, b, c <= 109, 1 <= r <= 109).  
 
**Output**  
 
For each test case, output a single line containing the case number and the nth element of m.  

**Sample Input**  
5  
97 39  
34 37 656 97  
186 75  
68 16 539 186  
137 49  
48 17 461 137  
98 59  
6 30 524 98  
46 18  
7 11 9 46  

**Sample Output**  
Case #1: 8  
Case #2: 38  
Case #3: 41  
Case #4: 40  
Case #5: 12  

<H2>Card Game

John is playing a game with his friends. The game's rules are as follows: There is deck of N cards from which each person is dealt a hand of K cards. Each card has an integer value representing its strength. A hand's strength is determined by the value of the highest card in the hand. The person with the strongest hand wins the round. Bets are placed before each player reveals the strength of their hand.  

John needs your help to decide when to bet. He decides he wants to bet when the strength of his hand is higher than the average hand strength. Hence John wants to calculate the average strength of ALL possible sets of hands. John is very good at division, but he needs your help in calculating the sum of the strengths of all possible hands.  

**Problem**  

You are given an array a with N ≦ 10 000 different integer numbers and a number, K, where 1 ≦ K ≦ N. For all possible subsets of a of size K find the sum of their maximal elements modulo 1 000 000 007.  

**Input**  
 
The first line contains the number of test cases T, where 1 ≦ T ≦ 25  
Each case begins with a line containing integers N and K. The next line contains N space-separated numbers 0 ≦ a [i] ≦ 2 000 000 000, which describe the array a.    
 
**Output**  
 
For test case i, numbered from 1 to T, output 「Case #i: 「, followed by a single integer, the sum of maximal elements for all subsets of size K modulo 1 000 000 007.  

**Example**
For a = [3, 6, 2, 8] and N = 4 and K = 3, the maximal numbers among all triples are 6, 8, 8, 8 and the sum is 30.  

**Sample Input**  
5  
4 3  
3 6 2 8   
5 2  
10 20 30 40 50  
6 4  
0 1 2 3 5 8  
2 2  
1069 1122  
10 5  
10386 10257 10432 10087 10381 10035 10167 10206 10347 10088  

**Sample Output**  
Case #1: 30  
Case #2: 400  
Case #3: 103  
Case #4: 1122  
Case #5: 2621483  
