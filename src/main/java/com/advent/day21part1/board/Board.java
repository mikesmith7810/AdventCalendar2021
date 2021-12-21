package com.advent.day21part1.board;

import com.advent.day21part1.player.Player;

import java.util.HashMap;

public class Board {


    int numberOfSpaces = 10;

    private HashMap<Integer, Player> players;

    public void setPositionForPlayer(int playerNumber, int position){
        Player player = getPlayers().get(playerNumber);
        player.setPosition(position);

        getPlayers().put(playerNumber, player);
    };

    public int setNewPositionAndUpdateScoreForPlayerBasedOnDiceRoll(int player, int diceRoll){
        int currentPosition = getPositionForPlayer(player);

        int newPosition  = calculateNewPosition(currentPosition, diceRoll);

        setPositionForPlayer(player,newPosition);
        updateScoreForPlayer(player,newPosition);
        return newPosition;
    }

    private void updateScoreForPlayer(int playerNumber, int newPosition) {
        Player player = getPlayers().get(playerNumber);
        int currentScore = player.getScore();
        player.setScore(currentScore + newPosition);

        getPlayers().put(playerNumber, player);
    }

    private int calculateNewPosition(int currentPosition,int diceRoll) {

        for (int i=0;i<diceRoll;i++){
            if (currentPosition==getNumberOfSpaces())
                currentPosition = 1;
            else
                currentPosition ++;
        }

        return currentPosition;
    }

    ;

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    public int getPositionForPlayer(int playerNumber) {
        Integer playersPosition = getPlayers().get(playerNumber).getPosition();

        return playersPosition;
    }

    private HashMap<Integer, Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(HashMap<Integer, Player> players) {
        this.players = players;
    }

    public int getScoreForPlayer(int playerNumber) {
        return getPlayers().get(playerNumber).getScore();
    }
}
