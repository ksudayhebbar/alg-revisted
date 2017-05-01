package com.alg.rev.array;

import java.util.HashMap;
import java.util.Map;

public class PlaceQueen
{
    private static final int GRID_SIZE = 8;

    public void placeQueen(Map<Integer, Integer[]> queenMatrix, Integer[] columns, int row)
    {

        if (row == GRID_SIZE)
        {
            queenMatrix.put(row, columns.clone());
        } else
        {
            for (int col = 1; col <= GRID_SIZE; col++)
            {

                if (isValidColumn(columns, row, col))
                {

                    columns[row] = col;
                    placeQueen(queenMatrix, columns, row + 1);
                }
            }

        }

    }

    private boolean isValidColumn(Integer[] columns, int row, int col)
    {
        for (int row1 = 0; row1 < row; row1++)
        {
            int temCol = columns[row1];

            if (temCol == col)
                return false;
            int colDist = Math.abs(temCol - col);
            int rowDist = row1 - row;
            if (colDist == row1)
                return false;

        }
        return true;
    }

    public static void main(String[] args)
    {
        PlaceQueen placeQueen = new PlaceQueen();
        Map<Integer, Integer[]> queenMatrix = new HashMap<Integer, Integer[]>();
        Integer[] columns = new Integer[8];
        placeQueen.placeQueen(queenMatrix, columns, 0);

        System.out.println(queenMatrix);
    }

}
