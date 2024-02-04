package textAnalysis;


import java.util.Scanner; // to read user input
import java.util.List; // to store words
import java.util.ArrayList; // to implement list
import java.util.Map; // to store character and word frequencies
import java.util.HashMap; // to implement map


public class TextAnalysis {

  public static void main(String[] args) {
    // create a Scanner object to read user input
    Scanner sc = new Scanner(System.in);

    // ask the user to input a paragraph or a lengthy text
    System.out.println("Please enter a paragraph or a lengthy text:");
    // read and store the input text
    String text = sc.nextLine();



    // perform character count
    characterCount(text);

    // perform word count
    wordCount(text);

    // perform most common character
    mostCommonCharacter(text);

    // perform character frequency
    characterFrequency(text);

    // perform word frequency
    wordFrequency(text);

    // perform unique words
    uniqueWords(text);
    
    // close the Scanner object
    sc.close();
  }

//a method to calculate and display the total number of characters in the input text (excluding spaces)
public static void characterCount(String text) {
   // create a variable to store the character count
   int count = 0;

   // loop through each character in the text
   for (int i = 0; i < text.length(); i++) {
       // get the current character and check if it is not a space
       if (text.charAt(i) != ' ') {
           count++;
       }
   }

   // display the result
   System.out.println("The total number of characters in the text (excluding spaces) is " + count);
}


  // a method to calculate and display the total number of words in the input text
  public static void wordCount(String text) {
    // split the text by spaces and store the words in an array
    String[] words = text.split(" ");
    // get the length of the array
    int count = words.length;
    // display the result
    System.out.println("The total number of words in the text is " + count);
  }

  // a method to find and display the most common character in the text
  public static void mostCommonCharacter(String text) {
	    // create a map to store the character and its frequency
	    Map<Character, Integer> frequencyMap = new HashMap<>();
	    
	    // loop through each character in the text
	    for (int i = 0; i < text.length(); i++) {
	        // get the current character and convert it to lower case
	        char ch = Character.toLowerCase(text.charAt(i));

	        // skip spaces
	        if (ch == ' ') {
	            continue;
	        }

	        // check if the character is already in the map
	        if (frequencyMap.containsKey(ch)) {
	            // increment its frequency by one
	            frequencyMap.put(ch, frequencyMap.get(ch) + 1);
	        } else {
	            // add the character to the map with frequency one
	            frequencyMap.put(ch, 1);
	        }
	    }

	    // create a variable to store the most common character
	    char mostCommon = ' ';
	    // create a variable to store the highest frequency
	    int maxFrequency = 0;

	    // loop through each entry in the map
	    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
	        // get the current character and its frequency
	        char ch = entry.getKey();
	        int frequency = entry.getValue();

	        // check if the frequency is higher than the max frequency
	        if (frequency > maxFrequency) {
	            // update the most common character and the max frequency
	            mostCommon = ch;
	            maxFrequency = frequency;
	        }
	    }

	    // display the result
	    System.out.println("The most common character in the text (excluding spaces) is " +
	            mostCommon + " with frequency " + maxFrequency);
	}


  // a method to ask the user to input a character and check and display the frequency of occurrences of this character in the text
  public static void characterFrequency(String text) {
    // create a Scanner object to read user input
    Scanner sc = new Scanner(System.in);
    // ask the user to input a character
    System.out.println("Please enter a character:");
    // read and store the input character
    char ch = sc.next().charAt(0);
//    // close the Scanner object
//    sc.close();
    // create a variable to store the frequency
    int frequency = 0;
    // loop through each character in the text
    for (int i = 0; i < text.length(); i++) {
      // get the current character and convert it to lower case
      char current = Character.toLowerCase(text.charAt(i));
      // check if the current character is equal to the input character (case-insensitive)
      if (current == Character.toLowerCase(ch)) {
        // increment the frequency by one
        frequency++;
      }
    }
    // display the result
    System.out.println("The frequency of " + ch + " in the text is " + frequency);
  }

  // a method to ask the user to input a word and check and display the frequency of occurrences of this word in the text
  public static void wordFrequency(String text) {
    // create a Scanner object to read user input
    Scanner sc = new Scanner(System.in);
    // ask the user to input a word
    System.out.println("Please enter a word:");
    // read and store the input word
    String word = sc.next();

    // create a variable to store the frequency
    int frequency = 0;
    // split the text by spaces and store the words in an array
    String[] words = text.split(" ");
    // loop through each word in the array
    for (String w : words) {
      // check if the word is equal to the input word (case-insensitive)
      if (w.equalsIgnoreCase(word)) {
        // increment the frequency by one
        frequency++;
      }
    }
    // display the result
    System.out.println("The frequency of " + word + " in the text is " + frequency);
  }
  

  // a method to calculate and display the number of unique words in the text (case-insensitive)
  public static void uniqueWords(String text) {
    // create a list to store the unique words
    List<String> uniqueList = new ArrayList<>();
    // split the text by spaces and store the words in an array
    String[] words = text.split(" ");
    // loop through each word in the array
    for (String w : words) {
      // create a flag to indicate if the word is unique or not
      boolean isUnique = true;
      // loop through each word in the unique list
      for (String u : uniqueList) {
        // check if the word is equal to any word in the unique list (case-insensitive)
        if (w.equalsIgnoreCase(u)) {
          // set the flag to false and break the loop
          isUnique = false;
          break;
        }
      }
      // check if the flag is true
      if (isUnique) {
        // add the word to the unique list
        uniqueList.add(w);
      }
    }
    // get the size of the unique list
    int count = uniqueList.size();
    // display the result
    System.out.println("The number of unique words in the text is " + count);
  }
}
