package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void addTest(){
        //Given
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");

        PhoneBook newPhoneBook = new PhoneBook();
        int count = 0;

        //When
        newPhoneBook.add(name, phoneNumbers);
        count++;

        //Then
        int listSize = newPhoneBook.tmap.size();
        Assert.assertEquals(count, listSize);
    }
    @Test
    public void removeTest(){
        //Given
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");
        int count = 1;
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add(name, phoneNumbers);


        //When
        newPhoneBook.remove("Sravani");
        count--;

        //Then
        int listSize = newPhoneBook.tmap.size();
        Assert.assertEquals(count, listSize);
    }
    @Test
    public void lookupTest(){
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();
        List<String> retrievedPhoneNumbers = new ArrayList<String>();
        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add(name, phoneNumbers);

        //When
        retrievedPhoneNumbers = newPhoneBook.lookup("Sravani");

        //Then
        Assert.assertEquals(phoneNumbers, retrievedPhoneNumbers);
    }
    @Test
    public void reverseLookupTest(){
        //Given
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();

        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add(name, phoneNumbers);

        //When
        String retrievedName = newPhoneBook.reverseLookup("232-454-6778");

        //Then
        Assert.assertEquals(name, retrievedName);
    }
    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @Test
    public void displayTest(){
        //Given
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();

        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add(name, phoneNumbers);

        //When
        newPhoneBook.display();

        //Then
        Assert.assertEquals("Sravani [232-454-6778, 565-545-3434]", outContent.toString().trim());
    }
    @Test
    public void removeRecordTest(){
        //Given
        String name = "Sravani";
        List<String> phoneNumbers = new ArrayList<String>();

        phoneNumbers.add("232-454-6778");
        phoneNumbers.add("565-545-3434");
        PhoneBook newPhoneBook = new PhoneBook();
        newPhoneBook.add(name, phoneNumbers);
        int count = 1;

        //When
        newPhoneBook.removeRecord(name);
        count--;

        //Then
        int listSize = newPhoneBook.tmap.size();
        Assert.assertEquals(count, listSize);
    }
}
