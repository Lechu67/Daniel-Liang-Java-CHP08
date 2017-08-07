package CHP08_2D_ARRAYS; /**
 * Created by Lechu on 2017-04-20.
 */
import java.util.Random;
import  java.util.Scanner;

public class Programing_Ex_02 {

        static Scanner input = new Scanner(System.in);

    public  static void main (String[] args)
    {
        System.out.print("Enter numeber of rows and columns");
        int row = input.nextInt();
        int col = input.nextInt();
        int [][] TheArray = new int [row][col];
        setNumbers(TheArray);
        display(TheArray);
        System.out.print(sumOfDiagonal(TheArray));
    }
    /**
     * Give the sum of number in the major diagonal
     * @param A
     * @return sum
     * */
    public static  int sumOfDiagonal(int [][] A)
    {
        int sum = 0;
        for ( int i = 0 ; i < A.length; i++)
            for (int j = i; j <= i; j++)
                sum+= A[i][j];
        return sum;
        }

    public static void display(int [][] A)
    {
        for ( int i = 0 ; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++)
                System.out.print(A[i][j]+" ");
            System.out.println();
        }
    }

    public static void setNumbers(int [][] A)
    {
        Random randomNum = new Random();
        for ( int i = 0 ; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                A[i][j] = randomNum.nextInt(10);
    }
}
