package dnd.mlogger.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
    private String name;
    private Boolean alive;
   //private Alliance alliance;
    private Quest quest;
    private List<Quest> associatedQuests;
    private List<String> motivations;
    private List<String> suspectedSecrets;
    private List<String> dispositions;
    private String description;
    private Location lastKnownLocation;

    public Person(){
        this.associatedQuests = new ArrayList<>();
        this.motivations = new ArrayList<>();
        this.suspectedSecrets = new ArrayList<>();
        this.dispositions = new ArrayList<>();

    }

    public Person(String name){
        this.name = name;
        this.associatedQuests = new ArrayList<>();
        this.motivations = new ArrayList<>();
        this.suspectedSecrets = new ArrayList<>();
        this.dispositions = new ArrayList<>();

    }

    public Person(String name, String description){
        this.name = name;
        this.associatedQuests = new ArrayList<>();
        this.motivations = new ArrayList<>();
        this.suspectedSecrets = new ArrayList<>();
        this.dispositions = new ArrayList<>();
        this.description = description;

    }

    public Person(String name, Boolean alive){
        this.name = name;
        this.alive = alive;
        this.associatedQuests = new ArrayList<>();
        this.motivations = new ArrayList<>();
        this.suspectedSecrets = new ArrayList<>();
        this.dispositions = new ArrayList<>();
    }

    public Person(String name, Location lastKnownLocation){
        this.name = name;
        this.associatedQuests = new ArrayList<>();
        this.motivations = new ArrayList<>();
        this.suspectedSecrets = new ArrayList<>();
        this.dispositions = new ArrayList<>();
        this.lastKnownLocation = lastKnownLocation;
    }

    public Person(String name, List<String> motivations){
        this.name = name;
        this.motivations = motivations;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(Boolean alive) {
        this.alive = alive;
    }

    public void setQuest(Quest quest){
        this.associatedQuests.add(quest);
    }

    public void setLastKnownLocation(Location lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setSuspectedSecrets(String suspectedSecret){
        this.suspectedSecrets.add(suspectedSecret);
    }

    public void setDispositions(String disposition){
        this.dispositions.add(disposition);
    }

    public void setMotivations(String motivation){
        this.motivations.add(motivation);
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public List<String> getSuspectedSecrets(){
        return this.suspectedSecrets;
    }


    public List<String> getDispositions(){
        return this.dispositions;
    }

    public List<String> getMotivations(){
        return this.motivations;
    }
}
