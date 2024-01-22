package Programs;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="Brag";  
		String str2="Grab";
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		char[]string1=str1.toCharArray();
		char[]string2=str2.toCharArray();
		
		Arrays.sort(string1);
		Arrays.sort(string2);
if(Arrays.equals(string1,string2)==true) {
	System.out.println("its anagram");
	
}
		
		
		
		
	}

}
