package dnd.mlogger.domain;

import dnd.mlogger.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private String name;
    private List<String> questSteps;
    private List<String> completedQuestSteps;
    private List<String> uncompletedQuestSteps;

    private List<Person> people;
    private List<Location> locations;
    private Person questGiver;


    public Quest(String name){
        this.name = name;
    }

    public Quest(String name, Person questGiver){
        this.name = name;
        this.questGiver = questGiver;
    }
    public Quest(String name, List<String> questSteps, Person questGiver, List<Person> people) {
        this.name = name;
        this.questGiver = questGiver;
        this.questSteps = questSteps;
        this.completedQuestSteps = new ArrayList<>();
        this.uncompletedQuestSteps = questSteps;
        this.people = new ArrayList<>();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuestGiver(Person questGiver) {
        this.questGiver = questGiver;
    }

    public void setPeople(Person person){
        this.people.add(person);
    }

    public void setLocations(Location location){
        this.locations.add(location);
    }

    public String getName() {
        return name;
    }

    public List<String> getQuestSteps() {
        return questSteps;
    }

    public List<String> getCompletedQuestSteps() {
        return completedQuestSteps;
    }

    public List<String> getUncompletedQuestSteps() {
        return uncompletedQuestSteps;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Person getQuestGiver() {
        return questGiver;
    }
}
