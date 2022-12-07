import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(new File("Input.txt"));
		Character[] buffer = new Character[14];
		int index = 0;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			for (int i = 0; i < line.length(); i++)
			{
				if (i < 14)
				{
					buffer[index] = line.charAt(i);
					index = (index+1)%14;
				}
				else
				{
					String test = "";
					for (Character c : buffer)
					{
						if (test.contains(String.valueOf(c)))
						{
							break;
						}
						else
						{
							test += c;
						}		
					}
					if (test.length() == 14)
					{
						System.out.println(i+":"+(i-14));
						break;
					}
					else
					{
						buffer[index] = line.charAt(i);
						index = (index+1)%14;
					}
				}
			}
		}
	}

}
