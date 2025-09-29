# Exercise 2 - Satellite Command System

## Introduction

The **Satellite Command System** is a console-based application that
simulates controlling a satellite in orbit.
It focuses on **object-oriented programming, SOLID principles, and
design patterns** to implement commands such as rotating the satellite,
activating/deactivating solar panels, and collecting data.
This project demonstrates how state transitions and system dependencies
can be effectively managed in real-world scenarios like aerospace
technology.

------------------------------------------------------------------------

## Implemented Mini Project: Satellite Command System

### Features

1.  **Initialize Satellite State**
    -   Orientation: North
    -   Solar Panels: Inactive
    -   Data Collected: 0
2.  **Rotate Command**
    -   Rotates the satellite to a given direction (North, South, East,
        West).
    -   Example: `rotate(South)` → Orientation changes to *South*.
3.  **Activate / Deactivate Solar Panels**
    -   `activatePanels()` → Sets solar panels to *Active*.
    -   `deactivatePanels()` → Sets solar panels to *Inactive*.
4.  **Collect Data**
    -   `collectData()` → Increments data collected by 10 units.
    -   Only works if solar panels are *Active*.

### Example Execution

When the program runs, it executes a **predefined sequence of commands**
in the `main()` method, such as:

``` java
rotate(South);
activatePanels();
collectData();
```

**Resulting State:**
- Orientation: South
- Solar Panels: Active\
- Data Collected: 10

------------------------------------------------------------------------

## Technologies Used

-   **Programming Language:** Java (JDK 8 or higher)
-   **Design Principles:** OOP, SOLID
-   **Design Patterns:**
    -   **Singleton** → Satellite manager instance
    -   **Command** → Encapsulates actions like rotate, activate,
        collectData
    -   **Observer (Optional)** → Can be used for notifying subsystems
        (e.g., logging, monitoring)
-   **Development Tools:** IntelliJ IDEA / Eclipse / VS Code

------------------------------------------------------------------------

## How to Run

1.  Clone the repository:

    ``` bash
    git clone <repository_url>
    cd Ei-Study-Coding-Exercise-main/Exercise 2- Satellite Command System
    ```

2.  Open the project in your IDE.

3.  Compile and run the main class (e.g.,
    `SatelliteCommandSystem.java`):

    ``` bash
    javac SatelliteCommandSystem.java
    java SatelliteCommandSystem
    ```

4.  The program will automatically execute a **predefined set of
    satellite commands** and print the satellite's updated state step by
    step in the console.

------------------------------------------------------------------------

## Learning Outcomes

By completing this project, students will learn to:
- Implement **state management** in a simulation-based application.
- Apply **design patterns** like Singleton and Command effectively.
- Write clean, maintainable, and extensible **OOP-based code**.
- Handle **dependencies and validations** gracefully.
- Gain exposure to **real-world system design challenges** in aerospace
simulations.

------------------------------------------------------------------------

## Conclusion

The **Satellite Command System** mini project successfully demonstrates
how design patterns and OOP principles can be applied to build robust
console applications.
It simulates realistic state transitions such as satellite orientation,
solar panel status, and data collection, while maintaining clarity,
scalability, and maintainability.
This exercise serves as a strong foundation for building more complex
aerospace or system control simulations in the future.

