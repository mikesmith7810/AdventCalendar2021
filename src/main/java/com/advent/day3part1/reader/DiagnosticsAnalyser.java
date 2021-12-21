package com.advent.day3part1.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagnosticsAnalyser {

    public static final int GAMMA = 1;
    public static final int EPSILON = 0;

    public int getPowerConsumption(InputStream diagnostics) {


        ArrayList<ArrayList<Integer>> diagnosticsReadings = readDiagnosticsData(diagnostics);

        String gammaReading = findDiagnosticOutputFrom(diagnosticsReadings, GAMMA);
        int gammaDecimal = Integer.parseInt(gammaReading,2);

        String epsilonReading = findDiagnosticOutputFrom(diagnosticsReadings, EPSILON);
        int epsilonDecimal = Integer.parseInt(epsilonReading,2);

        int finalPosition = findFinalPosition(gammaDecimal, epsilonDecimal);

        return finalPosition;
    }

    private String findDiagnosticOutputFrom(ArrayList<ArrayList<Integer>> diagnosticsReadings, int dataType) {


        String totalBinaryOutput = "";
        for (int i = 0; i < diagnosticsReadings.size(); i++) {
            int bitPositive = 0;
            int bitNegative = 0;

            for (int j = 0; j < diagnosticsReadings.get(0).size(); j++) {
                Integer dataPoint = diagnosticsReadings.get(i).get(j);
                if (dataPoint.intValue() == dataType)
                    bitPositive = bitPositive + 1;
                else
                    bitNegative = bitNegative + 1;

            }
            if (bitPositive > bitNegative)
                totalBinaryOutput = totalBinaryOutput + "1";
            else
                totalBinaryOutput = totalBinaryOutput + "0";

        }
        System.out.println("Binary output" + totalBinaryOutput);
        return totalBinaryOutput;
    }

    private int findFinalPosition(int gammaReading, int epsilonReading) {
        return gammaReading*epsilonReading;
    }


    private ArrayList<ArrayList<Integer>> readDiagnosticsData(InputStream diagnosticsInputStream) {
        ArrayList<ArrayList<Integer>> diagnosticReadings = new ArrayList<ArrayList<Integer>>(12);
        for (int i = 0; i < 12; i++) {
            diagnosticReadings.add(new ArrayList<Integer>());
        }

        String currentReading;

        ArrayList<Integer> dataTracker = intialiseDataTracker();
        String diagnosticReport = "";
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(diagnosticsInputStream));
            while ((currentReading = reader.readLine()) != null) {

                for (int i = 0; i < currentReading.length(); i++) {
                    String dataPoint = currentReading.substring(i, i + 1);
                    diagnosticReadings.get(i).add(new Integer(dataPoint));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return diagnosticReadings;
    }

    private ArrayList<Integer> intialiseDataTracker() {
        List<Integer> dataTracker = Arrays.asList(0, 0, 0, 0, 0);
        return new ArrayList<>(dataTracker);
    }
}
