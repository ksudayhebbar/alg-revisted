package com.alg.rev.tower;

import java.util.Stack;

public class Tower
{

    private Stack<Integer> tower;
    private int index = 0;

    public Tower(int index)
    {
        this.index = index;
        tower = new Stack<Integer>();
    }

    public int getIndex()
    {
        return index;
    }

    public void moveTop(Tower dest)
    {
        if (!tower.isEmpty())
        {

            dest.addTop(tower.pop());
        }
    }

    public void addTop(int item)
    {

        if (!this.tower.isEmpty() && this.tower.peek() <= item)
        {
            System.out.println("invalid Item");

        } else
        {
            this.tower.push(item);
        }

    }

    public void move(int n, Tower destination, Tower buffer)
    {

        if (n > 0)
        {

            this.move(n - 1, buffer, destination);
            moveTop(destination);
            buffer.move(n - 1, destination, this);

        }
    }

    public static void main(String[] args)
    {

        Tower[] tower =
        { new Tower(3), new Tower(3), new Tower(3) };

        for (int i = 3; i > 0; i--)
        {
            tower[0].addTop(i);
        }

        tower[0].move(3, tower[2], tower[1]);
    }
}
