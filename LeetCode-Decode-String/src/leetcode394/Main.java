package leetcode394;

public class Main {
	public static void main(String[] args){
		String s = "3[a]2[bc]";
		
		System.out.println("Input: " + s);
		
		DecodeStringSolution solution = new DecodeStringSolution();
		
		System.out.println("Solution: " + solution.decodeString(s));
	}
}
