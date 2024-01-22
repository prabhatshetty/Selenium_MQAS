package Programs;

import java.util.LinkedHashSet;

public class DuplicateWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="welcome to india india";
		//int count=0;
		String[]str=s.split(" ");
		
		LinkedHashSet<String> l1=new LinkedHashSet<String> ();
		{
			for(int i=0;i<str.length;i++) {
				
				l1.add(str[i]);
				
			}
		}
		
		for(String a:l1)
		{
			int count=0;
			for(int i=0;i<str.length;i++) 
			if(a.equals(str[i]))
			{
			count++;	
			}
			System.out.println(a+" "+count);
			}
		
		
		
		
		}
		
		
	}


