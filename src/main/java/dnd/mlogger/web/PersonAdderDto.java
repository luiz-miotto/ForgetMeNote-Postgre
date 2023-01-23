package dnd.mlogger.web;

import dnd.mlogger.domain.Person;

public class PersonAdderDto {
    private Person person;
    private String name;
    private String motivation;
    private String description;
    private String suspectedSecret;
    private String disposition;

    public PersonAdderDto(){
        Person person = new Person();
    }
    public PersonAdderDto(String name, String motivation,String suspectedSecret, String description, String disposition){
        this.name = name;
        this.motivation = motivation;
        this.suspectedSecret = suspectedSecret;
        this.description = description;
        this.disposition = disposition;
        Person person = new Person();
        person.setName(name);
        person.setMotivations(motivation);
        person.setDescription(description);
        person.setDispositions(disposition);
        person.setSuspectedSecrets(suspectedSecret);
    }



    public String getMotivation(){
        return this.motivation;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getSuspectedSecret(){
        return this.suspectedSecret;
    }

    public String getDisposition(){
        return this.disposition;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMotivation(String motivation){
        this.motivation = motivation;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setSuspectedSecret(String suspectedSecret){
        this.suspectedSecret = suspectedSecret;
    }

    public void setDisposition(String disposition){
        this.disposition = disposition;
    }
}
