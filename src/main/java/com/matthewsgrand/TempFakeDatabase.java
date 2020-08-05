package com.matthewsgrand;

public final class TempFakeDatabase {
    public TempFakeDatabase() {
        initAllDialogues();
    }

    private void initAllDialogues() {
        
    }

    private final String[] intros = {
        "Hello. You've reached Matthew's Grand Number Theory FUNdamentals Program!!\n\nWe're going to have some fun.\n",
        "Theorem 1-1 = Sum of the first N Integers.\n",
        "Theorem 1-2 = Sum of x^j for j = [0, n-1].\n",
        "Theorem 1-3 = Fake Fundamental Theorem of Arethmetic.\n",
        "Theorem 2-1 = Euclid's Division Lemma.\n",
        "Theorem 2-2 = Greatest Common Divisor.\n",
        "Theorem 2-3 = If gcd(a, c) = 1 and c|ab, then c|b.\n",
        "Theorem 2-4 = Linear Diophantine Equation.\n",
        "Theorem 2-5 = True Fundamental Theorem of Arethmetic.\n",
    };
    private final String[] menus = {
            "What do you want to do?\n(excluding this message, things in parentheses indicate an input command option)\n\n\t(11): Theorem 1-1 = Sum of the first N Integers.\n\t(12): Theorem 1-2 = Sum of x^j for j = [0, n-1].\n\t(13): Theorem 1-3 = Fake Fundamental Theorem of Arethmetic.\n\n\t(21): Theorem 2-1 = Euclid's Division Lemma.\n\t(22): Theorem 2-2 = Greatest Common Divisor.\n\t(23): Theorem 2-3 = If gcd(a, c) = 1 and c|ab, then c|b.\n\t(24): Theorem 2-4 = Linear Diophantine Equation.\n\t(25): Theorem 2-5 = True Fundamental Theorem of Arethmetic.\n\nWell, put in some input: ",
            "Here are some options:\n(1): Learn about it.\n\t (2): Test it out.\n\nWhat do you want to do? ", };

    public String getIntroDialogue(final String whichOne) {
        String returnValue;
        switch (whichOne) {
            case "Main":
                returnValue = intros[0];
                break;
            case "11Intro":
                returnValue = intros[1];
                break;
            case "12Intro":
                returnValue = intros[2];
                break;
            case "13Intro":
                returnValue = intros[3];
                break;
            case "21Intro":
                returnValue = intros[4];
                break;
            case "22Intro":
                returnValue = intros[5];
                break;
            case "23Intro":
                returnValue = intros[6];
                break;
            case "24Intro":
                returnValue = intros[7];
                break;
            case "25Intro":
                returnValue = intros[8];
                break;
            default:
                returnValue = "Sorry, " + whichOne + " isn't a valid Intro Dialogue option.";
                break;
        }
        return returnValue;
    }

    public String getMenuDialogue(final String whichOne) {
        String returnValue;
        switch (whichOne) {
            case "Main": returnValue = menus[0]; break;
            case "Theo": returnValue = menus[1]; break;
            default:
                returnValue = "Sorry, " + whichOne + " isn't a valid Menu Dialogue option.";
                break;
        }
        return returnValue;
    }
}
