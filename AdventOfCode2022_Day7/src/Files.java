
public class Files {
	public String Name;
	public long Size;
	public Files(String name, long size)
	{
		Name = name;
		Size = size;
	}
	
	public void Print(int indent)
	{
		String indents = "";
		for (int i = 0; i < indent; i++)
		{
			indents += " ";
		}
		System.out.println(indents+"- " + Name + " (File, size="+Size+")");
	}
}
