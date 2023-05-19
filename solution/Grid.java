package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;

public class Grid implements IGrid {

    private int[][] grid;

    public Grid() {
        grid = new int[9][9];
    }

    /**
     * Get the value of the given cell in the grid as a digit from 1-9, or 0 if the cell
     * is empty. BadCellException is thrown if the coordinates are out of range.
     *
     * @param x column number
     * @param y row number
     * @return digit from 1-9, or 0 if cell is empty
     */
    @Override
    //method for getting value from within the grid
    public int get(int x, int y) throws BadCellException {

        if (y < 0 || y > 8 || x < 0 || x > 8) throw new BadCellException(x, y);
        return grid[x][y];
    }

    /**
     * Set the value of the given cell in the grid.
     * BadCellException is thrown if the coordinates are out of range.
     *
     * @param x   column number
     * @param y   row number
     * @param val digit from 1-9, or 0 for an empty cell
     */
    @Override
    //method for setting a value to the cell as long as it is not bigger than 9 and lower than 1
    //and does not go outside the grid
    public void set(int x, int y, int val) throws BadCellException, BadDigitException {
        if (y < 0 || y > 8 || x < 0 || x > 8) throw new BadCellException(x, y);
        else if (val < 0 || val > 9) throw new IGrid.BadDigitException(val);
        grid[x][y] = val;
    }

    /**
     * Return true if the grid is valid. This means that all non-empty cells meet the following conditions:
     * 1) each digit appears only once in each row
     * 2) each digit appears only once in each column
     * 3) each digit appears only once in each 3x3 subgrid
     * Note that empty cells are not counted.
     *
     * @return true if the grid is valid.
     */
    @Override
    public boolean isValid() {
        //iterating through the grid
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    //checking for not empty cells
                    if (grid[x][y] != 0) {
                        int number = grid[x][y];
                        //checking a row and a column for duplicates
                        for (int i = 0; i < 9; i++) {
                            if (i == x || i == y) continue;
                            if (grid[x][i] == number)
                                return false;
                            if (grid[i][y] == number)
                                return false;
                        }
                        //checking the subgrids for duplicates
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        int subgridx = (x / 3)*3 + i;
                                        int subgridy = (y / 3)*3 + j;
                                        if (grid[subgridx][subgridy] == number && subgridx!=x && subgridy!=y)
                                            return false;
                                    }
                                }
                    }
                }
            }
        return true;


    }
}