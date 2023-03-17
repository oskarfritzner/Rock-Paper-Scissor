package Osfr002.MineProsjekter.RockPaperScissor;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    String userMove;
    int playerScore;
    int computerScore;

    boolean vinner = false;

    String moves[] = new String[] {"rock", "paper", "scissor"};

    private String getUserMove(Scanner scanner) {
        if(scanner.hasNext()) {
            return userMove = scanner.next().toLowerCase();
        } else {
            System.out.println("Wrong input \n Please write 'Rock', 'Paper' or 'Scissor'");
            return getUserMove(scanner);
        }
    }

    private String getComputorMove() {
        Random random = new Random();

        int randomMove = random.nextInt(3);

        switch (randomMove) {
            case 0:
                System.out.println(moves[0]);
                return moves[0];
            case 1:
                System.out.println(moves[1]);
                return moves[1];
            case 2:
                System.out.println(moves[2]);
                return moves[2];
            default:
                System.out.println("Wrong input");
                return getComputorMove();
        }
    }

    private int checkMoves(String userMove, String computerMove) {

        switch(userMove) {
            case "rock":
                switch (computerMove) {
                    case "scissor" -> {
                        return playerScore += 1;
                    }
                    case "rock" -> {
                        return playerScore;
                    }
                    case "paper" -> {
                        return computerScore += 1;
                    }
                }
                break;
            case "scissor":
                switch (computerMove) {
                    case "scissor" -> {
                        return playerScore;
                    }
                    case "rock" -> {
                        return computerScore += 1;
                    }
                    case "paper" -> {
                        return computerScore -= 1;
                    }
                }
                break;
            case "paper":
                switch (computerMove) {
                    case "scissor" -> {
                        return computerScore += 1;
                    }
                    case "rock" -> {
                        return playerScore += 1;
                    }
                    case "paper" -> {
                        return playerScore;
                    }
                }
        }
        return 0;
    }

    private void play() {
        System.out.println("Write Rock, Paper or Scissor to play");
        Scanner scanner = new Scanner(System.in);
        checkMoves(getUserMove(scanner), getComputorMove());
        System.out.printf("User Score: %s - Computer Score: %s\n", playerScore, computerScore);

        while(!vinner) {
            if(playerScore == 3) {
                System.out.println("\nDu vant!!");
                vinner = true;
                playerScore = 0;
                computerScore = 0;
                System.exit(0);
            } else if(computerScore == 3) {
                System.out.println("\nComputeren vant");
                vinner = true;
                playerScore = 0;
                computerScore = 0;
                System.exit(0);
            }
            play();
        }

    }

    public static void main(String[] args) {
        RockPaperScissor game = new RockPaperScissor();
        Scanner scanner = new Scanner(System.in);

        game.play();

    }
}
