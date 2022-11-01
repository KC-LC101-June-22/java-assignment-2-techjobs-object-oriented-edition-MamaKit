package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String aName;
        String anEmployer;
        String aLocation;
        String aPositionType;
        String aCoreCompetency;
        boolean nameBlank;
        boolean employerBlank;
        boolean locationBlank;
        boolean positionBlank;
        boolean coreBlank;

        if (this.name == "" || this.name == " " || this.name == null) {
            aName = "Data not available";
            nameBlank = true;
        } else {
            aName = this.name;
            nameBlank = false;
        }
        if (this.employer.toString() == "" || this.employer.toString() == " " || this.employer.toString() == null) {
            anEmployer = "Data not available";
            employerBlank = true;
        } else {
            anEmployer = this.employer.toString();
            employerBlank = false;
        }
        if (this.location.toString() == "" || this.location.toString() == " " || this.location.toString() == null) {
            aLocation = "Data not available";
            locationBlank = true;
        } else {
            aLocation = this.location.toString();
            locationBlank = false;
        }
        if (this.positionType.toString() == "" || this.positionType.toString() == " " || this.positionType.toString() == null) {
            aPositionType = "Data not available";
            positionBlank = true;
        } else {
            aPositionType = this.positionType.toString();
            positionBlank = false;
        }
        if (this.coreCompetency.toString() == "" || this.coreCompetency.toString() == " " || this.coreCompetency.toString() == null) {
            aCoreCompetency = "Data not available";
            coreBlank = true;
        } else {
            aCoreCompetency = this.coreCompetency.toString();
            coreBlank = false;
        }
        if ((nameBlank == true) && (employerBlank == true) && (locationBlank == true) && (positionBlank ==true) && (coreBlank == true)) {
            return "\nOOPS! This job does not seem to exist.\n";
        } else {
            return "\nID: "+this.id+"\nName: "+aName+"\nEmployer: "+anEmployer+"\nLocation: "+aLocation+"\nPosition Type: "+aPositionType+"\nCore Competency: "+aCoreCompetency+"\n";
        }
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
