//You are given a string s. You can convert s to a palindrome by adding characters in front of it.
//Return the shortest palindrome you can find by performing this transformation.
import java.util.Scanner;

public class ShortestPalindrome 
{
    // Method to find the shortest palindrome by adding characters to the beginning of the given string
    public String shortestPalindrome(String s) 
    {
        int n = s.length();
        int i = 0;

        // Iterate through the string in reverse order
        for (int j = n - 1; j >= 0; j--) 
        {
            if (s.charAt(i) == s.charAt(j))     // Checks if the character at the current position (i) is equal to the character at the current position in the reversed order
            {
                i++;
            }
        }

        // If the entire string is a palindrome, no need to add anything
        if (i == n) 
        {
            return s;
        }

        // Build the shortest palindrome by adding the reverse of the remaining suffix to the beginning
        StringBuilder suffix = new StringBuilder(s.substring(i));
        return suffix.reverse().toString() + s;
    }

    public static void main(String[] args) 
    {
        ShortestPalindrome solution = new ShortestPalindrome();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        // Find and display the shortest palindrome
        String result = solution.shortestPalindrome(input);
        System.out.println("Shortest Palindrome: " + result);

        sc.close();
    }
}