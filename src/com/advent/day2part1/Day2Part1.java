package com.advent.day2part1;

import com.advent.day2part1.parser.MovementDataParser;
import com.advent.day2part1.reader.MovementReader;

import java.io.InputStream;

public class Day2Part1 {

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
