package CHP08_2D_ARRAYS; /**
 * Created by Lechu on 2017-04-20.
 */
import java.util.Scanner;
import java.util.Random;

public class Programming_Ex_01 {

    static Scanner input = new Scanner(System.in);

    public static void main (String[] args)
    {
        System.out.print("Enter the number of rows and columns");
        int row = input.nextInt();
        int col = input.nextInt();
        int [][] sumColumnArray = new int[row][col];
        setNumbers(sumColumnArray);
        displayArray(sumColumnArray);
        System.out.print("Give index of the column to sum ? ");
        try {
            int index = input.nextInt();
            System.out.print("The sum of column " + index + " is: " + sumColumn(sumColumnArray, index));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is out of range.");
        }
        input.close();
    }
    /**
     * dispay the array
     *
     * @param B
     * */
    public static void displayArray(int [][] B)
    {
        for ( int i = 0 ; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++)
                System.out.print(B[i][j] + " ");
            System.out.println();
        }
    }
    /**
     * Stores numbers into array
     *
     * @param A
    */
    public static void setNumbers(int [][] A)
    {
        Random randNumber = new Random();
        for ( int i = 0 ; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                A[i][j] = randNumber.nextInt(10);
    }
    /**
     * displays the sum of a specified column
     * @param columnIndex
     * @param m
     * @return  sum
     * */

    public static int sumColumn(int [][] m, int columnIndex)
    {
        int sum = 0;
        for (int i = 0; i < m.length ; i++){
            sum += m[i][columnIndex];
        }
        return sum;
    }

}
