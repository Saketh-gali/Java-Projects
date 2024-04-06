import java.util.Random;
import java.util.Scanner;

public class RockPaperGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello Please Enter your Name:");
        String name = sc.next();
        System.out.println(" Welcome to Rock Paper Scissor Game: "+ name);
        System.out.println("Note: 0 indicate Rock , 1 Indicate Paper, 2 Indicate Scissor");
        System.out.println("Enter your Choice");
        int user = sc.nextInt();
        Random ran = new Random();
        int computer = ran.nextInt(3);

        if(user>=0&& user<3) {

            if (computer == user) {
                System.out.println("game is TIE");

            } else if (computer == 0 && user == 1 || computer == 1 && user == 2 || computer == 2 && user == 0) {
                System.out.println("Congrates " + name + " Your Won");

            } else if (computer == 1 && user == 0 || computer == 2 && user == 1 || computer == 0 && user == 2) {
                System.out.println("Computer Won");

            } }
        else {
                System.out.println("enter the Valid number");

            }
        if(computer==0){
            System.out.println("Computer is Rock");
        }else if(computer==1){
            System.out.println("Computer Choice is Paper");
        }else{
            System.out.println("Computer choice is Scissor");
        }
    }
}
