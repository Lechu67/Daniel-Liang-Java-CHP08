package CHP08_2D_ARRAYS; /**
 * Created by Lechu on 2017-04-23.
 */

import java.util.Random;

public class Programming_Ex_04 {

    public static void main(String[] args) {
        int numberOfEmployee = 10;
        final int daysWeek = 7;
        double[][] employeeHours = new double[numberOfEmployee][daysWeek];
        int[] empID = new int[numberOfEmployee];
        setID(empID);
        setHours(employeeHours);
        display(employeeHours, empID);
        sortHours(employeeHours, empID);
        display(employeeHours, empID);
    }

    public static void setID(int [] A)
    {
        for( int i = 0 ; i <A.length;i++)
        {
            A[i] = i +1;
        }
    }

    public static void sortHours(double [][]A, int [] empID)
    {
        for( int i = 0 ; i <A.length- 1;i++)
            for(int j = i +1; j<A.length; j++)
            {
                if (getSum(A[i]) > getSum(A[j]))
                {
                    double [] tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;

                    int tmpID = empID[i];
                    empID[i] = empID[j];
                    empID[j] = tmpID;
                }
            }
    }

    public static double getSum(double [] A)
    {
        double sum = 0;
        for( int i = 0 ; i <A.length;i++)
            sum+=A[i];
        return sum;
    }

    public static void setHours(double[][] A) {
        Random random = new Random();
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[j].length; j++)
                A[i][j] = random.nextInt(10);
    }

    public static void display(double[][] A, int[] empID) {
        System.out.printf("%9s%5s%5s%5s%5s%5s%5s\n","Mon","Tue","Wen","Thu","Fri","Sat","Sun");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%3s%d ","Emp ",empID[i]);
            double sum = 0;
            for (int j = 0; j < A[j].length; j++) {
                System.out.print(A[i][j] + "  ");
                sum += A[i][j];
            }
            System.out.printf("%s%.2f\n", "= ",sum);
        }
    }
}

