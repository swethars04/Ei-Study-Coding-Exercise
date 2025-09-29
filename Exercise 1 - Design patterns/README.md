# Exercise 1 - Design Patterns

## Introduction

This exercise demonstrates the implementation of fundamental
**Object-Oriented Design Patterns** in Java. Design patterns provide
tested, reusable solutions to common software design problems, making
applications more robust, scalable, and easier to maintain.
The exercise covers **Creational**, **Structural**, and **Behavioural**
design patterns, each explained with a practical Java example.

------------------------------------------------------------------------

## Implemented Design Patterns & Examples

### 1. Creational Design Patterns

Creational patterns deal with object creation mechanisms, trying to
create objects in a manner suitable to the situation.

-   **Builder Pattern** (`BuilderDemo.java`)
    Example: A customizable **Sandwich Builder** that allows flexible
    configuration of ingredients (bread, protein, sauce, cheese).
    -   Ensures immutability of objects.
    -   Simplifies object creation with multiple optional parameters.
-   **Prototype Pattern** (`PrototypeDemo.java`)
    Example: A **Robot Parts Factory** where base templates of arms and
    legs are created and then cloned to generate new parts at different
    positions.
    -   Avoids creating new objects from scratch.
    -   Makes it easy to duplicate objects with different states.
    -   Demonstrates how `clone()` provides efficient copying for
        repetitive object creation.

------------------------------------------------------------------------

### 2. Structural Design Patterns

Structural patterns focus on class and object composition.

-   **Decorator Pattern** (`DecoratorDemo.java`)
    Example: Extends the functionality of a **Basic Coffee** object by
    adding optional extras like milk or sugar without modifying the
    original class.
    -   Promotes code flexibility by attaching new behavior
        dynamically.
    -   Follows the **"open for extension, closed for modification"**
        principle.
-   **Facade Pattern** (`FacadeDemo.java`)
    Example: Provides a simplified interface to complex subsystems like
    **Light System** and **Thermostat** for managing a smart home.
    -   Hides implementation details of subsystems.
    -   Makes APIs easier to use by offering a unified high-level
        interface.

------------------------------------------------------------------------

### 3. Behavioural Design Patterns

Behavioural patterns are concerned with algorithms and the assignment of
responsibilities between objects.

-   **Command Pattern** (`CommandDemo.java`)
    Example: Controls a **Bug Zapper** device with commands like
    `TurnOnCommand` and `TurnOffCommand`.
    -   Encapsulates a request as an object.
    -   Decouples the sender (remote control) from the receiver (bug
        zapper).
    -   Supports undo/redo operations in real-world applications.
-   **Strategy Pattern** (`strategy.java`)
    Example: Defines different **playback strategies** for a music
    player (Normal Play, Shuffle Play, etc.).
    -   Defines a family of algorithms and makes them interchangeable.
    -   Promotes flexibility by selecting algorithms at runtime.

------------------------------------------------------------------------

## Technologies Used

-   **Programming Language:** Java (JDK 8 or higher)
-   **IDE/Editor:** Eclipse, IntelliJ IDEA, or any Java-compatible
    editor
-   **Version Control:** Git/GitHub for code management

------------------------------------------------------------------------

## How to Run

1.  Clone the repository:

    ``` bash
    git clone https://github.com/swethars04/Ei-Study-Coding-Exercise.git
    cd Ei-Study-Coding-Exercise-main/Exercise 1 - Design patterns
    ```

2.  Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code + Java support).

3.  Make sure you have Java SDK 8 or higher installed and configured.

4.  Navigate to the respective folder (`Creational_design_pattern`,
    `Structural_design_pattern`, or `Behavioural_design_pattern`).

5.  Compile and run the Java files. Example:

    ``` bash
    javac Behavioural_design_pattern/CommandDemo.java
    java Behavioural_design_pattern.CommandDemo
    ```

------------------------------------------------------------------------

## Learning Outcomes

By completing this exercise, students will be able to: - Understand the
**importance of design patterns** in software development.
- Differentiate between **Creational, Structural, and Behavioural**
patterns.
- Implement design patterns in **real-world Java programs**.
- Improve **code reusability, scalability, and maintainability**.
- Gain practical knowledge of applying **OOP principles** effectively.

------------------------------------------------------------------------

## Conclusion

This exercise provided hands-on experience with some of the most widely
used design patterns in software engineering.
By practicing these patterns in Java, learners can develop stronger
problem-solving skills and produce cleaner, more maintainable code
essential traits for becoming proficient software engineers.

