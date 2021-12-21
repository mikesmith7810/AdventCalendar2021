package com.advent.day1part2.parser;

import com.advent.day1part2.reader.DepthReader;

import java.io.InputStream;

public class DepthParser {


    private DepthReader depthReader = new DepthReader();

    public int parseDepths(String file) {

        InputStream depthInputStream = getClass().getClassLoader().getResourceAsStream(file);

        int depthIncrease = depthReader.analyseDepths(depthInputStream);

        return depthIncrease;
    }

    public DepthReader getDepthReader() {
        return depthReader;
    }

    public void setDepthReader(DepthReader depthReader) {
        this.depthReader = depthReader;
    }
}
