/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kozusznik.pl1.lab10;

/**
 *
 * @author Dan Krupa
 */
public class Main 
{
    public static void main(String [] args)
    {
        Book b = new Book();
    
        char searched = 'a';
        String characters = "ěýáíéeuioúaůyó";
        boolean casesensitivity = true;
        
        String word1 = "stařec";
        String word2 = "moře";
        
        System.out.println("Occurrences of "+ searched +": " +b.OccurenceOfLetter(searched,b.toString()));
        System.out.println("Occurrences of lowercase vowels: " +       b.OccurenceOfCharacters(characters.toLowerCase(),b.toString(),casesensitivity));
        System.out.println("Occurrences of uppercase vowels: " +       b.OccurenceOfCharacters(characters.toUpperCase(),b.toString(),casesensitivity));
        System.out.println("Occurrences of all vowels: " +       b.OccurenceOfCharacters(characters,b.toString(),!casesensitivity));
        System.out.println("Occurrences of "+word1+": " +       b.OccurenceOfWord(word1,b.toString()));
        System.out.println("Occurrences of "+word2+": " +       b.OccurenceOfWord(word2,b.toString()));
        
        System.out.println("Word number: " +b.WordCount(b.toString()));
    
    
    
    
    
    
    }
    
}
