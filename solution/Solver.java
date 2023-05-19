package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;

public class Solver implements ISolver {
    private Grid grid;
    public Solver(IGrid g){
        grid=(Grid)g;
    }
    /**
     * The solver method - this will attempt to solve the grid set by the constructor, returning
     * a boolean if successful. It will call itself recursively to solve simpler grids (i.e. with
     * more digits filled in).
     *
     * @return true if successful
     */
    @Override
    public boolean solve() {
        //iterating through the grid
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                //checking for an empty cell
                if(grid.get(x,y)==0){
                    //checking numbers from 1 to 9 and checking for validity of the grid afterwards
                    for(int i=1; i<10; i++){
                        grid.set(x,y,i);
                        if(grid.isValid()){
                            boolean result = solve();
                            if (result) return true;
                        }
                    }
                    grid.set(x,y,0);
                    return false;
                }
            }
        }

        return true;
    }
}