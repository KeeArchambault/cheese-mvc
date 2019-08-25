package org.launchcode.cheesemvc.models;

public class Cheese{

    private String name;
    private String description;

    public Cheese(String aName, String aDescription){
        this.description = aDescription;
        this.name = aName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription){
        description = aDescription;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String aName){
        name = aName;
    }
}
