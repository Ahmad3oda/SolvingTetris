/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MakeASquareProject;

/**
 *
 * @author RMDN
 */
abstract class Shape {

    abstract void generateCombinations();

    public static boolean checkBounds(int i, int j){
        return i >= 0 && i < 4 && j >= 0 && j < 4;
    }
}

