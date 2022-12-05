import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Main {

	static String test = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));

		
		
		int Value = 0;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			
			
			

			for (int i = 0; i < line.length(); i++)
			{
				System.out.println(String.valueOf(line.charAt(i)) + ":" + Integer.valueOf(line.charAt(i)));
			}
			
			
			
			
			
			/*
			/* part 1
			String Comp1 = line.substring(0, line.length()/2);
			String Comp2 = line.substring(line.length()/2);
			HashSet<String> FoundLetters = new HashSet<>();
			for (int i = 0; i < Comp1.length(); i++)
			{
				String temp = String.valueOf(Comp1.charAt(i));
				if (Comp2.contains(temp) && !FoundLetters.contains(temp))
				{
					FoundLetters.add(temp);
					if (temp.equals(temp.toLowerCase()))
					{
						//lower case
						Value += getValue(temp);
						System.out.println(Comp1.charAt(i)+":"+getValue(temp));
					}
					else
					{
						Value += getValue(temp);
						System.out.println(Comp1.charAt(i)+":"+getValue(temp));
					}
				}
			}
			
//part 2
			String line2 = scan.nextLine();
			String line3 = scan.nextLine();
			
			String Longest = "";
			
			String temp;
			if (line.length() > line2.length())
			{
				temp = line;
			}
			else
			{
				temp = line2;
			}
			if (line3.length() > temp.length())
			{
				Longest = line3;
			}
			else
			{
				Longest = temp;
			}
			
			
			
			
			for (int i = 0; i < Math.max(line.length(), Math.max(line2.length(), line3.length())); i++)
			{
				if (doesContain(line,line2,line3, String.valueOf(Longest.charAt(i))))
				{
					Value += getValue(String.valueOf(Longest.charAt(i)));
					break;
				}
			}
			
		*/	
		}
		//System.out.println("Value:"+Value);
		
	}
	
	static int getValue(String s)
	{
		for (int i = 0; i < test.length(); i++)
		{
			if (s.equals(String.valueOf(test.charAt(i))))
			{
				return i+1;
			}
		}
		return 0;
	}
	
	static boolean doesContain(String first, String second, String third, String Letter)
	{
		return first.contains(Letter) && second.contains(Letter) && third.contains(Letter);
	}

} 
