//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

import java.util.Scanner;
public class MaximalSquare {
    // Function to calculate the area of the largest square of 1s in the given matrix
    public int maximalSquare(char[][] matrix) {
        // Check for invalid input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Create a 2D array to store the dynamic programming results
        // dp[i][j] represents the size of the largest square ending at position (i, j)
        int[][] dp = new int[m + 1][n + 1];

        // Variable to store the maximum side length of the square found so far
        int maxSide = 0;

        // Iterate through the matrix to fill in the dynamic programming array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current cell in the matrix is '1', update dp[i][j]
                if (matrix[i - 1][j - 1] == '1') {
                    // dp[i][j] is calculated based on the minimum of the values to its top, left, and top-left
                    // plus 1, representing the size of the square ending at (i, j)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    // Update maxSide if a larger square is found
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        
        MaximalSquare solution = new MaximalSquare();          
        Scanner sc = new Scanner(System.in);                   

        // Provide the user input for the number of rows in the matrix
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        // Provide the user input for the number of columns in the matrix
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();

        // Create a 2D array to store the matrix elements
        char[][] matrix = new char[rows][cols];

        // User input for the elements of the matrix (0 or 1)
        System.out.println("Enter the elements of the matrix (0 or 1):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }

        // Call the maximalSquare function to calculate the largest square area
        int result = solution.maximalSquare(matrix);

        // Print the result
        System.out.println("Largest square area: " + result);
        sc.close();
    }
}