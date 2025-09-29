package structural_design_pattern;

// Subsystems
class LightSystem {
    public void turnOnLights() { System.out.println("Lights turned ON."); }
    public void turnOffLights() { System.out.println("Lights turned OFF."); }
}

class Thermostat {
    public void setTemperature(int degrees) { System.out.println("Thermostat set to " + degrees + "°C."); }
}

class SecurityCamera {
    public void activateCameras() { System.out.println("Security cameras activated."); }
    public void deactivateCameras() { System.out.println("Security cameras deactivated."); }
}

// Facade
class SmartHomeFacade {
    private LightSystem lights = new LightSystem();
    private Thermostat thermostat = new Thermostat();
    private SecurityCamera camera = new SecurityCamera();

    public void activateMorningRoutine() {
        lights.turnOnLights();
        thermostat.setTemperature(22);
        camera.deactivateCameras();
        System.out.println("Morning routine activated.");
    }

    public void activateNightRoutine() {
        lights.turnOffLights();
        thermostat.setTemperature(18);
        camera.activateCameras();
        System.out.println("Night routine activated.");
    }
}

// Client/Demo
public class FacadeDemo {
    public static void main(String[] args) {
        SmartHomeFacade home = new SmartHomeFacade();

        home.activateMorningRoutine();
        System.out.println();
        home.activateNightRoutine();
    }
}
