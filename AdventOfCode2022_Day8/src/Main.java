import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	static int[][] grid = new int[500][200];
	static int length = 0;
	static int height = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		int ypos = 0;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			height++;
			length = line.length();
			for (int i = 0; i < line.length(); i++)
			{
				grid[ypos][i] = Integer.valueOf(String.valueOf(line.charAt(i)));
			}
			ypos++;
		}

		boolean[][] grid2 = new boolean[height][length];
		int numVisible = 0;
		//part 1
		for (int i = 0; i < height; i++)
		{
			//horizontal pass
			for (int k = 0; k < length; k++)
			{
				if (IsVisible1(i,k))
				{
					numVisible++;
					grid2[i][k] = true;
				}
				else
				{

					grid2[i][k] = false;
				}
			}
		}
for (int i = 0; i < grid2.length; i++)
{
	String out = "";
	for (int k = 0; k < grid2[i].length; k++)
	{
		if (grid2[i][k])
		{
			out += "1,";
		}
		else
		{
			out += "0,";
		}
	}
	System.out.println(out);
}
		
		
		
		
		System.out.println("Test:"+numVisible);
		System.out.println("TestH:"+height);
		System.out.println("TestL:"+length);
		
		TreeSet<Integer> scenicScores = new TreeSet<>();
		for (int i = 0; i < length; i++)
		{
			for (int k = 0; k < height; k++)
			{
				scenicScores.add(IsVisible2(i,k));
			}
		}
		System.out.println(scenicScores.toArray()[0] + ":" + scenicScores.toArray()[scenicScores.size()-1]);
	}
	
	public static boolean IsVisible1(int i, int k)
	{
		if (i == 0 || k == 0 || i == height-1 || k == length-1)
		{
			System.out.println("Testing " + i + "," + k + ":TRUE");
			return true;
		}
		
		
		
		//up
		boolean isVisibleLeft = true;
		for (int k2 = k; k2 >= 0; k2-- )
		{
			if (grid[i][k2] >= grid[i][k] && k2 != k)
			{
				isVisibleLeft = false;
				break;
			}
		}
		//down
		boolean isVisibleRight = true;
		for (int k2 = k; k2 < height; k2++)
		{
			if (grid[i][k2] >= grid[i][k] && k2 != k)
			{
				isVisibleRight = false;
				break;
			}
		}
		
		//right
		boolean isVisibleDown = true;
		for (int i2 = i; i2 < length; i2++)
		{
			if (grid[i2][k] >= grid[i][k] && i2 != i)
			{
				isVisibleDown = false;
				break;
			}
		}
		
		//right
		boolean isVisibleUP = true;
		for (int i2 = i; i2 >= 0; i2--)
		{
			if (grid[i2][k] >= grid[i][k] && i2 != i)
			{
				isVisibleUP = false;
				break;
			}
		}
		System.out.println("Testing " + i + "," + k + ": UP:" + isVisibleUP + " DOWN:" + isVisibleDown + " LEFT:" + isVisibleLeft + " RIGHT:" + isVisibleRight);
		return isVisibleUP || isVisibleDown || isVisibleRight || isVisibleLeft;
	}
	
	public static int IsVisible2(int i, int k)
	{
		if (i == 0 || k == 0 || i == height-1 || k == length-1)
		{
			System.out.println("Testing " + i + "," + k + ":0");
			return 0;
		}
		
		
		
		//up
		int isVisibleLeft = 0;
		for (int k2 = k; k2 >= 0; k2-- )
		{
			if (k2 != k)
			{
			isVisibleLeft++;
			}
			if (grid[i][k2] >= grid[i][k] && k2 != k)
			{
				break;
			}
		}
		//down
		int isVisibleRight = 0;
		for (int k2 = k; k2 < height; k2++)
		{
			if (k2 != k)
			{
			isVisibleRight++;
			}
			if (grid[i][k2] >= grid[i][k] && k2 != k)
			{
				break;
			}
		}
		
		//right
		int isVisibleDown = 0;
		for (int i2 = i; i2 < length; i2++)
		{
			if (i2 != i)
			{

				isVisibleDown++;
			}
			if (grid[i2][k] >= grid[i][k] && i2 != i)
			{
				break;
			}
		}
		
		//right
		int isVisibleUP = 0;
		for (int i2 = i; i2 >= 0; i2--)
		{
			if (i2 != i)
			{
				isVisibleUP++;
			}
			if (grid[i2][k] >= grid[i][k] && i2 != i)
			{
				break;
			}
		}
		System.out.println("Testing " + i + "," + k + ": UP:" + isVisibleUP + " DOWN:" + isVisibleDown + " LEFT:" + isVisibleLeft + " RIGHT:" + isVisibleRight);
		return isVisibleUP * isVisibleDown * isVisibleRight * isVisibleLeft;
	}

}
