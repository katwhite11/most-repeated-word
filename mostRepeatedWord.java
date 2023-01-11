/*
author: Kathryn White
purpose: This program receives a sentence input from a user and then has the ability to set that string, 
return the string, or find the most used string in the sentence via different methods. 
*/
import java.util.Scanner;


class MyString{
    //instance fields
    String s;
    
    //constructor with null string
    MyString(){
        s = "";
    }

    //gets a string as input parameter and assigns it to s
    public void setMyString(String newS){
        s = newS;
    }

    //returns s
    public String getMyString(){
        return s;
    }

    /*returns the word in s that repeats the most times
    note: if two words appear equally, will return first word
    */
    String getMode(){
     
        //instance variables
        int counter;
        counter = 1;
    
        //counts spaces in string
        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j) == ' ')
                counter++;
        }
        
        //instance variables
        String[] words = new String[counter]; //creates array with number of words determined by counter
        int l, m;
        l = 0;
        m = s.indexOf(" ");
        
       //stores each word into an array
       for(int i = 0; i < counter ; i++){
           if(i == counter-1){
            words[i] = s.substring(l);
            l = m+1;
           }
           else{
            words[i] = s.substring(l,m);
            l = m+1;
            m = s.indexOf(" ", l);
           }
       }
       
        //instance variables  
        int counter2;
        int max = 0;
        String mostRepeated = "";
        
        //finds most used word
        for(String word: words){
            counter2 = 1;
            for(String nextWord: words){
                if(word.equals(nextWord)){
                    counter2++;
                }
                if(counter2>max){
                    max = counter2;
                    mostRepeated = word;
                }
            }
        }

       return mostRepeated;
 
    }
}

public class Hw05 {
    
    public static void main(String[] args) {
        
        //test
        String userInput;
        Scanner in = new Scanner(System.in);
        MyString test = new MyString();
        
        System.out.println("Please type a sentence: ");
        
        userInput = in.nextLine();
        test.setMyString(userInput);
        
        System.out.println("The most repeated word is: "+test.getMode());
        
        
    }
    
}
