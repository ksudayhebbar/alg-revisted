package com.alg.rev.stack;

import java.util.Stack;

public class MinStack implements IMinStatck
{
	private Stack<Integer>  st;
    private int min =Integer.MAX_VALUE;   
    /** initialize your data structure here. */
    public MinStack() {
            
      st=new Stack<Integer>();      
        
    }
    
    public void push(int x) {
          if(x<=min)  {
            st.push(min);
            min=x;
          }
          st.push(x);
    }
    
    public void pop() {
        if(st.peek()==min){
                st.pop();
                min=st.peek();
                st.pop();
        } else{
                st.pop();
        }  
         
         if(st.isEmpty()){
               min =Integer.MAX_VALUE;
         }   
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
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
        
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
       // minStack.push(2);
       // minStack.push(1);
       
        minStack.pop();
      
        
        System.out.println("Min "+minStack.getMin());
        minStack.pop();
        System.out.println("Min "+ minStack.getMin());
        
         minStack.pop();
        //System.out.println(minStack.pop());
        
        
       
    }
}
