package project.models;

import project.ScreensManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Stadium extends Model {
    private String location;
    private int seatCapacity;

    public Stadium(String name, String location, int seatCapacity) {
        super(name);
        this.location = location;
        this.seatCapacity = seatCapacity;
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

        System.out.println("Enter Location or type 'same' to keep the same: (" + getLocation() + ")");
        String newLocation = scanner.next();
        if (!newLocation.equalsIgnoreCase("same")) {
            setLocation(newLocation);
        }

        System.out.println("Enter SeatCapacity or type 'same' to keep the same: (" + getSeatCapacity() + ")");
        String newSeatCapacity = scanner.next();
        if (!newSeatCapacity.equalsIgnoreCase("same")) {
            setSeatCapacity(Integer.parseInt(newSeatCapacity));
        }

        ScreensManager.goBack();
    }

    public ArrayList<Match> getMatches() {
        return null;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Stadium{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", seatCapacity=" + seatCapacity +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
