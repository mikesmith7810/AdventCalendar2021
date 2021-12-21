package com.advent.day3part2;

import com.advent.day3part2.reader.DiagnosticsAnalyser;
import com.advent.day3part2.parser.DataParser;

import java.io.InputStream;

public class Day3Part2 {

    private static DataParser movementDataParser;

    private DiagnosticsAnalyser movementReader;

    public static void main(String[] args) {

        DataParser dataParser = new DataParser();
        InputStream diagnosticsInputStream = dataParser.parseDataFile("diagnosticstest.txt");

        DiagnosticsAnalyser diagnosticsAnalyser = new DiagnosticsAnalyser();
        int lifeSupportRating = diagnosticsAnalyser.getLifeSupportRating(diagnosticsInputStream);

        System.out.println("Power Consumption : " + lifeSupportRating);
    }

   }
