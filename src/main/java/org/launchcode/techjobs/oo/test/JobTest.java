package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1.getId(),test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(test.getName(),"Product tester");
        assertEquals(test.getEmployer().toString(), "ACME");
        assertEquals(test.getLocation().toString(), "Desert");
        assertEquals(test.getPositionType().toString(), "Quality control");
        assertEquals(test.getCoreCompetency().toString(), "Persistence");
        assertTrue(test.getName() instanceof String);
        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test.getPositionType() instanceof PositionType);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test1.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(test.toString().charAt(0),'\n');
        assertEquals(test.toString().charAt(test.toString().length()-1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(test.toString(),"\nID: "+test.getId()+"\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job test1 = new Job(" ", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("", new Employer(" "), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test3 = new Job("", new Employer(""), new Location(" "), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test4 = new Job("", new Employer(""), new Location(""), new PositionType(" "), new CoreCompetency("Persistence"));
        Job test5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(" "));
        Job test6 = new Job(null, new Employer(), new Location(), new PositionType(), new CoreCompetency());
        assertEquals(test1.toString(),"\nID: "+test1.getId()+"\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
        assertEquals(test2.toString(),"\nID: "+test2.getId()+"\nName: Data not available\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
        assertEquals(test3.toString(),"\nID: "+test3.getId()+"\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Persistence\n");
        assertEquals(test4.toString(),"\nID: "+test4.getId()+"\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Persistence\n");
        assertEquals(test5.toString(),"\nOOPS! This job does not seem to exist.\n");
        assertEquals(test6.toString(),"\nOOPS! This job does not seem to exist.\n");
    }


}