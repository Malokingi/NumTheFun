package com.matthewsgrand;

public final class TempFakeDatabase {
    public TempFakeDatabase() { }

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
        "You want to Quit? But you just got here... Goodbye.",
    };
    private final String[] menus = {
        "What do you want to do?\n(excluding this message, things in parentheses indicate an input command option)\n\n\t(11): Theorem 1-1 = Sum of the first N Integers.\n\t(12): Theorem 1-2 = Sum of x^j for j = [0, n-1].\n\t(13): Theorem 1-3 = Fake Fundamental Theorem of Arethmetic.\n\n\t(21): Theorem 2-1 = Euclid's Division Lemma.\n\t(22): Theorem 2-2 = Greatest Common Divisor.\n\t(23): Theorem 2-3 = If gcd(a, c) = 1 and c|ab, then c|b.\n\t(24): Theorem 2-4 = Linear Diophantine Equation.\n\t(25): Theorem 2-5 = True Fundamental Theorem of Arethmetic.\n\n\t(00): Quit Program.\n\nWell, put in some input: ",
        "Here are some options:\n\n\t(1): Learn about it.\n\t(2): Test it out.\n\n\t(0): Return to Main Menu.\n\nWhat do you want to do? ",
    };
    private final String[] edus = {
        "\nTheorem 1-1 is a simple theorem which observes the following:\n\nFor a given Natural Number, n, adding all consecutive Integers starting from 1, or technically you can say \"starting from 0\" and it would be the same, up to and including n is equal to:\n\n\t(n x (n + 1)) / 2",
        "\nTheorem 1-2 states:\n\nFor any real number, x, where x != 1, and a given Natural Number, n, then:\n\n\t(x ^ 0) + (x ^ 1) + (x ^ 2) + ... + (x ^ (n - 1)) = ((x ^ n) - 1) / (x - 1)",
        "\nTheorem 1-3 kinda looks like a first draft of The Fundamental Theorem of Arithmetic with hints of Euclid's Division Lemma sprinkled about:\n\nFor a given Natural Numbers, k and n, there exists:\n\n\tn = a[0]k^(s) + a[1]k^(s - 1) + ... + a[s]k^(0)\n\nwhere a[0] != 0 and 0 <= a[i] < k. Also, this represenataion of n is unique in relation to k. This is referred to as \"The representation of n to base k\".",
        "\nTheorem 2-1 Euclid's Division Lemma states:\n\nFor a given Natural Number, k and Integer, j, there exists a pair of Integers, q and r, such that:\n\n\tj = qk + r\n\nAlso, 0 <= r < k and the pair (q, r) is unique.",
        "\nBefore getting to the theorem part, I'll explain what a Greatest Common Divisor is:\n\nFor given Integers, a and b, where a and b are not both 0, an Integer, d, is called the Greatest Common Divisor, or gcd, of a and b if:\n\n\ti. d > 0\n\n\tii. d is a Common Divisor of a and b\n\n\tiii. all other Integers that are divisors of a and b are also divisors of d\n\nTheorem 2-2 states:\n\nFor given Integers, a and b, where a and b are not both 0, then gcd(a, b) exists and is unique.",
        "/nTheorem 2-3 states:/n/nFor given Integers, a, b, and c, if gcd(a, c) = 1 and c|ab, then c|b.",
        "\nTheorem 2-4 The Linear Diophantine Equation states:\n\nFor Given Integers, a, b, and c:\n\n\tax + by = c\n\nhas a solution if, and only if, for when gcd(a, b) = d, d|c.\n\nFurthermore, if (x[0], y[0]) is a solution of this equation, then the set of solutions of this equation consists of all Integer pairs, (x[i], y[i]) where, for any Integer, t:\n\n\tx[i] = x[0] + t(b/d)\n\ty[i] = y[0] + t(a/d)",
        "\nTheorem 2-5 The Fundamental Theorem of Arithmetic states:\n\nFor Each Natural Number, n, there exists an array of Prime Numbers, p, where p[1] <= p[2] <= ... <= p[r] such that:\n\n\tn = p[1]p[2]...p[r]\n\nThis factorization is unique.",
    };

    public String getIntroDialogue(final String whichOne) {
        String returnValue;
        switch (whichOne) {
            case "Main": returnValue = intros[0]; break;
            case "11Intro": returnValue = intros[1]; break;
            case "12Intro": returnValue = intros[2]; break;
            case "13Intro": returnValue = intros[3]; break;
            case "21Intro": returnValue = intros[4]; break;
            case "22Intro": returnValue = intros[5]; break;
            case "23Intro": returnValue = intros[6]; break;
            case "24Intro": returnValue = intros[7]; break;
            case "25Intro": returnValue = intros[8]; break;
            case "Outro": returnValue = intros[9]; break;
            default:
                returnValue = "Sorry, " + whichOne + " isn't a valid Intro option.\n";
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
                returnValue = "Sorry, " + whichOne + " isn't a valid Menu option.";
                break;
        }
        return returnValue;
    }

    public String getEduDialogue(final String whichOne) {
        String returnValue;
        switch (whichOne) {
            case "11Edu": returnValue = edus[0]; break;
            case "12Edu": returnValue = edus[1]; break;
            case "13Edu": returnValue = edus[2]; break;
            case "21Edu": returnValue = edus[3]; break;
            case "22Edu": returnValue = edus[4]; break;
            case "23Edu": returnValue = edus[5]; break;
            case "24Edu": returnValue = edus[6]; break;
            case "25Edu": returnValue = edus[7]; break;
            default:
                returnValue = "Sorry, " + whichOne + " isn't a valid Edu option.";
                break;
        }
        return returnValue;
    }
}
