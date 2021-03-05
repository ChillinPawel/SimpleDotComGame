package com.pawel;

import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper;
    private ArrayList<DotCom> dotComs;
    private int numOfGuesses;

    public DotComBust() {
        this.helper = new GameHelper();
        this.dotComs = new ArrayList<>();
    }

    private void setUpGame(){
        dotComs.add(new DotCom("Pets.com",helper.placeDotCom(3)));
        dotComs.add(new DotCom("Ask.Me",helper.placeDotCom(3)));
        dotComs.add(new DotCom("eToys.com",helper.placeDotCom(3)));

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
    }

    public void startPlaying(){
        setUpGame();
        while(!dotComs.isEmpty()){
            checkUserGuess(helper.getUserInput("Enter a guess from A0 to G6:"));
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses ++;
        String result = "Miss";
        for(DotCom dotCom : dotComs){
            result = dotCom.checkYourself(userGuess);
            if(result.equals("Kill")){
                result += "\nUrgh... You sank a " + dotCom.getName();
                dotComs.remove(dotCom);
                break;
            }else if(result.equals("Hit")){
                break;
            }
        }

        System.out.println(result);

    }

    private void finishGame(){
        String result = "Game Over!\nIt took you " + numOfGuesses + " guesses.";

        if(numOfGuesses <= 15){
            result += "You are awesome!!!";
        } else if(numOfGuesses <= 25) {
            result += "It's rather average.";
        } else {
            result += "You suck!";
        }

        System.out.println(result);
    }




}
