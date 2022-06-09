package com.matthewsgrand;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.matthewsgrand.data.Entry;
import com.matthewsgrand.data.EntryRepository;

// import org.apache.log4j.Logger;

public final class _NumTheFun extends mwgMethods {
    static EntryRepository er = new EntryRepository();
    // private static final Logger log = Logger.getLogger(_NumTheFun.class);
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(final String[] args) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        clearConsole();
        boolean loop = true;
        String userInput;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> shutdown()));
        readFile("dia/intro.txt");
        while (loop) {
            // log.info("Deploying Main_Menu");
            readFile("dia/topMenu.txt");
            System.out.print("\nWell, put in some input: ");
            userInput = scan.nextLine();
            // log.info("User put in " + userInput);
            switch (userInput) {
                case "0":
                case "00":
                    // log.fatal("shutting down correctly");
                    System.out.println("You want to Quit? But you just got here... Goodbye.\n");
                    loop = false;
                    scan.close();
                    break;
                case "11":
                case "12":
                case "13": // If any of these are the case, call theMenu()
                case "21":
                case "22":
                case "23":
                case "24":
                case "25":
                    clearConsole();
                    theMenu(userInput);
                    break;
                case "99":
                    browseGlossary();
                    break;
                default:
                    clearConsole();
                    System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }

    private static Object shutdown() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        // log.fatal("shutting down suddenly");
        System.err.println("\n\tAsynchronous Shutdown Command detected!!\n");
        System.err.println("\n\tWoah! Woah! Woah! Let me shut down the scanner first at least! Jeez!\n");
        // scan.close(); // Does Java do this on its own when ^C is pressed?
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("Failed to pause for 1 second.");
            e.printStackTrace();
        }
        threadPool.shutdown();
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        return null;
    }

    private static void browseGlossary() {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "()");
        List<Entry> glossary = er.getAll();
        int userInput;
        int glossarySize = glossary.size();
        boolean loop = true;
        while (loop) {
            clearConsole();
            // log.info("Displaying Glossary");
            System.out.println("These are the words I know:\n");
            if (glossarySize == 0) {
                System.out.println("\n\tI don't know anything :'-(");
            } else {
                for (int i = 1; i <= glossarySize; i++) {
                    Entry e = glossary.get(i - 1);
                    System.out.printf("\t(%d) %s\n", i, e.word);
                }
                System.out.print("\nWhich do you want to look up -Enter (0) to go back-: ");
                userInput = readInt();
                if (userInput == 0) {
                    loop = false;
                } else if (userInput > 0 && userInput <= glossarySize) {
                    Entry e = glossary.get(userInput - 1);
                    System.out.printf("\n%s - %s\n\t(Entered by %s on %s)\n\n", e.word, e.def, e.added_by,
                            e.date_added);
                    System.out.print("Want to look up another? (1) means \"Yes\": ");
                    if (readInt() != 1) {
                        loop = false;
                    }
                } else {
                    System.out.printf("What? %d? I don't understand.\n", userInput);
                }
            }
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }

    /**
     * Theorem_Menu(String Theorem) - Prints out some more dialogue and, depending
     * on the theorem selected in main(), either prints the educational dialogue or
     * lets the user test some values and see what they evaluate to.
     * 
     * @param the
     */
    private static void theMenu(final String the) {
        // log.info("In " + new Throwable().getStackTrace()[0].getMethodName() + "(the = " + the + ")");
        String userInput;
        boolean loop = true;
        readFile("dia/the" + the + ".txt");
        while (loop) {
            readFile("dia/theMenu.txt");
            System.out.print("\nWhat do you want to do? ");
            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    clearConsole();
                    // log.info("Displaying Theorem Dialogue");
                    readFile("dia/the" + the + ".txt");
                    break;
                case "2":
                    switch (the) {
                        case "11": Chapter1.learn1(); break;
                        case "12": Chapter1.learn2(); break;
                        case "13": Chapter1.learn3(); break;
                        case "21": Chapter2.learn1(); break;
                        case "22": Chapter2.learn2(); break;
                        case "23": Chapter2.learn3(); break;
                        case "24": Chapter2.learn4(); break;
                        case "25": Chapter2.learn5(); break;
                        default:
                            System.err.println("Sorry, " + the + " is either yet to be implimented or invalid.");
                            break;
                    }
                    break;
                case "3":
                    browseGlossary();
                    break;
                case "0":
                    clearConsole();
                    loop = false;
                    break;
                default:
                    System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
        // log.info("Out " + new Throwable().getStackTrace()[0].getMethodName() + "()");
    }
}