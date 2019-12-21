package Object;

import java.awt.*;

public class PolisenLocation {

    private String name, gps;

    public PolisenLocation(String name, String gps){
        this.name=name;
        this.gps=gps;
    }

    @Override
    public String toString() {
        return " Ortsnamn: " + name + ", GPSKoordinationer: " + gps;
    }
}
