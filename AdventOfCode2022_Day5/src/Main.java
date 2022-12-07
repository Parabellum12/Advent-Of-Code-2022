import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String testString = "abcdefghijklmnopqrstuvwxyz";
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Input.txt"));
		ArrayList<Stack> stacks = new ArrayList<Stack>();
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		stacks.add(new Stack());
		
		
		boolean inSetup = true;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			//spaces/4+1
			if (inSetup)
			{
				System.out.println(line);
				if (line.contains("1"))
				{
					inSetup = false;
					String out = "Test:";
					for (Stack s : stacks)
					{
						if (s.isEmpty())
						{
							continue;
						}
						out += s.peek();
					}
					System.out.println(out);
					
					for (int i = 0; i < stacks.size(); i++)
					{
						Stack temp = new Stack();
						while (stacks.get(i).size() > 0)
						{
							temp.push(stacks.get(i).pop());
						}
						stacks.get(i).addAll(temp);
					}
					
					
					
					
				}
				else
				{
					for (int i = 0; i < line.length(); i++)
					{
						if (testString.contains(String.valueOf(line.charAt(i)).toLowerCase()))
						{
							System.out.println(i + ":" + i/4 + ":" + String.valueOf(line.charAt(i)));
							stacks.get(i/4).push(String.valueOf(line.charAt(i)));
						}
					}
				}
			
			}
			else
			{
				//move code
				String[] word = line.split(" ");
				if (word.length > 0 && word[0].equals("move"))
				{
					int amount = Integer.valueOf(word[1]);
					int from = Integer.valueOf(word[3])-1;
					int to = Integer.valueOf(word[5])-1;
					System.out.println(line+": "+amount+":"+from+":"+to);
					/*part 1
					for (int i = 0; i < amount; i++)
					{
						System.out.println("	"+stacks.get(from).peek());
						stacks.get(to).push(stacks.get(from).pop());
					}
					*/
					
					Stack temp = new Stack();
					for (int i = 0; i < amount; i++)
					{
						System.out.println("	"+stacks.get(from).peek());
						temp.push(stacks.get(from).pop());
					}
					while (temp.size() > 0)
					{
						stacks.get(to).push(temp.pop());
					}
					
					
					
				}
			}
		}
		String out = "out:";
		for (Stack s : stacks)
		{
			if (s.isEmpty())
			{
				continue;
			}
			out += s.peek();
		}
		System.out.println(out);
	}

}
