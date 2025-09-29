package behavioural_design_pattern;

interface Command {
    void execute();
}

// Receiver class
class BugZapper {
    public void turnOn() { System.out.println("Bug Zapper is ON. Ready to zap bugs!"); }
    public void turnOff() { System.out.println("Bug Zapper is OFF. Safe for bugs now."); }
}

// Concrete command to turn ON the bug zapper
class TurnOnBugZapperCommand implements Command {
    private BugZapper bugZapper;
    public TurnOnBugZapperCommand(BugZapper bugZapper) { this.bugZapper = bugZapper; }
    public void execute() { bugZapper.turnOn(); }
}

// Concrete command to turn OFF the bug zapper
class TurnOffBugZapperCommand implements Command {
    private BugZapper bugZapper;
    public TurnOffBugZapperCommand(BugZapper bugZapper) { this.bugZapper = bugZapper; }
    public void execute() { bugZapper.turnOff(); }
}

// Invoker class
class VoiceAssistant {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void sayCommand() { command.execute(); }
}

// Client code
public class CommandDemo {
    public static void main(String[] args) {
        BugZapper gardenZapper = new BugZapper();
        VoiceAssistant assistant = new VoiceAssistant();

        assistant.setCommand(new TurnOnBugZapperCommand(gardenZapper));
        assistant.sayCommand();

        assistant.setCommand(new TurnOffBugZapperCommand(gardenZapper));
        assistant.sayCommand();
    }
}
