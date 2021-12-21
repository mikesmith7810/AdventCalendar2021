package com.advent.day21part1;

import com.advent.day21part1.board.Board;
import com.advent.day21part1.dice.Dice;
import com.advent.day21part1.player.Player;

import java.util.HashMap;

public class DiceGame {
    public static void main(String[] args) {

        int numberOfRolls = 3;

        Player player1 = new Player();
        player1.setPosition(8);
        player1.setScore(0);

        Player player2 = new Player();
        player2.setPosition(6);
        player2.setScore(0);

        HashMap<Integer, Player> players = new HashMap<>();
        players.put(1,player1);
        players.put(2,player2);

        Board board = new Board();

        board.setPlayers(players);

        Dice dice = new Dice();

        int currentPlayer = 1;
        int numberOfSpacesToMove = 0;
        int numberOfDiceRolls = 0;
        while ((board.getScoreForPlayer(1)<1000) && (board.getScoreForPlayer(2)<1000)) {
            for (int i = 0; i < numberOfRolls; i++) {
                numberOfSpacesToMove += dice.roll();
                numberOfDiceRolls += 1;

                if (i == numberOfRolls - 1) {
                    board.setNewPositionAndUpdateScoreForPlayerBasedOnDiceRoll(currentPlayer, numberOfSpacesToMove);
                    System.out.println("Player " + currentPlayer + " Score : " + board.getScoreForPlayer(currentPlayer));
                    currentPlayer = currentPlayer == 1 ? 2 : 1;
                    numberOfSpacesToMove = 0;
                }
            }

        }
        System.out.println("----");
        System.out.println("Dice Rolls : " + numberOfDiceRolls);
        System.out.println("Player 1 Score : " + board.getScoreForPlayer(1));
        System.out.println("Player 2 Score : " + board.getScoreForPlayer(2));

        int lowestScore = (board.getScoreForPlayer(1) > board.getScoreForPlayer(2) ? board.getScoreForPlayer(2): board.getScoreForPlayer(1));
        System.out.println("Lowest Score  : " + lowestScore);

        System.out.println("Puzzle Output : " + lowestScore * numberOfDiceRolls );


    }
}
