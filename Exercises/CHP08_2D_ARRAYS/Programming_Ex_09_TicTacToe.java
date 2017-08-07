package CHP08_2D_ARRAYS;

import java.util.Scanner;

/**
 * Created by Lechu on 2017-05-04.
 */
public class Programming_Ex_09_TicTacToe {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        displayBoard();
        playTic();

        in.close();
    }

    /**
     * Play the game
     */
    public static void playTic() {
        char[][] board = new char[3][3];
        char token = 0;

        while (true) {
            token = enterToken(token);
            int[] setTokenPosition = new int[2];
            while (true) {
                setTokenPosition(setTokenPosition);
                if (setTokenOnBoard(token, setTokenPosition,board))
                    break;
            }
            if (checkGameStatus(token, board))
                displayActualBoard(board);
            else {
                displayActualBoard(board);
                if (checkDraft(token,board)) {
                    System.out.println("Its a draft!");
                    break;
                }
                else{
                System.out.print(token + " wins!");
                break;
                }
            }
        }
    }
    /**
     * Displays the actual board
     *@param board */
    public static void displayActualBoard(char[][] board)
    {
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("[%c] ", board[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * Return false if the game is over
     * @param token
     * @param board
     * @return
     * */
    public static boolean checkGameStatus(char token, char[][]board)
    {
        if (checkVertically(token, board))
            return false;
        else if (checkHorizontally(token,board))
            return false;
        else if (checkDiagonal1(token,board))
            return false;
        else if (checkDiagonal2(token,board))
            return false;
        else if (checkDraft(token, board)) {
            return false;
        }
        else
            return true;
    }
    public static boolean checkDraft(char token, char[][]board)
    {
        int match9 = 0;
        boolean check = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] !=0) {
                    match9++;
                    if (match9 == 9)
                        check = true;
                }
            }
        }
        return check;
    }
    /**
     * Check if player token win the game diagonally (minor)
     * @param token
     * @param  board
     * @return
     * */
    public static boolean checkDiagonal2(char token, char[][] board)
    {
        int counter = 0;
        for (int i = board.length -1; i <= 0 ; i--)
        {
            for (int j =  i; j <= i; j++)
            {
                if (board[i][j] != token)
                    break;
                else{
                    counter++;
                }
            }
        }
        if (counter == 3) {
            System.out.println(" Diagonal(minor) win");
            return true;
        }
        return false;
    }
    /**
     * Check if player token win the game diagonally (major)
     * @param token
     * @param  board
     * @return
     * */
    public static boolean checkDiagonal1(char token, char[][] board)
    {
        int counter = 0;
        for (int i = 0; i < board.length ; i++)
        {
            for (int j =  i; j <= i; j++)
            {
                if (board[i][j] != token)
                    break;
                else{
                    counter++;
                }
            }
        }
        if (counter == 3) {
            System.out.println(" Diagonal(major) win");
            return true;
        }
        return false;
    }
    /**
     * Check if player token win the game horizontaly
     * @param token
     * @param  board
     * @return
     * */
    public static boolean checkHorizontally(char token, char[][] board)
    {

        for (int i = 0; i < board.length ; i++)
        {
            int counter = 0;
            for (int j =  0; j < board[0].length; j++)
            {
                if (board[i][j] != token)
                    break;
                else{
                    counter++;
                }
            }
            if (counter == 3) {
                System.out.println(" Horizontal win");
                return true;
            }
        }
        return false;
    }
    /**
     * Check if player token win the game horizontaly
     * @param token
     * @param  board
     * @return
     * */
    public static boolean checkVertically(char token, char[][] board)
    {

        for (int i = 0; i < board[0].length ; i++)
        {
            int counter = 0;
            for (int j =  0; j < board.length; j++)
            {
                if (board[j][i] != token)
                    break;
                else{
                    counter++;
                }
            }
            if (counter == 3) {
                System.out.println(" Vertical win");
                return true;
            }
        }
        return false;
    }
    /**
     * Places a token on the board
     * Will return flase if there is already a token on the board
     * @param token
     * @param  setTokenPosition
     * @return */
    public static boolean setTokenOnBoard(char token, int[] setTokenPosition, char[][] board)
    {
        if ( board[setTokenPosition[0]][setTokenPosition[1]] == 0)
            board[setTokenPosition[0]][setTokenPosition[1]] = token;
        else {
            System.out.println("Position already taken, try again");
            return false;
        }
        return true;
    }
    /**
     * Set the position of the token on the board
     * @param setTokenPosition
     * */
    public static void setTokenPosition(int[] setTokenPosition)
    {
        System.out.print("Give the position of \nx: ");
        setTokenPosition[0] = in.nextInt();
        while (setTokenPosition[0] > 2 || setTokenPosition[0] < 0) {
            System.out.print("You must enter a value between 0 and 2, try again");
            setTokenPosition[0] = in.nextInt();
        }
        System.out.print("\ny: ");
        setTokenPosition[1] = in.nextInt();
        while (setTokenPosition[1] > 2 || setTokenPosition[1] < 0) {
            System.out.print("You must enter a value between 0 and 2, try again");
            setTokenPosition[1] = in.nextInt();
        }
    }
    /**
     * Returns O or X
     * @param token
     * @return
     * */
    public static char enterToken(char token) {
        if (token == 'X') {
            System.out.print("Player O playing next..");
            token = 'O';
        }
        else if (token == 'O'){
            System.out.print("Player X playing next..");
            token = 'X';
        }
        else {
            while (token != 'O' && token !='X')
            {
                System.out.print("Please enter an O or an X ");
                token = in.next().charAt(0);
                token = Character.toUpperCase(token); // using Character class.
            }
        }
        return token;

    }
    /**
     *
     * Displays the avaible moves
     * */
    public static void displayBoard()
    {
        System.out.println("TicTacToe Board [X Y]");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("[%d %d]", i, j);
            }
            System.out.println();
        }
    }
}
