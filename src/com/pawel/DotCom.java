package com.pawel;

import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> locationCells;

    public DotCom(String name, ArrayList<String> locationCells) {
        this.name = name;
        this.locationCells = new ArrayList<>(locationCells);
    }

    public String checkYourself(String userInput) {
        String result = "Miss";

        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);
            result = "Hit";
        }
        if (locationCells.isEmpty()){
            result = "Kill" ;
        }

        return result;
    }

    public String getName() {
        return name;
    }
}
