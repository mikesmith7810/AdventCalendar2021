package com.advent.day21part1.dice;

public class Dice {
    int sides = 0;

    int currentResult = 0;

    int range=100;

    public int roll() {
        if (currentResult==getRange())
            currentResult = 1;
        else
            currentResult ++;

        return currentResult;
    }

    public int getCurrentResult() {
        return this.currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
