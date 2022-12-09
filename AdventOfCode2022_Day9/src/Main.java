import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		int[] HeadPos = new int[2];
		int[] TailPos = new int[2];
		int totalSquaresVisited = 0;
		int totalNEWSquaresVisited = 0;
		HashSet<String> VisitedSquares = new HashSet<>();
		int[][] knots = new int[10][2];
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] tempArr = line.split(" ");
			String Dir = tempArr[0];
			int Dist = Integer.valueOf(tempArr[1]);
			
			for (int i = 0; i < Dist; i++)
			{
				//HEAD
				switch (Dir)
				{
				case "U":
					HeadPos[1]++;
					break;
				case "D":
					HeadPos[1]--;
					break;
				case "L":
					HeadPos[0]--;
					break;
				case "R":
					HeadPos[0]++;
					break;
				}
				knots[0] = HeadPos;
				//tail handling
				//0=head, 9=tail
				for (int j = 1; j < knots.length; j++)
				{
					if (DIST(knots[j-1], knots[j]))
					{
					boolean moved = false;
					if (knots[j-1][0] > knots[j][0])
					{
						knots[j][0]++;
						if (j == 9)
						{
							moved = true;
						}
					}
					else if (knots[j-1][0] < knots[j][0])
					{
						knots[j][0]--;
						if (j == 9)
						{
							moved = true;
						}
					}
					
					if (knots[j-1][1] > knots[j][1])
					{
						knots[j][1]++;
						if (j == 9)
						{
							moved = true;
						}
					}
					else if (knots[j-1][1] < knots[j][1])
					{
						knots[j][1]--;
						if (j == 9)
						{
							moved = true;
						}
					}
					
					
					
					
					if (moved)
					{
						totalSquaresVisited++;
						String temp = String.valueOf(knots[9][0])+ ":" + String.valueOf(knots[9][1]);
						if (!VisitedSquares.contains(temp))
						{
							VisitedSquares.add(temp);
							totalNEWSquaresVisited++;;
						}
					}
					}
				}
				
				
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(HeadPos));
		System.out.println(Arrays.toString(TailPos));
		System.out.println((totalSquaresVisited));
		System.out.println(Arrays.toString(VisitedSquares.toArray()));
		System.out.println((VisitedSquares.size())+1);
		System.out.println(totalNEWSquaresVisited);
	}
	
	public static boolean DIST(int[] HeadPos, int[] TailPos)
	{
		if (Math.abs(HeadPos[0] - TailPos[0]) > 1
				||Math.abs(TailPos[0] - TailPos[0]) > 1
				||Math.abs(HeadPos[1] - TailPos[1]) > 1
				||Math.abs(TailPos[1] - TailPos[1]) > 1)
		{
			return true;
		}
		return false;
	}
}
