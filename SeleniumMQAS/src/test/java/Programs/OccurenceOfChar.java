package Programs;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class OccurenceOfChar {

	@Test(invocationCount = 0)
	public void charLength(){
		String s1="indiansindianwqrt";
		LinkedHashSet<Character> l1=new  LinkedHashSet<Character>();
	
			for(int i=0;i<s1.length()-1;i++)
			{
			l1.add(s1.charAt(i));
			}
			//System.out.println(l1);
		
		for(char s:l1)
		{
		int count=0;
		for(int j=0;j<s1.length()-1;j++) {
			
			if(s==s1.charAt(j))
				
			{
				count++;
				//System.out.println(s);
			}
			
		}
		if(count>1)
		System.out.println(s+" = "+count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(s);
	
		
		}
		
		
	}

	
	@Test(invocationCount = 0)
	public void duplicatenumbers(){
		// TODO Auto-generated method stub
		int []arr= {9,7,9,8,8,7,1,4};
		LinkedHashSet<Integer> l1=new  LinkedHashSet<Integer>();
		{
			for(int i=0;i<arr.length;i++)
			{
			l1.add(arr[i]);
			}
		}
	
	for(int a:l1)
	{
	int count=0;	
	for (int j=0;j<arr.length;j++)
	{
	if (a==arr[j])	
	{
		count++;
		
	}
	}
	System.out.println(a+" = "+count);
	}
	
	}
	
	@Test(invocationCount = 0)
	public void duplicatewordcount(){
		
	String s1="Hi hello How are You Hi Hello Hi HI Hello";
			s1=s1.toLowerCase();
			String []arr=s1.split(" ");
			LinkedHashSet<String> l1=new LinkedHashSet<String>();
					
				for(int i=0;i<arr.length;i++)
				{
					l1.add(arr[i]);
				}
			
				//System.out.println(l1);
			
				for(String a:l1)
				{
					int count =0;
					for(int j=0;j<arr.length;j++) {
						
					if(a.equals(arr[j])) {
						count++;
						
					}
					
					}
					System.out.println(a+" = "+count);
					
				}
			
	
		
	}
	
	@Test(invocationCount =0 )
	public void occuranceofchar1(){
		
		
		String s="India is india";
		s=s.toLowerCase();
		s=s.replaceAll(" ", "");
		char[]s1=s.toCharArray();
		LinkedHashSet<Character> l1=new LinkedHashSet();
		
		for(int i=0;i<s1.length;i++)
		{
			l1.add(s1[i]);
			}
		
		for (char c:l1)
		{
			int count=0;
			for(int j=0;j<s1.length;j++) {
			if(c==(s1[j])) {
				count++;
				
			}
				
		}
			System.out.println(c+" "+count);
		}
		
		
		
	
	}
	
	
	@Test(invocationCount =1 )
	public void comma(){
	
		for(int i=0;i<9;i++)
		{
			System.out.print(i);
			System.out.print(",");
		}
	
	
	}
}
