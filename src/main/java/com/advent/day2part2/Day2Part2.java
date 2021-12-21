package com.advent.day2part2;

import com.advent.day2part2.reader.MovementReader;
import com.advent.day2part2.parser.MovementDataParser;

import java.io.InputStream;

public class Day2Part2 {

    private static MovementDataParser movementDataParser;

    private MovementReader movementReader;

    public static void main(String[] args) {

        MovementDataParser movementDataParser = new MovementDataParser();
        InputStream movementInputStream = movementDataParser.parseMovements("movements.txt");

        MovementReader movementReader = new MovementReader();
        int finalPosition = movementReader.analyseMovements(movementInputStream);

        System.out.println("Final Postion : " + finalPosition);
    }

   }
