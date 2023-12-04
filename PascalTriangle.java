//Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.Scanner;
public class PascalTriangle 
{
    public static int[][] pascalTriangle(int numRows) 
    {
        // If numRows is less than or equal to zero return an empty array
        if (numRows <= 0) 
        {
            return new int[0][0];
        }

        // Initialize 2D array to store Pascal's Triangle
        int[][] result = new int[numRows][];

        // Iterate through each row of Pascal's Triangle.
        for (int i = 0; i < numRows; i++) 
        {
            // Create a new array for each row
            result[i] = new int[i + 1];
            
            // Set the first and last elements of each row to 1
            result[i][0] = result[i][i] = 1; 

            // Calculate the inner elements based on the sum of two elements from the previous row
            for (int j = 1; j < i; j++) 
            {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }

        // Return the resulting Pascal's Triangle
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Provide the user input for number of rows
        System.out.print("Enter numRows: ");
        int numRows = sc.nextInt();

        // Generate Pascal's Triangle
        int[][] pascalsTriangle = pascalTriangle(numRows);

        // Display Pascal's Triangle 
        System.out.print("[");
        for (int i = 0; i < pascalsTriangle.length; i++) 
        {
            System.out.print("[");
            for (int j = 0; j < pascalsTriangle[i].length; j++) 
            {
                System.out.print(pascalsTriangle[i][j]);

                if (j < pascalsTriangle[i].length - 1) 
                {
                    System.out.print(",");
                }
            }
            System.out.print("]");

            //If the current row is not the last one, include a comma
            if (i < pascalsTriangle.length - 1) 
            {
                System.out.print(",");
            }
        }
        System.out.print("]");
        sc.close();
    }
}