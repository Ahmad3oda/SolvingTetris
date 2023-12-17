/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MakeASquareProject;

/**
 *
 * @author Ouda
 */
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadQuery implements Runnable{

    Grid tetris;
    static ShapeL shapeL = new ShapeL();
    static ShapeZ shapeZ = new ShapeZ();
    static ShapeS shapeS = new ShapeS();
    static ShapeT shapeT = new ShapeT();
    static ShapeI shapeI = new ShapeI();
    static ShapeO shapeO = new ShapeO();
    private ReentrantLock lock = new ReentrantLock();
    
    public ThreadQuery(Grid tetris){
        this.tetris = tetris;
    }

    @Override
    public void run(){
        threading();
    }

    public void threading(){
        // base case
        if (tetris.checkSuccess())
            return;

        // transition

        // iterate within combinations of L letter
        for(ArrayList<Pair> arrayList : shapeL.positionCombinations){
            if(!tetris.checkForInstances('l'))
                break;
            if(tetris.checkForSpace(arrayList, 'l')){
                tetris.setInGrid(arrayList,'l');
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 'l');
            }
        }

        // iterate within combinations of Z letter
        for(ArrayList<Pair> arrayList : shapeZ.positionCombinations){
            if(!tetris.checkForInstances('z'))
                break;
            if(tetris.checkForSpace(arrayList, 'z')){
                tetris.setInGrid(arrayList,'z');
                //threading();
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 'z');
            }
        }

        // iterate within combinations of S letter
        for(ArrayList<Pair> arrayList : shapeS.positionCombinations){
            if(!tetris.checkForInstances('s'))
                break;
            if(tetris.checkForSpace(arrayList, 's')){
                tetris.setInGrid(arrayList,'s');
                //threading();
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 's');
            }

        }

        // iterate within combinations of T letter
        for(ArrayList<Pair> arrayList : shapeT.positionCombinations){
            if(!tetris.checkForInstances('t'))
                break;
            if(tetris.checkForSpace(arrayList, 't')){
                tetris.setInGrid(arrayList,'t');
                //threading();
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 't');
            }

        }
        
        // iterate within combinations of I letter
        for(ArrayList<Pair> arrayList : shapeI.positionCombinations){
            if(!tetris.checkForInstances('i'))
                break;
            if(tetris.checkForSpace(arrayList, 'i')){
                tetris.setInGrid(arrayList,'i');
                //threading();
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 'i');
            }

        }
        
        // iterate within combinations of O letter
        for(ArrayList<Pair> arrayList : shapeO.positionCombinations){
            if(!tetris.checkForInstances('o'))
                break;
            if(tetris.checkForSpace(arrayList, 'o')){
                tetris.setInGrid(arrayList,'o');
                //threading();
                ThreadQuery threadQuery = new ThreadQuery(tetris);
                Thread thread = new Thread(threadQuery);
                thread.start();
                if(tetris.checkSuccess()) {
                    return;
                }
                tetris.removeFromGrid(arrayList, 'o');
            }

        }
    }
}
