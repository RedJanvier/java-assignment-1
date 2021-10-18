package stringreverseapp;

import java.util.Scanner;

// Interface to define abstract methods on the ReverseUtils class
interface IUtils {
    // abstract setter method to change the string (input)
    abstract public void setWord(String s);
    // abstract method to reverse the property a (input string)
    abstract public String reverseString ();
}

class ReverseUtils implements IUtils {
    // Define a as protected so as it can be accessed by this and child classes
    protected String a;
    
    // Constructor to define initial value of the input string
    ReverseUtils (String str) {
        a = str;
    }
    
    // Custom method that is used to change a string to characters array (private to this class only)
    private char[] toCharArr(String str) {
        return str.toCharArray();
    }
    
    // Implement the abstract setter method to set a new string as input by overriding it
    @Override
    public void setWord(String str) {
        a = str;
    }
    
    // Implementing the core reverseString method by looping on the string in reverse;
    @Override
    public String reverseString () {
        char chars[] = toCharArr(a);
        String reverse="";
        
        // Loop on the string from the end to start by creating a new string from each character
        for(int i = chars.length-1; i >= 0;i--){ 
            reverse += chars[i];
        }
        
        return reverse;
    }
}

// Create a Utilities class that inherits from ReverseUtils and adds a static method to scan a String
class Utils extends ReverseUtils {
    Utils (String str){
        super(str);
    }
    
    public static String scanString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
}

// Main application
class StringReverseApp {
    public static void main (String[] args) {
        System.out.println("------------------------------------");
        System.out.println("----------- EXAMPLES ---------------");
        System.out.println("------------------------------------");
        
        /* EXAMPLE 1 */
        String input = "example1";
        // Using the contructor to initiate an instance with a value
        Utils ut = new Utils(input);
        // Call the method reverseString to reverse the protected value of input
        String output = ut.reverseString(); 
        // Printing the input and output to console
        System.out.println("Input String: " + input);
        System.out.println("Output String: " + output);
        System.out.println("------------------------------------");
        
        /* EXAMPLE 2 */
        input = "urugero2";
        // Use the setter method to change value of input the reverse it
        ut.setWord(input);
        output = ut.reverseString();
        // Printing the input and output to console
        System.out.println("Input String: " + input);
        System.out.println("Output String: " + output);
        System.out.println("------------------------------------");
        
        /* EXAMPLE 3 */
        input = "1234567890";
        ut.setWord(input);
        output = ut.reverseString();
        System.out.println("Input String: " + input);
        System.out.println("Output String: " + output);
        System.out.println("------------------------------------");
        
        System.out.println("------------------------------------");
        System.out.println("---------- CUSTOM INPUT ------------");
        System.out.println("------------------------------------");
        
        // Capture input from the console using static method
        System.out.println("Enter another string: ");
        String newInput = Utils.scanString();
        // Set the scanned input as the input using setter and reverse it
        ut.setWord(newInput);
        String newOutput = ut.reverseString();
        // Print the values of input and output to console
        System.out.println("Input String: " + newInput);
        System.out.println("Output String: " + newOutput);
        System.out.println("------------------------------------"); 
    }
}
