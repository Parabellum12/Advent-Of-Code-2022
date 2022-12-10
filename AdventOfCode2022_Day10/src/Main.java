import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static long X = 1;
	static long Cycle = 0;
	static ArrayList<Long> CycleTests = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		ArrayList<String> commands = new ArrayList<>();
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			commands.add(line);
		}
		for (int i = 0; i < commands.size(); i++)
		{
			String command = commands.get(i);
			String[] data = command.split(" ");
			if (data[0].equals("noop"))
			{
				CycleTick();
			}
			else
			{
				CycleTick();
				CycleTick();
				X += Integer.valueOf(data[1]);
			}
		}
		
		long returner = 0;
		for (long x : CycleTests)
		{
			returner+=x;
		}
		System.out.println(returner);
	}
	
	static int horPos = 0;
	public static void CycleTick()
	{
		if (horPos >= 40)
		{
			horPos = 0;
			System.out.println();
		}
		
		if (Math.abs(horPos - X) <= 1)
		{
			System.out.print("#");
		}
		else
		{
			System.out.print(".");
		}
		horPos++;
		
		Cycle++;
		if (Cycle == 20 || (Cycle-20) % 40 == 0)
		{
			CycleTests.add(X*Cycle);
		}
	}

}
