import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AnagramsLab {
	private static String charSort(String s) {
		char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
	}
	
	private static String promptForFileName() {
		System.out.println("ENTER FILE NAME: ");
		Scanner keyIn = new Scanner(System.in);
		return keyIn.next();
	}
	
	private static Scanner openFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		while (!file.exists()) {
			file = new File(promptForFileName());
		}
		return new Scanner(file);
	}

	private static ArrayList<String> generateRepList(ArrayList<String> aList) {
		ArrayList<String> uniqList = new ArrayList<String>();
		for (int i = 0; i < aList.size(); i++) {
			if (!uniqList.contains(charSort(aList.get(i)))) {
				uniqList.add(charSort(aList.get(i)));
			}
		}
		return uniqList;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		long startTime = System.nanoTime();

		String fileName;
		if (args.length > 0) {
			fileName = args[0];
		} else {
			fileName = promptForFileName();
		}
		Scanner fileReader = openFile(fileName);

		ArrayList<String> aList = new ArrayList<String>();
		while (fileReader.hasNextLine()) {
			aList.add(fileReader.nextLine());
		}

		ArrayList<String> repList = generateRepList(aList);


		ArrayList<AnagramsList> anagramList = new ArrayList<AnagramsList>();
		for (int i = 0; i < repList.size(); i++) {
			AnagramsList ana = new AnagramsList();
			ana.setRep(repList.get(i));
			anagramList.add(ana);
		}


		for (int word = 0; word < aList.size(); word++) {
			int index = repList.indexOf(charSort(aList.get(word)));
			anagramList.get(index).addAnagram(aList.get(word));

		}

		for (int i = 0; i < anagramList.size(); i++) {
			if (anagramList.get(i).getAnagramCount() > 4) {
				System.out.println(anagramList.get(i));
			}

		}

		System.out.println();
		System.out.println("TOTAL NUMBER OF ANAGRAM GROUPS CALCULATED: " + anagramList.size());



		long endTime = System.nanoTime();
		long diff = endTime - startTime;
		System.out.println("ANAGRAM SEARCH ALGORITHM TOOK " + diff/1000000 + " MILLISECONDS");

	}
		
		
}




