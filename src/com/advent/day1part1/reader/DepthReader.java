package com.advent.day1part1.reader;

import java.io.InputStream;
import java.util.Scanner;

public class DepthReader {
    public int analyseDepths(InputStream depthInputStream) {

        Scanner depthScanner = new Scanner(depthInputStream);

        boolean firstpass = true;
        int depthIncreases = 0;
        int previousDepth = 0;
        int newDepth = 0;

        while(depthScanner.hasNext()) {
            if (firstpass) {
                previousDepth = depthScanner.nextInt();
                firstpass = false;
            }
            else {

                newDepth = depthScanner.nextInt();

                if (newDepth > previousDepth)
                    depthIncreases++;

                previousDepth = newDepth;
            }
        }

        return depthIncreases;
    }
}
