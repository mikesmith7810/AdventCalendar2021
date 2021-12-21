package com.advent.day2part1.parser;

import java.io.InputStream;

public class MovementDataParser {


    public InputStream parseMovements(String file) {

        InputStream movementInputStream = getClass().getClassLoader().getResourceAsStream(file);


        return movementInputStream;
    }

}
