package com.alg.rev.other;

public class Multipication
{
    public static void main(String args[])
    {

        System.out.println(Multipication.multiply(15, 4));
        
        System.out.println(Multipication.divsion(15, 4));

    }

    public static int multiply(int row, int col)
    {
        if (row == 0 || col == 0)
            return 0;

        if (row > col)
        {
            int tempRow = row;
            row = col;
            col = tempRow;
        }

        int result = 0;
        boolean flag = true;
        if (row % 2 != 0)
        {
            flag = false;
        }

        for (int r = 0; r < row / 2; r++)        {

            result += col;

        }

        if (flag)
        {
            result += result;
        } else
        {
            result += result + col;
        }

        return result;

    }
    
    
    public static int divsion(int row, int col)
    {
        if (row == 0 || col == 0)
            return 0;

        if (row > col)
        {
            int tempRow = row;
            row = col;
            col = tempRow;
        }

        int result = col;
        boolean flag = true;
        if (col % 2 != 0)
        {
            flag = false;
        }

        for (int r = 0; r < row / 2; r++)
        {

            result -= row;

        }

        
            result = result -row;
     

        return result;

    }


}
