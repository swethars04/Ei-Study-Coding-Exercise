import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SatelliteControlApp {

    // Simple logger for info and errors
    static class Logger {
        public static void info(String message) {
            System.out.println("[INFO " + now() + "] " + message);
        }
        public static void error(String message) {
            System.err.println("[ERROR " + now() + "] " + message);
        }
        private static String now() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    // Satellite state: orientation, panels, data
    static class Satellite {
        private String orientation;
        private boolean solarPanelsActive;
        private int dataCollected;

        public Satellite() {
            this.orientation = "North";
            this.solarPanelsActive = false;
            this.dataCollected = 0;
        }
        public void setOrientation(String direction) {
            orientation = direction;
            Logger.info("Satellite rotated to " + direction);
        }
        public void activatePanels() {
            solarPanelsActive = true;
            Logger.info("Solar panels activated.");
        }
        public void deactivatePanels() {
            solarPanelsActive = false;
            Logger.info("Solar panels deactivated.");
        }
        public void collectData() {
            if (solarPanelsActive) {
                dataCollected += 10;
                Logger.info("Collected 10 units of data.");
            } else {
                Logger.error("Cannot collect data: Solar panels are inactive.");
            }
        }
        public void showStatus() {
            System.out.println("Orientation: " + orientation);
            System.out.println("Solar Panels: " + (solarPanelsActive ? "Active" : "Inactive"));
            System.out.println("Data Collected: " + dataCollected);
        }
    }

    interface Command {
        void execute() throws CommandException;
    }
    static class CommandException extends Exception {
        public CommandException(String message) { super(message); }
    }
    static class RotateCommand implements Command {
        private final Satellite satellite;
        private final String direction;
        public RotateCommand(Satellite satellite, String direction) {
            this.satellite = satellite; this.direction = direction;
        }
        public void execute() throws CommandException {
            if (!direction.matches("North|South|East|West")) {
                throw new CommandException("Invalid direction: " + direction);
            }
            satellite.setOrientation(direction);
        }
    }
    static class ActivatePanelsCommand implements Command {
        private final Satellite satellite;
        public ActivatePanelsCommand(Satellite satellite) { this.satellite = satellite; }
        public void execute() { satellite.activatePanels(); }
    }
    static class DeactivatePanelsCommand implements Command {
        private final Satellite satellite;
        public DeactivatePanelsCommand(Satellite satellite) { this.satellite = satellite; }
        public void execute() { satellite.deactivatePanels(); }
    }
    static class CollectDataCommand implements Command {
        private final Satellite satellite;
        public CollectDataCommand(Satellite satellite) { this.satellite = satellite; }
        public void execute() { satellite.collectData(); }
    }
    static class CommandInvoker {
        private final List<Command> history = new ArrayList<>();
        public void executeCommand(Command cmd) {
            try {
                cmd.execute();
                history.add(cmd);
            } catch (CommandException ce) {
                Logger.error(ce.getMessage());
            } catch (Exception e) {
                Logger.error("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        CommandInvoker invoker = new CommandInvoker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Satellite Command System");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show Satellite Status");
            System.out.println("2. Rotate Satellite");
            System.out.println("3. Activate Solar Panels");
            System.out.println("4. Deactivate Solar Panels");
            System.out.println("5. Collect Data");
            System.out.println("6. Exit");
            System.out.print("Enter command: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    satellite.showStatus(); break;
                case "2":
                    System.out.print("Enter direction (North/South/East/West): ");
                    String dir = scanner.nextLine();
                    invoker.executeCommand(new RotateCommand(satellite, dir)); break;
                case "3":
                    invoker.executeCommand(new ActivatePanelsCommand(satellite)); break;
                case "4":
                    invoker.executeCommand(new DeactivatePanelsCommand(satellite)); break;
                case "5":
                    invoker.executeCommand(new CollectDataCommand(satellite)); break;
                case "6":
                    running = false; System.out.println("Session ended."); break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }
}
