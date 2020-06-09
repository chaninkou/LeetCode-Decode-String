package decode;

import java.util.Stack;

public class DecodeStringSolution {
	public String decodeString(String s){
		// Keeping track of the number of repeated count
		Stack<Integer> countStack = new Stack<>();
		// Keeping track of all the letters
		Stack<String> resultStack = new Stack<>();
		
		int index = 0;
		
		String result = "";
		
		// remember to update the index
		while(index < s.length()){
			// If current character is digit
			if(Character.isDigit(s.charAt(index))){
				int count = 0;
				// In case the repeat number is more than one digit ex: 30[a]
				while(Character.isDigit(s.charAt(index))){
					// Get the number from the character and multiply 10 every time
					count = 10 * count + (s.charAt(index) - '0');
					
					index += 1;
				}
				countStack.add(count);
			} else if (s.charAt(index) == '['){ // case 2 if its [
				resultStack.add(result);
				
				// reset result in case like 3[a2[c]]
				result = "";
				
				index += 1;
			} else if (s.charAt(index) == ']'){ // case 3 if its ]
				StringBuilder temp = new StringBuilder(resultStack.pop());
				
				int count = countStack.pop();
				
				for(int i = 0; i < count; i++){
					// repeat whatever letters in current result
					temp.append(result);
				}
				
				// Update the result by putting whatever string builder got for repeated letters
				result = temp.toString();
				
				index += 1;
				
			} else { // Else if current is letters
				result += s.charAt(index);
				index += 1;
			}
		}
		
		return result;
	}
	
	
	// Found a better way to do this
    public String decodeString2(String s) {
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
