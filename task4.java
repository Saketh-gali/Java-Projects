import java.util.Objects;
import java.util.Scanner;
import java.util.*;

class task4 {
    String[][] board;
    Boolean winner;
    Boolean draw;
    int winningPlayer;
    int playerTurn;

    public task4() {
        winningPlayer = 0;
        draw = false;
        playerTurn = 1;
        board = new String[6][7];
        newBoard();
        dispalyBoard();

    }

    private void newBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = " - ";
            }
        }
    }

    public void dispalyBoard() {
        System.out.println(" ");
        System.out.println("   ***   CONNECT 4    ***   ");
        System.out.println("  ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    private boolean validInput(String input) {
        return ((Objects.equals(input, "1") ||
                Objects.equals(input, "2") ||
                Objects.equals(input, "3") ||
                Objects.equals(input, "4") ||
                Objects.equals(input, "5") ||
                Objects.equals(input, "6") ||
                Objects.equals(input, "7")));
    }

    private boolean isColumnFull(int column) {
        return (board[0][column - 1] == "X" || board[0][column - 1] == "O");
    }

    private int getNextAvailable(int column) {
        int position = 5;
        boolean found = false;
        while (position >= 0 && !found) {
            if (!Objects.equals(board[position][column], "X") && !Objects.equals(board[position][column], "O")) {
                found = true;
            } else {
                position--;
            }
        }
        return position;

    }

    private void swapPlayerTurn() {
        if (playerTurn == 1) {
            playerTurn = 2;
        } else {
            playerTurn = 1;
        }
    }

    private void placePiece(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Player" + playerTurn + " - Plece select which column to place your piece(1-7)");
        String input = sc.nextLine();

        while (!validInput(input) || isColumnFull(Integer.parseInt(input))) {
            System.out.println("Invaid input - place select column from 1-7");
            input = sc.nextLine();
        }
        while (isColumnFull(Integer.parseInt(input))) {
            System.out.println("Column is full choose another column");
            input = sc.nextLine();
            if (!validInput(input)) {
                break;
            }
        }





     int columnchoice = Integer.parseInt(input) - 1;

    System.out.println("Next avaliable row in column" + getNextAvailable(columnchoice));
    String pieceToPlace;
    if(playerTurn ==1){
        pieceToPlace ="X";
    }else{
        pieceToPlace ="O";
    }
    board[getNextAvailable(columnchoice)][columnchoice] = pieceToPlace;
    dispalyBoard();
    swapPlayerTurn();
}
private boolean idBoardFull(){
    boolean full = true;
    for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 7; j++) {
            if(board[i][j]!= "X"&& board[i][j]!="O"){
                full = false;

            }
        }
    }
    return full;
}
private String checkVerticalWinnier(){
    String symbol = null;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 7; j++) {
          if((board[i][j] == board[i+1][j])&& (board[i][j] == board[i+2][j])&&(board[i][j] == board[i][j]))  {
          if(board[i][j] =="X" || board[i][j]=="O"){
              symbol =board[i][j];
          }
          }
        }

        }
    return symbol;
}
private String checkHorizontalWinner(){
        String symbol = null;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 4; j++) {
            if((board[i][j] == board[i][j+1])&& (board[i][j] == board[i][j+2])&&(board[i][j] == board[i][j]))  {
                if(board[i][j] =="X" || board[i][j]=="O"){
                    symbol =board[i][j];
                }
            }
        }

    }
    return symbol;
}

private String checkLeftDiagonalWinner(){
    String symbol = null;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            if((board[i][j] == board[i+1][j+1])&& (board[i][j] == board[i+2][j+2])&&(board[i][j] == board[i][j]))  {
                if(board[i][j] =="X" || board[i][j]=="O"){
                    symbol =board[i][j];
                }
            }
        }

    }
    return symbol;
}
    private String checkRightDiagonalWinner(){
        String symbol = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if((board[i][j] == board[i][j])&& (board[i][j] == board[i][j])&&(board[i][j] == board[i][j]))  {
                    if(board[i][j] =="X" || board[i][j]=="O"){
                        symbol =board[i][j];
                    }
                }
            }

        }
        return symbol;
    }

    private  int checkForWinner() {
        int winner = 0;
        String symbol = " ";
        if (checkVerticalWinnier() == "X" || checkVerticalWinnier() == "O") {
            symbol = checkVerticalWinnier();
        } else if (checkHorizontalWinner() == "X" || checkHorizontalWinner() == "O") {
            symbol = checkHorizontalWinner();
        } else if (checkLeftDiagonalWinner() == "X" || checkLeftDiagonalWinner() == "O") {
            symbol = checkLeftDiagonalWinner();
        } else if (checkRightDiagonalWinner() == "X" || checkRightDiagonalWinner() == "O") {
            symbol = checkRightDiagonalWinner();
        }

        if (symbol == "X") {
            winner = 1;
        } else if (symbol == "O") {
            winner = 2;
        }
        return winner;
    }
    private boolean checkForDraw(){
    return (idBoardFull() == true && (checkForWinner()!=1 && checkForWinner() != 2));
}
private void showWinnier(){
    System.out.println(" ");
    System.out.println(" ******************************* ");
    System.out.println("                                  ");
    System.out.println("         PLAYER"+ winningPlayer+ "WINS!!! ");
    System.out.println("    *                        *   ");
    System.out.println("       *       \\ O /       *        ");
    System.out.println(" *      *         |       *     *   ");
    System.out.println("       *        /   \\      *        ");
    System.out.println("    *                        *   ");
    System.out.println(" ******************************* ");
}
public void playGame(){
    while(winningPlayer ==0){
        winningPlayer =checkForWinner();
        draw= checkForDraw();

        if (winningPlayer ==1){
            showWinnier();;
            break;
        }else if(winningPlayer ==2){
            showWinnier();
            break;
        }else if (draw == true){
            System.out.println("it is Draw match");
            break;
        }
        placePiece();

        }
    }
    public static void main(String[] args){
        task4 c4 = new task4();
        c4.playGame();
    }
}



