import java.util.Scanner;

public class FloydWarshallAlgo {

    public void shortest_distance(int matrix[][]) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;  
                if (i == j)
                    matrix[i][j] = 0;          
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows and cols of matrix: ");
        int rows = sc.nextInt();
        int col = sc.nextInt();
        int matrix[][] = new int[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the values of "+i +","+j);
                int val = sc.nextInt();
                matrix[i][j] = val;
            }
        }

        FloydWarshallAlgo obj = new FloydWarshallAlgo();
        obj.shortest_distance(matrix);

        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
