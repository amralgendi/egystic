package project.models;

import java.util.UUID;

abstract public class Model {
    protected String name;
    final private String Id;

    Model (String name) {
        this.name = name;
        Id = UUID.randomUUID().toString();
    }

    public String getId() { return Id;}
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name;}

    public void displayInfo() {
        System.out.println(this);
    }
    public void editModel(){};

}
