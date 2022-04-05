
/**
 * A class for testing a Hash Table & Spelling Checker
 *
 * @author Michael Buescher and Post-AP CS at Hathaway Brown
 * @version 2022-03
 */

import java.util.Scanner;
import java.io.*;

public class MakeHashTester
{
    MyHashTable hashTable;
    long startLoadMS, endLoadMS;
    long startCheckMS, endCheckMS;
    
    public void report ()
    {
        long elapsedLoadMS = endLoadMS - startLoadMS;
        System.out.println((0.001 * elapsedLoadMS) + " seconds to create the hash table.");
        
        long elapsedCheckMS = endCheckMS - startCheckMS;
        System.out.println((0.001 * elapsedCheckMS) + " seconds to spell-check the file.");
        
    }
    
    public MakeHashTester (String fileName)
    {
        int count = 0;
        hashTable = new MyHashTable();
        startLoadMS = System.currentTimeMillis();
        
        // Try to open the file for input.       
        File file = new File(fileName);
        Scanner wordFile = null;
        try
        {
            wordFile = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fileName + " ***");
            System.exit(1);        // quit the program
        } 

        while (wordFile.hasNext())
        {
            String nextWord = wordFile.next();
            hashTable.add(nextWord);
            count++;
        }
        wordFile.close();
        System.out.println ("Read " + count + " words from the file.");
        endLoadMS = System.currentTimeMillis();
    }

    public void printWordInfo(String str)
    {
        System.out.println(str + "\t" + str.hashCode() + "\t" 
               + hashTable.getKey(str) + "\t" + hashTable.contains(str));
    }
    
    public void testWords()
    {
        System.out.println("Enter a bunch of words, one per line, blank line to end.");
        Scanner kbd = new Scanner(System.in);
        String str = kbd.nextLine();
        while (str.length() > 0)
        {
            printWordInfo(str);
            str = kbd.nextLine();
        }
        kbd.close();
    }
    
    
    public void spellCheck(String fileName)
    {
        startCheckMS = System.currentTimeMillis();
        TextFile text = new TextFile(fileName);
        String word = text.getNextWord();
    
        while (word != null)
        {
            printWordInfo(word);
            word = text.getNextWord();
        }
        
        endCheckMS = System.currentTimeMillis();
    }
    
    public static void main (String[] args)
    {
        MakeHashTester tester = new MakeHashTester("popular.txt");
        //tester.testWords();
        
        tester.spellCheck("SimpleReview.txt");
        tester.report();
    }
}
