package com.dsdev;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static final int TIE = 1;
  public static final int PLAYER_WINS = 2;
  public static final int COMPUTER_WINS = 3;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<String> rpsList = Arrays.asList("rock", "paper", "scissors");
    Random rand = new Random();

    do {
      displayPrompt();
      String playerChoice = in.next();
      if (playerChoice.equals("exit")) return;
      if (!rpsList.contains(playerChoice)) {
        System.out.printf("%s is not a valid choice.%n", playerChoice);
        displayPrompt();
        continue;
      }
      String computerChoice = getRandomChoice(rpsList, rand);
      displayChoices(computerChoice, playerChoice);
      int winner = evaluateChoices(computerChoice, playerChoice);
      displayWinner(winner);
    } while (in.hasNext());
  }

  public static void displayWinner(int winner) {
    switch (winner) {
      case TIE:
        System.out.println("It's a tie!");
        break;
      case COMPUTER_WINS:
        System.out.println("Computer wins!");
        break;
      case PLAYER_WINS:
        System.out.println("Player wins!");
        break;
    }
  }

  public static int evaluateChoices(String computerChoice, String playerChoice) {
    if (computerChoice.equals(playerChoice)) return TIE;
    if (computerChoice.equals("rock") && playerChoice.equals("scissors")) return COMPUTER_WINS;
    if (computerChoice.equals("paper") && playerChoice.equals("rock")) return COMPUTER_WINS;
    if (computerChoice.equals("scissors") && playerChoice.equals("paper")) return COMPUTER_WINS;
    return PLAYER_WINS;
  }

  public static void displayChoices(String computerChoice, String playerChoice) {
    System.out.printf(
      "Player Choice: %s%nComputer Choice: %s%n", playerChoice, computerChoice
    );
  }

  public static void displayPrompt() {
    System.out.println("Enter rock, paper, or scissors to play, or 'exit' to quit.");
  }

  public static String getRandomChoice(List<String> list, Random rand) {
    return list.get(rand.nextInt(list.size()));
  }
}
