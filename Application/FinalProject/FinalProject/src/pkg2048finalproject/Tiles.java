/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048finalproject;
import javax.swing.JLabel;
/**
 *
 * @author George-Kirollos Saad
 * Date: August 21, 2018
 * This Tiles class is used to create tile objects that store a value, can
 * generate a random location to place a new tile, and can determine the colour of a tile.
 *
 */
public class Tiles {
    int intValue;
    
    //Constructor to create a tile
    public Tiles(){
        intValue = 0;
    }
    
    /**
     * Stores the tile value in the intValue property variable.
     * @param intVal as an integer for the value of the tile.
     */
    public void setValue(int intVal){
        intValue = intVal;
    }
    /**
     * 
     * @return the value of the tile as an integer.
     */
    public int getValue(){
        return intValue;
    }
    
    /**
     * Looks for a random empty spot to place a new tile.
     * @param infoArr as an array of Tiles objects.
     * @return the coordinates of the location of the new tile as an integer array.
     */
    public int [] placeNew(Tiles [][] infoArr){
        boolean isSpotFound = false;
        int [] intCoords = new int [2];
        //Checks if empty tile was found at random coordinates.
        while (!isSpotFound){
            //Generates random cooridnates.
            intCoords[0] = (int) (Math.random() * 4);
            intCoords[1] = (int) (Math.random() * 4);
            //Checks if tile is empty ant coordinates.
            if (infoArr[intCoords[0]][intCoords[1]].getValue() == 0){
                isSpotFound = true;
            }
        }
        //Returns coordinates of empty tile.
        return intCoords;
    }
    
    /**
     * Checks the tile value and based on that returns an integer denoting the colour to change to.
     * @return an integer representing the colour chosen. 
     */
    public int getColourCategory(){
        //Checks the value of the tile and accordingly return an integer.
        if (intValue == 0){
            return 5;
        }
        else if (intValue == 2){
            return 0;
        }
        else if (intValue <= 10){
            return 1;
        }
        else if (intValue <= 100){
            return 2;
        }
        else if (intValue <= 1000){
            return 3;
        }
        else {
            return 4;
        }
    }
}
