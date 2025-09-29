package creational_design_pattern;

// Abstract prototype
abstract class RobotPart implements Cloneable {
    String partType;
    int positionX, positionY;

    public RobotPart(String partType) {
        this.partType = partType;
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public abstract void showPart();

    @Override
    public RobotPart clone() throws CloneNotSupportedException {
        return (RobotPart) super.clone();
    }
}

// Concrete prototype: Arm
class ArmPart extends RobotPart {
    public ArmPart() {
        super("Robot Arm");
    }

    @Override
    public void showPart() {
        System.out.println(partType + " at position (" + positionX + ", " + positionY + ")");
    }
}

// Concrete prototype: Leg
class LegPart extends RobotPart {
    public LegPart() {
        super("Robot Leg");
    }

    @Override
    public void showPart() {
        System.out.println(partType + " at position (" + positionX + ", " + positionY + ")");
    }
}

// Demo class
public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Base Arm template
        ArmPart baseArm = new ArmPart();
        baseArm.setPosition(0, 0);
        baseArm.showPart();

        // Clone arms with different positions
        ArmPart leftArm = (ArmPart) baseArm.clone();
        leftArm.setPosition(-1, 0);
        leftArm.showPart();

        ArmPart rightArm = (ArmPart) baseArm.clone();
        rightArm.setPosition(1, 0);
        rightArm.showPart();

        // Base leg template
        LegPart baseLeg = new LegPart();
        baseLeg.setPosition(0, -1);
        baseLeg.showPart();

        LegPart leftLeg = (LegPart) baseLeg.clone();
        leftLeg.setPosition(-1, -1);
        leftLeg.showPart();
    }
}
