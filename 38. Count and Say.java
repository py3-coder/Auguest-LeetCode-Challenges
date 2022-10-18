/*
38. Count and Say
Medium

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

For example, the saying and conversion for digit string "3322251":

Given a positive integer n, return the nth term of the count-and-say sequence.

Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 
Constraints:
1 <= n <= 30

*/
// Runtime :4ms
// TC : O(n^2) ~ Actually loop inside the function- countsay runs  with varibale length we here suppossed max size to be n.

class Solution {
    public String countAndSay(int n) {
	    String res ="1";
	    if(n==1){
	        return res;
	    }else{
	        for(int i=2;i<=n;i++){
	            String str =countsay(res);
	            res = str;
	        }
            return res;
	    }
    }
    public String countsay(String code){
        StringBuilder sb =new StringBuilder();
        int count=1;
        for(int i=1;i<code.length();i++){
            if(code.charAt(i)==code.charAt(i-1)){
                count++;
            }else{
                sb.append(count);
                sb.append(code.charAt(i-1));
                count=1;
            }
        }
        sb.append(count);
        sb.append(code.charAt(code.length()-1));
        return sb.toString();
    }
}
