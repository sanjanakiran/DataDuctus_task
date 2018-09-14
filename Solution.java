/////////////////////////////////////////////////////////////////////
// Solution.java(Data Ductus Task)                                 //
// Language:    Java, Eclipse IDE                                  //
// Platform:    Dell Inspiron, Windows 10                          //
// Author:      Sanjana Kiran                                      //
/////////////////////////////////////////////////////////////////////

import java.lang.*;

public class Solution {
    public static void main(String[] args) {
    	// Sample Strings
        String ans = Solution.stringPrint("[1, 2, [A, B, C, [5^&, )()6, , 7], D, E] 3, 4]\n");
        String ans1 = Solution.stringPrint("[1, 2, [A, B, C, [5, 6]]\n");
        String ans2 = Solution.stringPrint("[1, 2, [A, B, C, [5, 6]]]\n");
        String ans3 = Solution.stringPrint(" ");
        System.out.println(ans);
    }
    
    public static String stringPrint(String s) {
        StringBuilder indent = new StringBuilder("");
        StringBuilder answer = new StringBuilder();
        String[] splits = s.split(", ");  //Individual elements are delimited with a comma followed by space
        
        for (int i = 0; i < splits.length; i++) {
            String split = splits[i]; 
            
            if (split.startsWith("[")) {
                indent.append(" ");
                
                if (split.length() < 2) {
                    answer = new StringBuilder("Invalid");
                    return answer.toString();
                }
                answer.append("\n");
                answer.append(indent.toString() + split.substring(1));
            } 
            else if (split.contains("]")) {
                String[] items = split.split("]");
                
                for (int j = 0; j < items.length; j++) {
                    answer.append("\n");
                    answer.append(indent.toString() + items[j].trim());
                    if (items.length == 1 || (items.length > 1 && j != items.length - 1)) {
                        indent.deleteCharAt(indent.length() - 1);
                    }
                }
            } 
            else {
                answer.append("\n");
                answer.append(indent.toString() + split);
            }
        }
        if (indent.length()>0){
            return "Invalid";
        }
        return answer.toString();
    }
}