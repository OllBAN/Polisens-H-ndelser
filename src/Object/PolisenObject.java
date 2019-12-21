package Object;

import java.util.List;

public class PolisenObject {
    private int id;
    private String datetime, name, summary, url, type;
    private List<PolisenLocation> location;
    //private PolisenLocation location;

    public PolisenObject(int id, String datetime, String name, String summary, String url, String type){
        this.id=id;
        this.datetime=datetime;
        this.name=name;
        this.summary=summary;
        this.url=url;
        this.type=type;
        //this.location=location; <-- Ska läggas till senare.s
    }

    @Override
    public String toString() {
        return " id=" + id + ",\n datetime=" + datetime + ", name=" + name + ",\n summering=" + summary + ", url=" + url +
                ", type=" + type + ", location=" + location;
    }
}
