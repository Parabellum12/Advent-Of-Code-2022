import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		ArrayList<String> gridStrings = new ArrayList<>();
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			gridStrings.add(line);
		}
		
		Square[][] grid = new Square[gridStrings.size()][gridStrings.get(0).length()];
		//letter - 96

		int[] Start = new int[2];
		int[] End = new int[2];
		
		ArrayList<int[]> STARTS = new ArrayList<>();
		
		for (int y = 0; y < gridStrings.size(); y++)
		{
			for (int x = 0; x < gridStrings.get(y).length(); x++)
			{
				if (gridStrings.get(y).charAt(x) == 'S')
				{
					//start
					Start = new int[]{x,y};
					//System.out.println("Start:" + Arrays.toString(Start));
					STARTS.add(Start);
					grid[y][x] = new Square(Integer.valueOf('a')-96, grid, x, y);
				}
				else if (gridStrings.get(y).charAt(x) == 'E')
				{
					//end
					End = new int[]{x,y};
					//System.out.println("End:" + Arrays.toString(End));
					grid[y][x] = new Square(Integer.valueOf('z')-96, grid, x, y);
				}
				else
				{
					grid[y][x] = new Square(Integer.valueOf(gridStrings.get(y).charAt(x))-96, grid, x, y);
					if (gridStrings.get(y).charAt(x) == 'a')
					{
						STARTS.add(new int[] {x,y});
					}
				}
			}
		}
		
		//A*
		grid[Start[1]][Start[0]].DoRepeating(0);
		//System.out.println("Start:" + Arrays.toString(Start));
		//System.out.println("End:" + Arrays.toString(End));
		System.out.println("PART 1:"+grid[End[1]][End[0]].Dist);
		
		for (int[] pos : STARTS)
		{
			grid[pos[1]][pos[0]].DoRepeating(0);
		}
		System.out.println("PART 2:"+grid[End[1]][End[0]].Dist);
	}

}
