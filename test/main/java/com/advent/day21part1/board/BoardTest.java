package com.advent.day21part1.board;


import com.advent.day21part1.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    Board board;

    @BeforeEach
    public void setup(){
        board = new BoardStandard();

        Player player1 = new Player();
        player1.setPosition(7);

        HashMap<Integer,Player> playersPositions = new HashMap<>();
        playersPositions.put(1,player1);


        board.setPlayers(playersPositions);

    }

    @Test
    public void shouldSetAPlayersNewPositionCorrectly(){

        int position = board.setNewPositionAndUpdateScoreForPlayerBasedOnDiceRoll(1,5);

        int playersNewPosition  = board.getPositionForPlayer(1);

        assertThat(playersNewPosition, is(2));
    }

    @Test
    public void shouldSetAPlayersNewScoreCorrectly(){

        int position = board.setNewPositionAndUpdateScoreForPlayerBasedOnDiceRoll(1,8);

        int playersNewScore  = board.getScoreForPlayer(1);

        assertThat(playersNewScore, is(5));
    }



}
