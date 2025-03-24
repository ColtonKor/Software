//Histogram
//Asks the user to input a size for the next set of inputs.
//When the user inputs the next numbers it will find a max times a number was written
//It then makes a histogram with the number and how many times it was typed
//Colton Korhummel. September 8, 2023

import java.util.Scanner;


public class Histogram {
    public static void main(String[] args) {
        int[] numCounterArray = new int[10];
        int arrSize = numCounterArray.length;
        int currentNum;
        int max;

        Scanner kb = new Scanner(System.in);
        System.out.println("How many input values [max: 30]?");
        int numInputs = kb.nextInt();
        System.out.printf("Enter %d numbers.%n", numInputs);


        for(int i = 0; i < numInputs; i++){
            currentNum = kb.nextInt();
            numCounterArray[currentNum] += 1;
        }

        max = 0;
        for (int i = 0; i < arrSize; i++) {
            if (max < numCounterArray[i]) {
                max = numCounterArray[i];
            }
        }

        System.out.println("\n========= Vertical Bar =========");
        for(int i = max; i > 0; i--){
            System.out.printf("| %d | ", i);
            for(int j = 0; j < arrSize; j++) {
                if(i <= numCounterArray[j]){
                    System.out.print(" *");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("===============================");
        System.out.println("| No | 0 1 2 3 4 5 6 7 8 9");
        System.out.println("===============================");
    }
}
