package com.advent.day3part2.reader;

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
    private static final int OXYGEN = 1;
    private static final int CO2 = 0;

    public int getLifeSupportRating(InputStream diagnostics) {


        ArrayList<ArrayList<Integer>> diagnosticsReadings = readDiagnosticsData(diagnostics);

        for (int i=0;i<diagnosticsReadings.size();i++) {
            ArrayList<ArrayList<Integer>> oxygenReading = findDiagnosticOutputFrom(diagnosticsReadings, OXYGEN);
        }
        //int oxygenDecimal = Integer.parseInt(oxygenReading, 2);

        //ArrayList<String> co2Reading = findDiagnosticOutputFrom(diagnosticsReadings, CO2);
        //int co2Decimal = Integer.parseInt(co2Reading, 2);

        //int lifeSupportRating = findFinalPosition(oxygenDecimal, co2Decimal);

        return 1;
    }


    private ArrayList<ArrayList<Integer>> findDiagnosticOutputFrom(ArrayList<ArrayList<Integer>> diagnosticsReadings, int dataType) {


        String bitPositiveValue;
        String bitNegativeValue;
        ArrayList<ArrayList<Integer>> positiveValues = new ArrayList<>();
        ArrayList<ArrayList<Integer>> negativeValues = new ArrayList<>();
        int bitPositive = 0;
        int bitNegative = 0;

        String totalBinaryOutput = "";
        for (int i = 0; i < 1; i++) {
            bitPositive = 0;
            bitNegative = 0;

            positiveValues.add(new ArrayList<Integer>());
            negativeValues.add(new ArrayList<Integer>());

            for (int j = 0; j < diagnosticsReadings.get(0).size(); j++) {
                Integer dataPoint = diagnosticsReadings.get(i).get(j);
                bitPositiveValue = "";
                bitNegativeValue = "";
                if (dataPoint.intValue() == dataType) {
                    bitPositive = bitPositive + 1;
                    for (int k = 0; k < diagnosticsReadings.size(); k++) {
                        //bitPositiveValue = bitPositiveValue + diagnosticsReadings.get(k).get(j);
                        positiveValues.get(k).add(diagnosticsReadings.get(k).get(j));
                    }
                    //positiveValues.add(bitPositiveValue);
                } else {
                    bitNegative = bitNegative + 1;
                    for (int k = 0; k < diagnosticsReadings.size(); k++) {
                        //bitNegativeValue = bitNegativeValue + diagnosticsReadings.get(k).get(j);
                        negativeValues.get(k).add(diagnosticsReadings.get(k).get(j));
                    }
                    //negativeValues.add(bitNegativeValue);
                }
            }


        }
        if (bitPositive > bitNegative)
            return positiveValues;
        else if (bitPositive < bitNegative)
            return negativeValues;
        else
            return positiveValues;
    }

    private int findFinalPosition(int gammaReading, int epsilonReading) {
        return gammaReading * epsilonReading;
    }


    private ArrayList<ArrayList<Integer>> readDiagnosticsData(InputStream diagnosticsInputStream) {
        ArrayList<ArrayList<Integer>> diagnosticReadings = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i < 5; i++) {
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
