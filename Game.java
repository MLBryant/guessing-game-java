/*

A number-guessing game.

*/

import java.util.Random;
import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int number = rand.nextInt(100);
    int guesses = 0;
    int guess = -1;

    System.out.println("Hello, try your lock at guessing my number");

    System.out.println("What is your name?");
    String name = input.nextLine();

    System.out.println("I'm thinking of a number between 1 and 100.");
    System.out.println("Try to guess my number.");
    System.out.print("your guess? ");

    while (guess != number) {
      try {
        guess = input.nextInt();
      } catch (Exception e) {
        String bad_input = input.next();   // need to progress past bad input
        System.out.println("That's not an integer, try again");
        System.out.print("Your guess? ");
        continue;
      }
      if (guess < 1 || guess >100) {
        System.out.println("Nani?! I said a number between 1 and 100, try again!");
        System.out.print("Your guess? ");
      } else {
        guesses += 1;
        if (guess < number) {
          System.out.println("Your guess is too low, try again.");
          System.out.print("your guess? ");
        } else if (guess > number) {
          System.out.println("Your guess is too high, try again.");
          System.out.print("Your guess? ");
        } else {
          String done = String.format("Well, done, %s! You found my number in %s tries!", name, guesses);
          System.out.println(done);
          break;
        }
      }
    }
  }

}
