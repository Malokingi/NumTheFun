package com.matthewsgrand;

public final class _NumTheFun extends mwgMethods {
    private _NumTheFun() {
    }

    //final static TempFakeDatabase fakeDB = new TempFakeDatabase();

    public static void main(final String[] args) {
        boolean loop = true;
        String userInput;
        clearConsole();
        //System.out.print(fakeDB.getIntroDialogue("Main"));
        readFile("dia/intro.txt");
        while (loop) {
            readFile("dia/topMenu.txt");
            System.out.print("\nWell, put in some input: ");
            userInput = scan.nextLine();

            switch (userInput) {
                case "00":
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
                    theMenu(userInput);
                    break;
                default:
                    System.err.println("Sorry, " + userInput + " isn't a valid Menu option.");
                    break;
            }
        }
    }

    /**
     * Theorem_Menu(String Theorem) - Prints out some more dialogue and, depending
     * on the theorem selected in main(), either prints the educational dialogue or
     * lets the user test some values and see what they evaluate to.
     * 
     * @param the
     */
    private static void theMenu(final String the) {
        String userInput;
        boolean loop = true;
        clearConsole();
        readFile("dia/the" + the + ".txt");
        while (loop) {
            readFile("dia/theMenu.txt");
            System.out.print("\nWhat do you want to do? ");
            userInput = scan.nextLine();
            switch (userInput) {
                case "1":
                    clearConsole();
                    readFile("dia/the" + the + ".txt");
                    break;
                case "2":
                    //clearConsole();
                    switch (the) {
                        case "11": Chapter1.learn11(); break;
                        case "12": Chapter1.learn12(); break;
                        case "13": Chapter1.learn13(); break;
                        case "21": Chapter2.learn21(); break;
                        case "22": Chapter2.learn22(); break;
                        case "23": Chapter2.learn23(); break;
                        case "24": Chapter2.learn24(); break;
                        case "25": Chapter2.learn25(); break;
                        default:
                            System.err.println("Sorry, " + the + " is either yet to be implimented or invalid.");
                            break;
                    }
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
    }
}
