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
		
//create input stream and scanner		
FileInputStream fin = new FileInputStream("theraven.txt");
Scanner fileInput = new Scanner(fin);

//create array list 
ArrayList<String> words = new ArrayList<String>();
ArrayList<Integer> count = new ArrayList<Integer>();


//Read through file and find the words
while (fileInput.hasNext()) {
	//GEt the word
	String nextWord = fileInput.next();
	
	//determine if the word is in the array list
	if (words.contains(nextWord)) {
		int index = words.indexOf(nextWord);
		count.set(index,  count.get(index)+ 1);
	}
	else {
		words.add(nextWord);
		count.add(1);
	}
	
}
fileInput.close();
fin.close();

//Print out the results to file
for (int i = 0; i < words.size(); ++i) {
	Collections.sort(count, Collections.reverseOrder());
	
	try(FileWriter fw = new FileWriter("theraven.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println("\n" + words.get(i) + " occurred " + count.get(i) + " times ");
		    //more code
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		
	//System.out.println(words.get(i) + " occurred " + count.get(i) + " times ");
}

	}

}
