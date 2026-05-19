# Assignment 2 — Compilers (Spring 2026)

ANTLR grammar that computes the `check` attribute for comma-separated sequences of numbers.

## Project layout

```
Assignment2/
├── pom.xml
└── src/
    ├── main/
    │   ├── antlr4/csen1003/main/A2/Assignment2.g4   ← edit this
    │   └── java/csen1003/main/A2/Assignment2Runner.java
    └── test/
        └── java/csen1003/tests/A2/Assignment2TestsBatch1.java
```

## Prerequisites

- **JDK 17 or higher** (`java -version` should show 17+)
- **Maven 3.8+** (`mvn -v`)
- **VS Code** with the "Extension Pack for Java" extension installed
- Optional: "ANTLR4 grammar syntax support" extension by Mike Lischke for `.g4` syntax highlighting

## Workflow

Open the project folder in VS Code. The Java extension will detect `pom.xml` and import it as a Maven project. Wait for "Importing Maven project…" in the status bar to finish.

### Generate the parser and run the tests

In the integrated terminal:

```bash
mvn test
```

The `antlr4-maven-plugin` regenerates `Assignment2Lexer.java` and `Assignment2Parser.java` under `target/generated-sources/antlr4/csen1003/main/A2/` before each compile, so you never edit those files directly.

### Run only the runner (for ad-hoc debugging)

```bash
mvn compile exec:java -Dexec.mainClass="csen1003.main.A2.Assignment2Runner"
```

Or right-click `Assignment2Runner.java` in VS Code and choose **Run Java**.

### Clean everything

```bash
mvn clean
```

## Before submitting

1. Open `src/main/antlr4/csen1003/main/A2/Assignment2.g4`.
2. Replace the `@name`, `@id`, and `@tutorialNumber` placeholders at the top with your info.
3. Submit **only** that single `Assignment2.g4` file at the Google Form link from the assignment.
