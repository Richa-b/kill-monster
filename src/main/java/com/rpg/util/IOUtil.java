package com.rpg.util;

import com.rpg.io.ConsoleDisplay;
import com.rpg.io.InputOutputDisplay;

import java.util.Scanner;

public class IOUtil {

    private static InputOutputDisplay consoleDisplay = new ConsoleDisplay();

    public static void showMessage(String message) {
        consoleDisplay.getOutputStream().println(message);
    }

    public static String getStringInput() {
        return getScanner().nextLine();
    }

    public static int getIntegerInput() {
        return getScanner().nextInt();
    }

    private static Scanner getScanner() {
        return new Scanner(consoleDisplay.getInputStream());
    }


}
