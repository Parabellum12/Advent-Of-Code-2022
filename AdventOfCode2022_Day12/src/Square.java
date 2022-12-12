
public class Square {
	public int Height = 0;
	Square[][] grid;
	public int Dist = Integer.MAX_VALUE;
	public int x;
	public int y;
	
	public Square(int h, Square[][] gridSet, int x, int y)
	{
		Height = h;
		grid = gridSet;
		this.x = x;
		this.y = y;
		//System.out.println(x + "," + y + " Height:" + h);
	}
	
	public void DoRepeating(int DistFrom)
	{
		if (DistFrom >= this.Dist)
		{
			return;
		}
		Dist = DistFrom;

		//System.out.println("DoRepeating:" + x + "," + y);
		if (x - 1 >= 0)
		{
			if (grid[y][x-1].Height <= Height+1)
			{
				grid[y][x-1].DoRepeating(Dist+1);
			}
			//left
		}
		if (x + 1 < grid[0].length)
		{
			if (grid[y][x+1].Height <= Height+1)
			{
				grid[y][x+1].DoRepeating(Dist+1);
			}
			//right
		}
		if (y -1 >= 0)
		{
			//up
			if (grid[y-1][x].Height <= Height+1)
			{
				grid[y-1][x].DoRepeating(Dist+1);
			}
		}
		if (y + 1 < grid.length)
		{
			//down
			if (grid[y+1][x].Height <= Height+1)
			{
				grid[y+1][x].DoRepeating(Dist+1);
			}
		}
	}
}
