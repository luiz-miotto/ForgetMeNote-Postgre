package dnd.mlogger.domain;

import dnd.mlogger.repositories.LocationRepository;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Location {
    private String name;
    private List<String> subLocations;
    private List<Person> people;
    private List<Quest> quests;

    private LocationRepository locationRepository;

    public Location(){

    }
    public Location(String name){
        this.name = name;
        this.subLocations = new ArrayList<>();
    }

    public Location(String name, List<String> subLocations, List<Person> people, List<Quest> quests) {
        this.name = name;
        this.subLocations = subLocations;
        this.people = people;
        this.quests = quests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void setSubLocations(String subLocation) {
        this.subLocations.add(subLocation);
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubLocations() {
        return subLocations;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Quest> getQuests() {
        return quests;
    }


}
