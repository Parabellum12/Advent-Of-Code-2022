import java.util.*;

public class Directory {

	public String Name;
	public Directory containingDir;
	public ArrayList<Directory> containedDirectorys = new ArrayList<>();
	public ArrayList<Files> containedFiles = new ArrayList<>();
	public Directory(String name, Directory containing)
	{
		Name = name;
		containingDir = containing;
	}
	
	public long getTotalSize()
	{
		long returner = 0;
		for (Files f : containedFiles)
		{
			returner+=f.Size;
		}
		for (Directory dir : containedDirectorys)
		{
			returner += dir.getTotalSize();
		}
		return returner;
	}
	
	public void List(int indent)
	{
		String indents = "";
		for (int i = 0; i < indent; i++)
		{
			indents += " ";
		}
		System.out.println(indents+"- " + Name + " (dir)");
		for (Directory dir : containedDirectorys)
		{
			dir.List(indent+1);
		}
		for (Files f : containedFiles)
		{
			f.Print(indent+1);
		}
	}
	
	public ArrayList<Directory> getAllDirectorys()
	{
		ArrayList<Directory> reutrner = new ArrayList<>();
		for (Directory dir : containedDirectorys)
		{
			reutrner.add(dir);
			reutrner.addAll(dir.getAllDirectorys());
		}
		return reutrner;
	}
}
