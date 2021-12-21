package com.advent.day3part1.parser;

import java.io.InputStream;

public class DataParser {


    public InputStream parseDataFile(String file) {

        InputStream diagnosticsInputStream = getClass().getClassLoader().getResourceAsStream(file);


        return diagnosticsInputStream;
    }

}
