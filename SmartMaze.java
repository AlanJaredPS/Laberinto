/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto1;

/**
 *
 * @author Jorge
 */
public class SmartMaze {
    private int[][] grid;
    private int[][] exit;
    private LaberintoGUI lGUI;
    
    public SmartMaze(int[][] grid, int [][] exit) {
        this.grid = grid;
        this.exit = exit;
    }

    public void setGUI(LaberintoGUI lGUI){
        this.lGUI = lGUI;
    }
    
    public int[][] getGrid(){
        return grid;
    }
    
    public boolean traverse(int row, int column) {
        boolean done = false;

        if (valid(row, column)) {
            lGUI.paint(lGUI.getPanel().getGraphics());
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            grid[row][column] = 3;            // this cell has been tried
            if (isCurrentAnExit(row, column)) // if current position is an exit
                done = true;                  // the maze is solved
            else{
                done = traverse(row + 1, column);             // down
                if (!done)  done = traverse(row - 1, column); // up 
                if (!done)  done = traverse(row, column + 1); // right
                if (!done)  done = traverse(row, column - 1); // left                 
            }
            if (done)                       // the location is part of the final path
                grid[row][column] = 2;            
        }
        return done;
    }

    /**
     * Determines if a specific location is valid.
     *
     * @param row the column to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    private boolean valid(int row, int column) {
        boolean result = false;
        //- check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) 
         //- check if cell is not blocked and not previously tried
            if (grid[row][column] == 0 || grid[row][column] == 2)
                result = true;
        return result;
    }

    private boolean isCurrentAnExit(int row, int col){
        for(int i = 0; i < exit.length; i++)
            for(int j = 0; j < exit[i].length; j++)
                if(exit[i][0] == row && exit[i][1] == col)
                    return true;
        return false;        
    }
    
    /**
     * Devuelve la rejilla del laberinto como un String
     *
     * @return una representación como string del laberinto
     */
    public String toString() {
        String result = "\n";
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                result += grid[row][column] + "  ";
            result += "\n";
        }
        return result;
    }
}