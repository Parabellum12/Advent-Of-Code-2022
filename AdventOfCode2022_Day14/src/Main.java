import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	static HashSet<String> AllPoints = new HashSet<>();
	static int HighestDepth = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] Points = line.split(" -> ");
			for (int i = 0; i < Points.length; i++)
			{
				String point1 = Points[i];
				//AllPoints.add(point1);
				String point2 = "";
				if (i + 1 < Points.length)
				{
					point2 = Points[i+1];

					System.out.println(point1 + " -> " + point2);
					
					String[] pointData1 = point1.split(",");
					String[] pointData2 = point2.split(",");
					
					int[] pointData1Ints = new int[] {Integer.valueOf(pointData1[0]), Integer.valueOf(pointData1[1])};
					int[] pointData2Ints = new int[] {Integer.valueOf(pointData2[0]), Integer.valueOf(pointData2[1])};
					
					if (pointData1Ints[0] == pointData2Ints[0])
					{
						//vertical move
						int min = Math.min(pointData1Ints[1], pointData2Ints[1]);
						int max = Math.max(pointData1Ints[1], pointData2Ints[1]);
						for (int j = min; j <= max; j++)
						{
							String toput = pointData1[0] + "," + String.valueOf(j);
							if (HighestDepth < j)
							{
								HighestDepth = j;
							}
							AllPoints.add(toput);
						}
					}
					else
					{
						//horizontal move
						int min = Math.min(pointData1Ints[0], pointData2Ints[0]);
						int max = Math.max(pointData1Ints[0], pointData2Ints[0]);
						for (int j = min; j <= max; j++)
						{
							String toput = String.valueOf(j) + "," + pointData1[1];
							AllPoints.add(toput);
							if (HighestDepth < Integer.valueOf(pointData1[1]))
							{
								HighestDepth = Integer.valueOf(pointData1[1]);
							}
						}
					}
				}
				
			}
		}
		System.out.println("High:"+HighestDepth);
		for (String s : AllPoints)
		{
			System.out.println(s);
		}
		boolean active = true;
		int totalStable = 0;
		
		int floorPos = HighestDepth+2;
		
		//part2 floor
		for (int i = -2000; i < 2000; i++)
		{
			String toput = i + "," + floorPos;
			AllPoints.add(toput);
		}
		//part 2 floor end
		
		while (active)
		{
			String SandPos = "500,0";
			
			int currentX = 500;
			boolean stableFound = false;
			for (int i = 0; i <= HighestDepth + 3; i++)
			{
				String TestPos = currentX+","+(i+1);
				//System.out.println("TESTPOS:"+TestPos);
				if (AllPoints.contains(TestPos))
				{
					//Lower found
					String TestPos2 = (currentX-1)+","+(i+1);
					String TestPos3 = (currentX+1)+","+(i+1);
					if (!AllPoints.contains(TestPos2))
					{
						//move left
						currentX--;
						//i--;
					}
					else if (!AllPoints.contains(TestPos3))
					{
						//move right
						currentX++;
						//i--;
					}
					else
					{
						//stable
						//System.out.println("STABLE:"+TestPos);
						totalStable++;
						AllPoints.add(currentX+","+(i));
						stableFound = true;
						//part 2 condition
						if ((currentX+","+(i)).equals("500,0"))
						{
							stableFound = false;
						}
						//end part 2 condition
						break;
					}
				}
			}
			active = stableFound;
		}
		System.out.println("PART1:"+totalStable);
	}

}
