package com.advent.day21part1.dice;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import com.advent.day21part1.board.BoardStandard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class DiceTest {

    Dice dice ;

    @BeforeEach
    public void setup(){
        dice = new DiceDert();

    }

    @Test
    public void shouldIncreaseDiceResultBasedUponDiceRange(){


        int result = dice.roll();

        assertThat(result, is(1));
    }

    @Test
    public void shouldRollBackToStartRangeOnceRangeReached(){

        int result = 0;

        for (int i=0;i<150;i++){
            result = dice.roll();
        }

        assertThat(result, is(50));
    }
}
