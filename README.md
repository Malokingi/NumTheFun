# Number Theory Fun
Learn about and scruitnize a few basic Number Theory concepts up to and including The Fundamental Theorem of Arithmetic!

## Target tech stack
- [x] Java 8
  - [x] File I/O
    - [x] Takes User Input (from Command Line, for example)
    - [x] Takes File Input
  - [x] Collections API
  - [x] Concurrency
- [x] Maven 3
  - [x] Setup
  - [x] Manage (Clean, Compile, etc.)
- [x] JUnit 5
  - [x] Testing
- [x] Git
  - [x] Init
  - [x] General Version control (commit, push, etc.)
- [x] PostgreSQL 9+
  - [x] Get DB Info

## Extra Tech Stack
- [x] Jenkins
  - [x] Auto builds in Jenkins when a new commit is pushed.

## Features
- [x] Top Menu
- [x] Add a Glossary
  - [x] Build most of it (with predetermined content)
- [x] Chapter 1
  - [x] Theorem 1-1 = Sum of the first N Integers.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 1-2 = Sum of x^j for j = [0, n-1].
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 1-3 = Basis Represenataion Theorem.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
- [x] Chapter 2
  - [x] Theorem 2-1 = Euclid's Division Lemma.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 2-2 = Greatest Common Divisor.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 2-3 = If gcd(a, c) = 1 and c|ab, then c|b.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 2-4 = Linear Diophantine Equation.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version
  - [x] Theorem 2-5 = Fundamental Theorem of Arithmetic.
    - [x] Educational Dialogue
    - [x] User Test Loop
    - [x] Non-User Version

## Extra Features
  - [ ] Add Proofs
  - [ ] Define more terms
  - [ ] Account for Integer Limitations (use longs instead of ints)
  - [ ] Improve the pace of the output (wait())
  - [x] Input Data Validation
  - [x] Make Theroem 2-4 return the smallest solution
  - [ ] Make longDivide() better or find some other way to test divisibility for large numbers
  - [x] Look Up Words
  
  From the main dir, run with: (this will delete the log, and do maven clean, compile, then exec:java)
  ```
  ./run
  ```

  Today is 2020/09/17 18:28