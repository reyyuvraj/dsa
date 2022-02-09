package college;

import java.util.*;

class Earplug {
    public String color;
    private String brand;

    Earplug(String color, String brand) {
        this.color = "Gray";
        this.brand = brand;
    }

    public void displayDetails() {
        System.out.println(this.brand + " " + this.color);
    }
}

class WirelessEarplug extends Earplug {
    private int bluetoothVersion;

    WirelessEarplug(String color, String brand) {
        super(color, brand);
        this.bluetoothVersion = 4;
    }

    public void displayWirelessDetails() {
        this.displayDetails();
        System.out.println(this.bluetoothVersion);
    }
}

public class Test {
    public static void main(String[] args) {
        Earplug earplugObj1 = new WirelessEarplug("Black", "Noise");
        earplugObj1.displayDetails();
        WirelessEarplug earplugOnj2 = new WirelessEarplug("Black", "Boat");
        earplugOnj2.color = "White";
        earplugOnj2.displayWirelessDetails();
    }
}
