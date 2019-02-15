package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    String name;
    String phoneNumber;

    TreeMap<String, List<String>> tmap = new TreeMap<String, List<String>>();


    public void add(String name, List<String> phoneNumbers){
       // adds an entry to the composite associate data type
        tmap.put(name,phoneNumbers);

    }
    public void remove(String name){
        //removes an entry to the composite associate data type
        tmap.remove(name);
    }
    public List<String> lookup(String name){
        //returns a phone numbers for the respective input name
        List<String> phoneNumbers = tmap.get(name);
        return phoneNumbers;
    }
    public String reverseLookup(String phoneNumber){
        String name = "";
        //returns a name for the respective input phoneNumber
        for(Map.Entry<String, List<String>> entry : tmap.entrySet()){
            List<String> str = entry.getValue();
            for(String s: str){
                if(s.equals(phoneNumber)){
                      name = entry.getKey();
                }
            }
        }
        return name;
    }

   public void display(){
        //print a human-readable list of all entries (names and phone numbers) in alphabetical order.
       Set set = tmap.entrySet();
       Iterator iterator = set.iterator();
       while(iterator.hasNext()){
           Map.Entry mentry = (Map.Entry)iterator.next();
           System.out.println(mentry.getKey() + " " + mentry.getValue());
       }
    }

    public void removeRecord(String name) {
        tmap.remove(name);
    }
}
