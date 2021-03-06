
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Donnie Sandlin
 */
public class Assignment3 {

    private double wordfound;
    private double wordnotfound;
    private int[] record = new int[1];
    private double numRWNF = 0;
    private double numRWF = 0;
    BinarySearchTree[] dict = new BinarySearchTree[26];
    private String[] analyze;

    Assignment3() {
    }

    /**
     * reads in the dictionary and stores into an array
     */
    public void readFile() {
        for (int i = 0; i < dict.length; i++) {
            dict[i] = new BinarySearchTree<String>();
        }
        try {
            FileReader input = new FileReader("random_dictionary.txt");
            String word = "";
            int i = 0;
            char ch;
            while ((i = input.read()) != -1) {
                ch = (char) i;
                if (Character.isLetter(ch)) {
                    word += ch;
                }
                if (ch == 10 || ch == 45 || ch == 32 && word.length() != 0) {
                    word = word.toLowerCase();
                    dict[word.charAt(0) - 97].insert(word);
                    word = "";
                }
            }
            input.close();
        } catch (IOException Ex) {
            System.out.println("No File Found. ");
        }
    }

    /**
     * reads in and compares the oliver file with it
     */
    public void readSpelling() {

        try {
            File data2 = new File("oliver.txt");
            Scanner read2 = new Scanner(data2);

            while (read2.hasNext()) {
                String c1 = read2.next();
                String c2 = c1.toLowerCase();
                c2 = c2.trim();
                analyze = c2.split("[ \\| \\{ \\~ \\}` = : _ - \\& # $ % ^ ( ) + \\, \\. ; ! / ? < > \\* \\- \" '  \\[ \\] \\+ \\@ 1 2 3 4 5 6 7 8 9 0]");


                for (int i = 0; i < analyze.length; i++) {


                    if (!analyze[i].isEmpty()) {

                        if (dict[(int) analyze[i].charAt(0) - 97].search(analyze[i], record)) {
                            wordfound++;
                            numRWF += record[0];
                        } else {
                            //System.out.println(analyze[i]);
                            wordnotfound++;
                            numRWNF += record[0];

                        }
                        record[0] = 0;
                    }

                }
            }

            read2.close();
        } catch (IOException E) {
            System.out.println("File not found");
        }
    }

    /**
     *
     * @return String output of results
     */
    @Override
    public String toString() {
        return "Words found/correct words: " + wordfound + "\nWords Not Found/incorrect: " + wordnotfound
                + "\ntotal comparison: " + numRWF + "\nword incorrect comparison: " + numRWNF + "\navg word found: " + numRWF / wordfound
                + "\navg word not found: " + numRWNF / wordnotfound;
    }
}
