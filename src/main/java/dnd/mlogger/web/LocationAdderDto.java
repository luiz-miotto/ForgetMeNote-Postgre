package dnd.mlogger.web;

import dnd.mlogger.domain.Location;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


public class LocationAdderDto {

    private Location location;
    private String name;
    private String subLocation;
    private String person;
    private String quest;


    public LocationAdderDto(){

    }

    public LocationAdderDto(String name, String subLocation){
        this.name = name;
        this.subLocation = subLocation;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public String getPerson() {
        return person;
    }

    public String getQuest() {
        return quest;
    }

    public LocationAdderDto(String name){
        this.name = name;
    }


    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }
}
