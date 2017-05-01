package com.alg.rev.array;

import java.util.List;

public class StackBoxes
{

    public class Box implements Comparable<Box>
    {

        private int hight;
        private int width;
        private int length;

        public Box(int hight, int width, int length)
        {
            super();
            this.hight = hight;
            this.width = width;
            this.length = length;
        }

        public int getHight()
        {
            return hight;
        }

        public void setHight(int hight)
        {
            this.hight = hight;
        }

        public int getWidth()
        {
            return width;
        }

        public void setWidth(int width)
        {
            this.width = width;
        }

        public int getLength()
        {
            return length;
        }

        public void setLength(int length)
        {
            this.length = length;
        }

        public int compareTo(Box o)
        {

            return this.hight - o.hight;
        }

        private int calculateArea(Box box)
        {

            return box.getHight() * box.getLength() * box.getWidth();
        }

        public boolean canPlaceAbove(Box top)
        {

            int topBox = calculateArea(top);
            int bootomBox = calculateArea(this);

            return bootomBox >= topBox ? true : false;

        }

        public int createStack(List<Box> boxes)
        {

            int maxHight = 0;
            for (int bottomIndex = 0; bottomIndex < boxes.size(); bottomIndex++)
            {
                int hight = createStack(boxes, bottomIndex);

                maxHight = Math.max(maxHight, hight);
            }

            return maxHight;

        }

        public int createStack(List<Box> boxes, int bottomIndex)
        {
            int maxHight = 0;
            Box box = boxes.get(bottomIndex);
            for (int top = bottomIndex + 1; bottomIndex < boxes.size(); top++)
            {
                if (box.canPlaceAbove(boxes.get(top)))
                {

                    maxHight += box.getHight();
                }

            }

            return maxHight;

        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
