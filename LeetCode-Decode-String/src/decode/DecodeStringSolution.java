package decode;

import java.util.Stack;

public class DecodeStringSolution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        
        Stack<StringBuilder> stringStack = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        
        int k = 0;
        
        for(char w : s.toCharArray()){
            // If the character is a number
            if(Character.isDigit(w)){
                k = k * 10 + w - '0';
            } else if (w == '['){
                // Pushing k to the stack
                intStack.push(k);
                
                // Pushing current to the stack
                stringStack.push(current);
                
                // Create a new stringBuilder
                current = new StringBuilder();
                
                // Set k back to 0
                k = 0;
            } else if (w == ']'){
                // Using a temp variable
                StringBuilder temp = current;
                
                // Since ] is found, current equal to pop
                current = stringStack.pop();
                
                for(k = intStack.pop(); k > 0; k--){
                    current.append(temp);
                }
            } else{
                current.append(w);
            }
        }
        return current.toString();
    }
}
