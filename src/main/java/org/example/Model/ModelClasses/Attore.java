package org.example.Model.ModelClasses;

public class Attore{
    private int actorId;
    private String firstName;
    private String lastName;

    public Attore(){};

    public Attore(int actorId, String firstName, String lastName){
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Attore(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setActorId(int actorId){
        this.actorId = actorId;
    }
    public int getActorId(){
        return this.actorId;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
}