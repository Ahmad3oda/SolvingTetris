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

public class Grid {
    static int order = 0;
    public static int [] freqOfShapes = new int[1300];
    public int [] freqCalculated = new int[1300];
    static boolean success = false, validQuery = false;
    private final ReentrantLock lock = new ReentrantLock();
    public ArrayList<int[][]> pathOfGrid = new ArrayList<>();
    public static ArrayList<int[][]> finalPathOfGrid = new ArrayList<>();
    
    // Grid of chars to facilitates the GUI process.
    public int[][] grid={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    public int[][] orderGrid={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };
    public static int[][] finalGrid={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
    };

    // gridClear, clears the final grids for multiple queries
    public void gridClear(){
        success = false;
        for(int i=0 ; i<1300 ; i++){
            freqOfShapes[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                finalGrid[i][j] = 0;
            }
        }
        pathOfGrid.clear();
    }
    
    // checkForSpace, checks for space in the grid for the given shape.
    public boolean checkForSpace (ArrayList<Pair> arrayList, int value){
        lock.lock();
        if(freqCalculated[value] == freqOfShapes[value]){
            lock.unlock();
            return false;
        }
        for(Pair pair: arrayList){
            int i = pair.x, j = pair.y;
            if(grid[i][j] != 0) {
                lock.unlock();
                return false;
            }
        }
        lock.unlock();
        return true;
    }

    // checkForInstances, checks if all queries for a certain shape is fulfilled.
    public boolean checkForInstances(int value){
        return freqCalculated[value] != freqOfShapes[value];
    }

    // setInGrid, sets a valid array of pairs after checking for a free space.
    public void setInGrid (ArrayList<Pair> arrayList, int value){
        lock.lock();
        order ++;
        for(Pair pair: arrayList){
            int i = pair.x, j = pair.y;
            grid[i][j] = value;
            orderGrid[i][j] = order;
        }
        freqCalculated[value] ++;
        int[][] tempGrid = orderGrid;
        pathOfGrid.add(tempGrid);
        lock.unlock();
    }

    // removeFromGrid, removes a previous shape that has been set in the grid.
    public void removeFromGrid (ArrayList<Pair> arrayList, int value){
        lock.lock();
        for(Pair pair: arrayList){
            int i = pair.x, j = pair.y;
            grid[i][j] = 0;
            orderGrid[i][j] = 0;
        }
        freqCalculated[value] --;
        lock.unlock();
    }

    // checkSuccess, checks if the task is fulfilled || all pieces are placed.
    public boolean checkSuccess(){
        if(success) return true;
        lock.lock();
        for (int i = 0; i < 130; i++) {
            if(freqCalculated[i] != freqOfShapes[i]){
                lock.unlock();
                return false;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(orderGrid[i][j] == 0){
                    lock.unlock();
                    return false;
                }
            }
        }
        success = true;
        Grid.finalGrid = orderGrid;
        Grid.finalPathOfGrid = pathOfGrid;
        lock.unlock();
        return true;
    }

    // printGrid.
    public synchronized void printGrid(){
        //lock.lock();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(orderGrid[i][j] + " ");
            }
            System.out.println();
        }
        //lock.unlock();
    }
    public void printFinalGrid(){
        //lock.lock();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(finalGrid[i][j] + " ");
            }
            System.out.println();
        }
        //lock.unlock();
    }
}

