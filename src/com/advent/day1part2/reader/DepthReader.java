package com.advent.day1part2.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DepthReader {
    public int analyseDepths(InputStream depthInputStream) {

        ArrayList<Integer> depths = readDepths(depthInputStream);

        int measurementRange = 3;
        boolean firstpass = true;
        int depthIncreases = 0;
        int previousDepth = 0;

        int blockDepth = 0;
        int newSingleDepth = 0;

        for (int i = 0; i < depths.size(); i++) {

            blockDepth = 0;

            for (int j = 0; j < measurementRange; j++) {

                if (i + j == depths.size()) {
                    break;
                }
                newSingleDepth = depths.get(i + j);
                blockDepth = blockDepth + newSingleDepth;
            }

            if (firstpass) {
                firstpass = false;
            }
            else {
                if (blockDepth > previousDepth)
                    depthIncreases++;
            }

            previousDepth = blockDepth;
            System.out.println(blockDepth);
        }

        return depthIncreases;
    }

    private ArrayList<Integer> readDepths(InputStream depthInputStream) {
        ArrayList<Integer> depths = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(depthInputStream));

        String depth;

        try {
            while ((depth = reader.readLine()) != null) {
                depths.add(new Integer(depth));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return depths;
    }
}
