package com.rpg.io;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleDisplay implements InputOutputDisplay{
    @Override
    public InputStream getInputStream() {
        return System.in;
    }

    @Override
    public PrintStream getOutputStream() {
        return System.out;
    }

}
