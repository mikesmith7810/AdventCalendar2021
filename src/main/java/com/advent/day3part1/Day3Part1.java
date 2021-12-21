package com.advent.day3part1;

import com.advent.day3part1.reader.DiagnosticsAnalyser;
import com.advent.day3part1.parser.DataParser;

import java.io.InputStream;

public class Day3Part1 {

    private static DataParser movementDataParser;

    private DiagnosticsAnalyser movementReader;

    public static void main(String[] args) {

        DataParser dataParser = new DataParser();
        InputStream diagnosticsInputStream = dataParser.parseDataFile("diagnostics.txt");

        DiagnosticsAnalyser diagnosticsAnalyser = new DiagnosticsAnalyser();
        int powerConsumption = diagnosticsAnalyser.getPowerConsumption(diagnosticsInputStream);

        System.out.println("Power Consumption : " + powerConsumption);
    }

   }
