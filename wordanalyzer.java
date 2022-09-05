package cen3024;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;


public class wordanalyzer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1. create input stream and scanner		
		FileInputStream findIt = new FileInputStream("theraven.txt");
		Scanner fileInput = new Scanner(findIt);

		//2. creation of array list for String and Integer type 
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();


		//3. Reading through file and to find the words/strings
		while (fileInput.hasNext()) {
	
			//4. Getting the word and passing to file input 
			String nextWord = fileInput.next();
	
			//5. checking if the word is in the array list with if statement
			if (words.contains(nextWord)) {
				int index = words.indexOf(nextWord);
				count.set(index,  count.get(index)+ 1);
			}
			else {
				words.add(nextWord);
				count.add(1);
			}
		}
		
		//6. closing input streams
		fileInput.close();
		findIt.close();

		//7. Print out the results to file
		for (int i = 0; i < words.size(); ++i) {
			Collections.sort(count, Collections.reverseOrder());
	
			//8. creating FileWriter to write output to the file
			try(FileWriter fw = new FileWriter("theraven.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw))
			{
				out.println();
				out.println(words.get(i) + " occurred " + count.get(i) + " times ");
				
			//9. exception handling for FileWriter	
			} catch (IOException e) {
			}
		}
	}
}
