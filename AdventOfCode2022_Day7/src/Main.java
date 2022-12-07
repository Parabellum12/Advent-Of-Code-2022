import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));

		Directory currentDir = null;
		Directory MainDir = null;;
		
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] data = line.split(" ");
			if (data[0].equals("$"))
			{
				//command
				switch (data[1])
				{
				case "cd":
					//change directory
					if (data[2].equals(".."))
					{
						//move out 1 directory
						currentDir = currentDir.containingDir;
					}
					else if (data[2].equals("/"))
					{
						//main dir
						if (MainDir != null)
						{
							currentDir = MainDir;
						}
						else
						{
							MainDir = new Directory("/", null);
							currentDir = MainDir;
						}
					}
					else
					{
						//change directory
						boolean DirFound =  false;
						for (Directory dir : currentDir.containedDirectorys)
						{
							if (dir.Name.equals(data[2]))
							{
								currentDir = dir;
								DirFound = true;
								break;
							}
						}
						if (!DirFound)
						{
							Directory temp = new Directory(data[2], currentDir);
							currentDir.containedDirectorys.add(temp);
							currentDir = temp;
						}
					}
					
					
					break;
				case "ls":
					//list
					//MainDir.List(0);
					break;
				}
			}
			else if (data[0].equals("dir"))
			{
				Directory temp = new Directory(data[1], currentDir);
				currentDir.containedDirectorys.add(temp);
			}
			else 
			{
				Files temp = new Files(data[1], Integer.valueOf(data[0]));
				currentDir.containedFiles.add(temp);
			}
		}
		//part 1
		MainDir.List(0);
		ArrayList<Directory> temp1 = new ArrayList<>();
		temp1.add(MainDir);
		temp1.addAll(MainDir.getAllDirectorys());
		long totalSize = 0;
		for (Directory dir : temp1)
		{
			long templong = dir.getTotalSize();
			if (templong <= 100000)
			{
				totalSize +=  templong;
			}
		}
		System.out.println("Part 1 test:"+MainDir.containedDirectorys.get(0).getTotalSize());
		System.out.println("Part 1:"+totalSize);
		
		//part 2
		long MaxMem = 70000000;
		long neededMem = 30000000;
		long DeletionMemNeeded = neededMem-(MaxMem-MainDir.getTotalSize());
		ArrayList<Directory> temp2 = new ArrayList<>();
		for (Directory dir : temp1)
		{
			long templong = dir.getTotalSize();
			if (templong >= DeletionMemNeeded)
			{
				temp2.add(dir);
			}
		}
		long minSize = Long.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < temp2.size(); i++)
		{
			if (temp2.get(i).getTotalSize() < minSize)
			{
				minSize = temp2.get(i).getTotalSize();
				index = i;
			}
		}
		System.out.println(temp2.get(index).Name + ":"+temp2.get(index).getTotalSize());
	}

}
