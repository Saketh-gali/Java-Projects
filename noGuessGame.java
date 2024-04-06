import java.util.Random;
import java.util.Scanner;

public class noGuessGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String play ="yes";
        while(play.equals("yes")){
            Random rm = new Random();
            int random= sc.nextInt();
            int guess =-1;
            int tries=0;
            while (guess != random){
                System.out.println("Guess number between 1to 100");
                guess =sc.nextInt();
                tries++;
                if(guess == random){
                    System.out.println("You Guessed the numder");
                    System.out.println("it take "+tries+ "to guess");
                    System.out.println("Do you want to paly again: type yes? or no?");
                    play=sc.next().toLowerCase();
                }else if(guess > random){
                    System.out.println("Guess is high : try again");
                }else {
                    System.out.println("Guess is low : try again");
                }
            }

        }
        sc.close();
    }
}
