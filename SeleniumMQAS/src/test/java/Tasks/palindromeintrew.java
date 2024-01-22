package Tasks;

public class palindromeintrew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			String name="palendrome";
			String rev="";
			for(int i=name.length()-1;i<=0;i--)
			{
			rev=rev+name.charAt(i);
			}
			if(rev.equals(name))
			{
			System.out.println("Its an palendrome");
			}else
			System.out.println("Its not palendrome");
			}
		
		
		
	}

}
