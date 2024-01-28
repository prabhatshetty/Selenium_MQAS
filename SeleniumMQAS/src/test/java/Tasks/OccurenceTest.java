package Tasks;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class OccurenceTest {
	@Test(invocationCount=1)
	public void occuraanceifchar() {
		
		String s="aaaaaAppleTreezzbbcc";
		s=s.toLowerCase();
		LinkedHashSet<Character> set= new LinkedHashSet <Character>();
		for(int i=0;i<s.length()-1;i++)
		{
			set.add(s.charAt(i));
		}
		
		for(char ch:set)
		{
			int count=0;
			for(int j=0;j<s.length();j++)
			{
			if(ch==s.charAt(j)) {
				count++;
			}
			
		}
			System.out.println(ch+"=="+count)	;
		
	}

	}
}
