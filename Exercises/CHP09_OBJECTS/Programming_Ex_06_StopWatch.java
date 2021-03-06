package CHP09_OBJECTS;

import java.util.Random;
/**
 * Created by Lechu on 2017-05-07.
 */
/*
* (Stopwatch) Design a class named CHP09_OBJECTS.StopWatch. The class contains:
 ■ Private data fields startTime and endTime with getter methods.
 ■ A no-arg constructor that initializes startTime with the current time.
 ■ A method named start() that resets the startTime to the current time.
 ■ A method named stop() that sets the endTime to the current time.
 ■ A method named getElapsedTime() that returns the elapsed time for the
stopwatch in milliseconds.
 Draw the UML diagram for the class and then implement the class. Write a test
program that measures the execution time of sorting 100,000 numbers using
selection sort
*/
public class Programming_Ex_06_StopWatch {

    public static void main (String[] args)
    {
        int[] array = generateArray(100000);
        //display(array);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selectSort(array);
        stopWatch.stop();
        System.out.print("Sorting time in s= "+ stopWatch.getElapsedTime()*0.001);
    }
    /**
     * Display the array, only for test
     * @param A
     * */
    public static void display(int [] A)
    {
        for(int i = 0 ; i < A.length ; i ++)
        {
            System.out.print(A[i] + " ");
        }
    }
    /**
     * Sort the array from smallest.
     * @param A
     * */
    public static void selectSort(int [] A)
    {
        for (int i = 0 ; i < A.length ; i++)
        {
            int minimumIndex = i;
            for (int j = i + 1 ; j < A.length; j++)
            {
                if (A[minimumIndex] > A[j])
                    minimumIndex = j;
            }
            if (minimumIndex != i) {
                int temp = A[i];
                A[i] = A[minimumIndex];
                A[minimumIndex] = temp;
            }
        }
    }
    /**
     * Generate a random filled array with ints from 0 to 999
     * @param size
     * @return
     * */
    public static int[] generateArray(int size)
    {
        int [] A = new int[size];
        Random random = new Random();
        for (int i = 0; i < A.length ; i++ )
        {
            A[i] = random.nextInt(1000);
        }
        return A;
    }
}
/**
 * Class Stopwatch for measuring time from calling start() to stop()
 * */
class StopWatch
{
    private long startTime;
    private long endTime;
/**
 * Constructor - when creating an instance of this class the strattime starts at the current time.
 * */
    public StopWatch()
    {
        this.startTime = System.currentTimeMillis();
    }
    /**
     * Reset the start time
     */
    public void start()
    {
        setStartTime(System.currentTimeMillis());
    }
    /**
     * Save the endtime
     * */
    public void stop()
    {
        setEndTime(System.currentTimeMillis());
    }
    /**
     * Returns the time from start to end
     * @return
     * */
    public long getElapsedTime()
    {
        return getEndTime() - getStartTime();
    }
    public long getEndTime() {
        return endTime;
    }
    public long getStartTime() {
        return startTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
