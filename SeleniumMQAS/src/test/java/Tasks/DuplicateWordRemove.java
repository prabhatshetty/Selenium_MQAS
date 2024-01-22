package Tasks;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class DuplicateWordRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="welcome to india india";
		String[] str=s.split(" ");
		System.out.println(str.length);
		TreeSet l1=new TreeSet();
		for(int i=0;i<=str.length-1;i++)
		{
		l1.add(str[i]);
		
		}
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0; i<str.length; i++)
		{
			set.add(str[i]);
		}
		
System.out.println(l1);

String s1="welcome to india india karnataka banglore";
String s2 = s1.replace(" ", "");

System.out.println(s2);


String s5="sonalisubhechhathakurssasssssssss";
LinkedHashSet<Character> set1=new LinkedHashSet<Character>();
for(int i=0; i<s5.length(); i++) {
	set1.add(s5.charAt(i));
}
for(char ch:set1) {
	System.out.println(ch+" ");
}
}
	}

