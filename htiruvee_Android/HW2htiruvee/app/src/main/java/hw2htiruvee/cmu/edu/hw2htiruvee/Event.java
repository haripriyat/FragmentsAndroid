package hw2htiruvee.cmu.edu.hw2htiruvee;

/**
 * Created by haripriya on 6/1/2017.
 */

/**
 * This is a POJO file that represents an event object
 */

public class Event {
    long id;
    String name;
    String dateTime;
    String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
