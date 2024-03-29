package Object;

import java.util.List;

public class PolisenObject {
    private int id;
    private String datetime, name, summary, url, type;
    private PolisenLocation polisenLocation;
    private List<PolisenLocation> location;

    public PolisenObject(int id, String datetime, String name, String summary, String url, String type, PolisenLocation polisenLocation){
        this.id=id;
        this.datetime=datetime;
        this.name=name;
        this.summary=summary;
        this.url=url;
        this.type=type;
        this.polisenLocation=polisenLocation;
        //this.location=location; //<-- Ska läggas till senare.
    }

    @Override
    public String toString() {
        return " ID: " + id + ",\n Datetime: " + datetime + ", Namn: " + name + ",\n " +
                "Summering: " + summary + ", URL: " + url + ", \n" +
                " Typ: " + type + ", Plats: " + polisenLocation;
    }
}
