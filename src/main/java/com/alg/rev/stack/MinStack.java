package com.alg.rev.stack;

import java.util.EmptyStackException;

public class MinStack implements IMinStatck
{
    private Entry top = null;

    public void push(int x)
    {
        if (top == null)
        {

            top = new Entry(x, null);
        } else
        {
            Entry ele = new Entry(Math.min(x, top.getValue()), top);

            top = ele;
        }

    }

    public int pop() throws EmptyStackException
    {
        int retValue = -1;
        if (top != null)
        {
            retValue = top.getValue();

            top = top.getNext();
        } else
        {
            throw new EmptyStackException();
        }
        return retValue;
    }

    public int getMin()
    {
        int retValue = -1;
        if (top != null)
        {
            retValue = top.getValue();

        } else
        {
            throw new EmptyStackException();
        }
        return retValue;
    }

    public class Entry
    {
        private int value;

        private Entry next;

        public Entry(int value, Entry next)
        {
            super();
            this.value = value;
            this.next = next;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public Entry getNext()
        {
            return next;
        }

        public void setNext(Entry next)
        {
            this.next = next;
        }

    }

    public static void main(String[] args)
    {
        MinStack minStack=new MinStack();
        
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
       
        System.out.println("pop "+minStack.pop());
      
        
        System.out.println("Min "+minStack.getMin());
        System.out.println("pop "+ minStack.pop());
        System.out.println("Min "+ minStack.getMin());
        
         System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        

    }
}
