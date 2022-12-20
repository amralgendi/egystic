package project.models;

import java.util.Scanner;

abstract class Person extends Model {
    protected float height;
    protected float weight;

    public Person(String name, float height, float weight) {
        super(name);
        this.height = height;
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public void editModel() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Enter Name or type 'same' to keep the same: (" + getName() + ")");
        String newName = scanner.next();
        if (!newName.equalsIgnoreCase("same")) {
            setName(newName);
        }

        System.out.println("Enter Height or type 'same' to keep the same: (" + getHeight() + ")");
        String newHeight = scanner.next();
        if (!newHeight.equalsIgnoreCase("same")) {
            setHeight(Float.parseFloat(newHeight));
        }

        System.out.println("Enter Weight or type 'same' to keep the same: (" + getWeight() + ")");
        String newWeight = scanner.next();
        if (!newWeight.equalsIgnoreCase("same")) {
            setWeight(Float.parseFloat(newWeight));
        }
    }
}
