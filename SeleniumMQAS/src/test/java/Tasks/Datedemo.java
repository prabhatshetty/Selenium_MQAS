package Tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date currentDate = new Date();

		// Create a SimpleDateFormat object with the desired date pattern
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		// Format the date as a string
		String formattedDate = sdf.format(currentDate);

		int date = (Integer.parseInt(formattedDate)+1);

		System.out.println("Formatted Date: " + formattedDate);

		String n = "39";
		int nn = Integer.parseInt(n);
		
		int no=39;
		
		int sum	=0;
		while(no!=0)
		{
		int a=no%10;
		System.out.println(a);
		sum=sum+a;
		System.out.println(sum);
		no=no/10;
		System.out.println(no);	
		}
		
		System.out.println(sum);
		
		
	}




}
