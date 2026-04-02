// Author: Alexander Phipps
// Course: CS2
// Semester: Spring 2025

import java.util.*;

public class ParenthesesCombinations {

    public List<String> generateParentheses(int n) 
    {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentString, int numOpen, int numClose, int maxPairs) 
    {
        if (currentString.length() == maxPairs * 2) 
        {
            result.add(currentString.toString());
            return;
        }

        if (numOpen < maxPairs) 
        {
            currentString.append('(');
            backtrack(result, currentString, numOpen + 1, numClose, maxPairs);
            currentString.deleteCharAt(currentString.length() - 1);
        }
        
        if (numClose < numOpen) 
        {
            currentString.append(')');
            backtrack(result, currentString, numOpen, numClose + 1, maxPairs);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}
