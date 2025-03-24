//Square Root
//Asks the user to input a number. It then goes through a couple math formulas.
//It will then print out the square root of the original number
//Colton Korhummel. September 8, 2023

import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int square = 0;
        boolean done = false;
        System.out.println("This program estimates square roots.");
        System.out.println("Please enter a whole number:");
        while(!done){
            try{
                square = kb.nextInt();
                done = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter a whole number (no words, just numbers):");
                kb.next();
            }
        }
        done = false;
        int guess_number = 2;
        double guess = (double)square/2;
        System.out.printf("Initial guess: %f\n", guess);
//        This code produces the square root in a loop
        while(!done){
            if(guess - ((guess+(square/guess))/2) < .01){
                guess = (guess+(square/guess))/2;
                System.out.printf("Guess %d: %f\n", guess_number, guess);
                done = true;
                continue;
            }
            guess = (guess+(square/guess))/2;
            System.out.printf("Guess %d: %f\n", guess_number, guess);
            guess_number++;
        }
//        This Code makes square root in 5 guesses in total
//        guess = (guess+(square/guess))/2;
//        System.out.printf("Guess 2: %f\n", guess);
//        guess = (guess+(square/guess))/2;
//        System.out.printf("Guess 3: %f\n", guess);
//        guess = (guess+(square/guess))/2;
//        System.out.printf("Guess 4: %f\n", guess);
//        guess = (guess+(square/guess))/2;
//        System.out.printf("Guess 5: %f\n", guess);
//        guess = (guess+(square/guess))/2;
        System.out.printf("The estimated square root of %d is %.2f", square, guess);
    }
}
