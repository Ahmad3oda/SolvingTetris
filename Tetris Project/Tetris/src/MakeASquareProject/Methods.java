/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MakeASquareProject;

/**
 *
 * @author Ouda
 */
import java.util.*;
public class Methods {
    
    int numberOfNeededL ;
    int numberOfNeededZ ;
    int numberOfNeededS ;
    int numberOfNeededT ;
    int numberOfNeededI ;
    int numberOfNeededO ;
    Grid finalGrid = new Grid();
    
    
    public void setValues(int l, int z, int s, int t, int i, int o){
        this.numberOfNeededL = l;
        this.numberOfNeededZ = z;
        this.numberOfNeededS = s;
        this.numberOfNeededT = t;
        this.numberOfNeededI = i;
        this.numberOfNeededO = o;
    }
    
    public boolean checkArea (int L, int T, int Z, int S, int I, int O){
        int sum = L + T + Z + S + I + O;
        return sum != 4;
    }
    
    public void runProgram(){

        Methods method = new Methods();
        // validate by area
        if(method.checkArea(numberOfNeededL, numberOfNeededT, numberOfNeededZ, numberOfNeededS, numberOfNeededI, numberOfNeededO)){
            System.out.println("No solution");
            return;
        }

        // get frequency of each shape
        int [] freqOfShapes = new int[1300];
        freqOfShapes['l'] = numberOfNeededL;
        freqOfShapes['z'] = numberOfNeededZ;
        freqOfShapes['s'] = numberOfNeededS;
        freqOfShapes['t'] = numberOfNeededT;
        freqOfShapes['i'] = numberOfNeededI;
        freqOfShapes['o'] = numberOfNeededO;

        // identify the grid
        Grid tetris = new Grid();
        Grid.freqOfShapes = freqOfShapes;
        
        // Threading
        if(Grid.validQuery){
            ThreadQuery threadQuery = new ThreadQuery(tetris);
            Thread thread = new Thread(threadQuery);
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("No solution");
        }
    }    
    
    
    
    
    
    
    
    
    
    
    public boolean checkValidity (int L, int T, int Z, int S, int I, int O){
        if(L == 4 || I == 4 || O == 4 || T == 4)
            return true;
        if((L == 2 && Z == 2) || (L == 1 && T == 2 && Z == 1) || (L == 1 && T == 2 && I == 1))
            return true;
        if((I == 1 && L == 2 && O == 1) || (I == 1 && L == 2 && S == 1))
            return true;
        if((I == 2 && L == 2) || (I == 2 && O == 2) || (L == 2 && O == 2))
            return true;
        return false;
    }
}

