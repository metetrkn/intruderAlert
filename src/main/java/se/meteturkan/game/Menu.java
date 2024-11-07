package se.meteturkan.game;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;


public class Menu {
    // Printing out message from top to bottom line by line func
    public void arrayPrint(String[] message) {
        // Printing out line by line with sleep
        for (String line : message) {
            System.out.println(line); // Print each line
            try {
                Thread.sleep(140); // Sleep for 140 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle exception
            }
        }
    }


    // Printing out string message with 140-millisecond delay
    public void printStringWithDelay(String message, int duration) {
        for (char c : (message + "\n").toCharArray()) {
            System.out.print(c);
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(duration));
        }
    }


    // Welcoming user
    public void welcomingMessage () {
        String[] welcomeMessage =
                {       "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*",
                        "\n\n__        __       _                                _",
                        "\\ \\      / /  ___ | |  ___   ___   _ __ ___    ___ | |",
                        " \\ \\ /\\ / /  / _ \\| | / __| / _ \\ | '_ ` _ \\  / _ \\| |",
                        "  \\ V  V /  |  __/| || (__ | (_) || | | | | ||  __/|_|",
                        "   \\_/\\_/    \\___||_| \\___| \\___/ |_| |_| |_| \\___|(_)\n\n",
                        "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*",
                        "",
                        "                            ______ ",
                        "                        .-\"\"      \"\"-. ",
                        "                       /             \\",
                        "                      |               |",
                        "                      |,  .-.   .-.  ,|",
                        "                      | )(_🔥/  \\🔥_)( |",
                        "                      |/     /\\     \\|",
                        "                      (_     ^^     _)",
                        "                       \\__|\uD83E\uDDB7\uD83E\uDDB7\uD83E\uDDB7|__/",
                        "                        | \\IIIIII/ |",
                        "                        \\          /",
                        "                         `--------`",
                        "",
                        "Welcome to Intruder Alert 1.0.1",
                        "",
                        "You’re about to step into a tense night where every choice",
                        "could make or break the ultimate showdown."};

        arrayPrint(welcomeMessage); // Printing welcoming message top to bottom line by line
    }


    // Farewell  user
    public void farewell() {
        String[] farewellMessage = {
                "  ____                    _  _                   _ ",
                " / ___|  ___    ___    __| || |__   _   _   ___ | |",
                "| |  _  / _ \\  / _ \\  / _` || '_ \\ | | | | / _ \\| |",
                "| |_| || (_) || (_) || (_| || |_) || |_| ||  __/|_|",
                " \\____| \\___/  \\___/  \\__,_||_.__/  \\__, | \\___|(_)",
                "                                    |___/          "};

        arrayPrint(farewellMessage); // Printing farewell message top to bottom line by line
    }


    // System closing messages
    public void exitSystem() {
        printStringWithDelay("\nExiting...", 140);
        farewell();
    }


    // Menu before user logged in
    public void loginMenu() {
        System.out.println("\nPlease select an option from the menu below:\n\n" +
                "1. Login to game\n" +
                "2. Exit\n");
    }
}

