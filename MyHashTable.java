/**
 *  Stores a list of words in an array.
 *  Reads the words from a file;
 *  stores them in an array of Strings;
 *  can retrieve them.
 */

import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;


public class MyHashTable

{
    private final int TABLE_SIZE = 40000;
    private LinkedList [] table;

    /** The constructor sets up the hash table
     */
    public MyHashTable()
    {
        table = new LinkedList [TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            table[i] = new LinkedList<String>();
        }
    }

    /** Gets the key for a String
     *  @param  str  The string to get a key for
     *  @return The key for that String
     *  POSTCONDITION:  0 <= key < TABLE_SIZE
     */
    public int getKey (String str)
    {
        return Math.abs(str.hashCode()) % TABLE_SIZE;
    }
    
    /**
     *  Adds the given word to the hash table
     *  @param  str the word to add to the table
     */
    public void add (String str)
    {
        // Your code here!
        table[getKey(str)].add(str);
    }
  
    /** 
     *  Determines whether the given string is in the hash table
     *  @param   str  the word to search for
     *  @return  whether the string is in the hash table
     */
    public boolean contains (String str)
    {
        // This does NOT work properly. Replace it!
        return table[getKey(str)].contains(str);
    }
}