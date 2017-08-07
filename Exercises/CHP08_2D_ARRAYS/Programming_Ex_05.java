package CHP08_2D_ARRAYS;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Lechu on 2017-05-03.
 */
public class Programming_Ex_05 {

    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter number of cols: ");
        int cols = in.nextInt();
        while  (cols != rows)
        {
            System.out.print("The value of the cols must be equal to the value of rows. Enter the value again: ");
            cols = in.nextInt();
        }
        double [][] Matrix_1 = new double[rows][cols];
        double [][] Matrix_2 = new double[rows][cols];
        fillArray(Matrix_1);
        fillArray(Matrix_2);
        display(Matrix_1);
        System.out.println();
        display(Matrix_2);
        System.out.println();
        display(addMatrix(Matrix_1,Matrix_2));

        in.close();
    }

    public static void display(double[][] A)
    {
        for( int i = 0; i < A.length ; i++)
        {
            for (int j = 0; j < A[i].length; j++ )
            {
                System.out.printf("%.2f ",A[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillArray(double[][] A)
    {
        Random random = new Random();
        for( int i = 0; i < A.length ; i++)
        {
            for (int j = 0; j < A[i].length; j++ )
            {
                A[i][j] = random.nextDouble();
            }
        }
    }

    public static double[][] addMatrix(double[][] A, double[][] B)
    {
        double [][] C = new double[A.length][A[0].length];
        for( int i = 0; i < A.length ; i++)
        {
            for (int j = 0; j < A[i].length; j++ )
            {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
}
