import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		
		int totalOverlappingPairs = 0;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] parts = line.split(",");
			String[] part1Bits = parts[0].split("-");
			String[] part2Bits = parts[1].split("-");
			
			int part1Lower = Integer.valueOf(part1Bits[0]);
			int part1Upper = Integer.valueOf(part1Bits[1]);
			int part2Lower = Integer.valueOf(part2Bits[0]);
			int part2Upper = Integer.valueOf(part2Bits[1]);
			
			/*part 1
			if (part1Lower <= part2Lower && part1Upper >= part2Upper)
			{
				totalOverlappingPairs++;
			}
			else if (part2Lower <= part1Lower && part2Upper >= part1Upper)
			{
				totalOverlappingPairs++;
			}
			*/
			
			if (part1Lower >= part2Lower && part1Lower <= part2Upper
					|| part1Upper >= part2Lower && part1Upper <= part2Upper)
			{
				totalOverlappingPairs++;
			}
			else if (part2Lower >= part1Lower && part2Lower <= part1Upper
					|| part2Upper >= part1Lower && part2Upper <= part1Upper)
			{
				totalOverlappingPairs++;
			}
			
		}
		System.out.println(totalOverlappingPairs);
	}

}
