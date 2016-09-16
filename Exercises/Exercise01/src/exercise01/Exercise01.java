/**
 * 
 */
package exercise01;

import java.io.File;
import java.util.Scanner;

/**
 * @author park
 *
 */
public class Exercise01 {
	private static String question = "Enter a number or return to end";
	private static final String dataPath = "data.txt";
	private static int[][] theData;
	private static int maxRow = 0;		// These are the height and width of the maze
	private static int maxCol = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create a scanner to read the data
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(dataPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//first line is the array size
		String line = scanner.nextLine();
		//get the array size
		Scanner s = new Scanner(line);
		maxCol = s.nextInt();
		maxRow = s.nextInt();
		//initialize the array
		theData = new int[maxCol][maxRow];
		Scanner l;
		//now scan each line for data
		for (int r=0;r<maxRow;r++) {
			line = scanner.nextLine();
			l = new Scanner(line);
			int c = 0;
			//grab the data from each line
			while (l.hasNextInt())
				theData[r][c++] = l.nextInt();
			
		}
		System.out.println(mazeToString());
		scanner.close();
		//get ready to ask for a prompt
		scanner = new Scanner(System.in);
		ask();
		int theNumber = 0;
		boolean isFound = false;
		while (scanner.hasNextInt()) {
			theNumber = scanner.nextInt();
			
			if(!findNumberInArray(theNumber))
				System.out.println("Doesn't exist!");
				
			ask();
		}
		System.out.println("Thanks!");
	}
	
	/**
	 * Find all the hits of <code>number</code> in the array
	 * @param number
	 * @return  can return an empty array, initialized only to -1
	 */
	private static boolean findNumberInArray(int number) {
		System.out.println("Debug finding: "+number);
		boolean isFound = false;
	
		for (int r=0;r<maxRow;r++) {
			for (int c=0;c<maxCol;c++) {
				if (theData[r][c] == number) {
					System.out.println(r+" "+c);
					isFound = true;
				}
			}
		}
		System.out.println();
		if(isFound)
			return true;
		else
			return false;
	}
	/**
	 * Ask a question to be answered
	 */
	private static void ask() {
		System.out.println(question);
	}
	/**
	 * Create a String representation of the maze
	 */
	private static String mazeToString(){
		String str = "";
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++)
				str += theData[i][j]+" ";
			str += '\n';
		}
		return str;
	}

}
