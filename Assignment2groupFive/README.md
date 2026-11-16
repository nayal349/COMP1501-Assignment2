# Toy Store Company — Assignment 2

**Course:** COMP 1502  
**Authors:** Mohamed El Hassen, Nathan, Pushkar

## Overview

Toy Store Company is a Java console-based inventory management application. It loads toy records from a semicolon-delimited text file and provides menus for searching, purchasing, adding, and removing toys.

## Features

- Search inventory by serial number, partial toy name, or toy type.
- Purchase a toy and decrease its available stock by one.
- Add new toys with input validation, including duplicate serial number checks.
- Remove toys from inventory.
- Suggest gifts using optional age, toy type, and price filters.
- Save inventory changes to `res/toys.txt` when exiting.

## Object-oriented design

The abstract `Toy` superclass contains common toy attributes. Four subclasses represent specific toy categories:

- `Figure` — classification
- `Animal` — material and size
- `Puzzle` — puzzle type
- `BoardGame` — minimum/maximum players and designers

The `ToyStoreController` handles inventory operations, while `ToyStoreMenu` handles console interaction. Custom exceptions include `InvalidPriceException` and `InvalidPlayersException`.

## Project structure

```text
src/
  mru/tsc/application/   App.java
  mru/tsc/controller/    ToyStoreController.java
  mru/tsc/exceptions/    InvalidPriceException.java, InvalidPlayersException.java
  mru/tsc/model/         Toy.java, Figure.java, Animal.java, Puzzle.java, BoardGame.java
  mru/tsc/view/          ToyStoreMenu.java
res/                     toys.txt
doc/                     Generated Javadoc
```

JUnit tests are included in the project's test source folder.

## Running the application

1. Import the project into **Eclipse** as a Java project.
2. Make sure `res/toys.txt` exists and the working directory is the **project root**.
3. Run `mru.tsc.application.App` as a **Java Application**.
4. Use the console menu. Select **Save & Exit** to write changes back to `res/toys.txt`.

> **Note:** The application reads and writes `res/toys.txt` relative to its working directory. Keep a backup of the original inventory file before testing modifications.

## Documentation and testing

- **Javadoc:** Open `doc/index.html` in a browser.
- **Unit tests:** Run the project's JUnit tests from Eclipse.

## Contributors

[Replace this line with the names of all group members.]
