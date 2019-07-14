package com.alg.rev.string;

import java.util.ArrayList;
import java.util.List;

public class Permuation
{

    public List<String> getPerm(String word)
    {

        if (word == null)
        {
            return null;
        }
        List<String> permuation = new ArrayList<String>();
        if (word.length() == 0)
        {
            permuation.add(word);
            return permuation;
        }

        Character fChar = word.charAt(0);
        String reminder = word.substring(1);
      
        List<String> words = getPerm(reminder);
        for (String w : words)

            for (int j = 0; j <= w.length(); j++)
            {

                String retStr = insertChar(fChar, w, j);
                permuation.add(retStr);
            }

        return permuation;
    }

    private String insertChar(Character fChar, String word, int j)
    {
        String first = word.substring(0, j);
        String end = word.substring(j);
        return first + fChar + end;
    }

    public static void main(String[] args)
    {
        Permuation permuation1 = new Permuation();
        //System.out.println(permuation1.getPerm("ABC"));
       permuation1.permuation("", "as");
    }

    public void permuation(String prefix, String input)
    {

        if (input != null && input.length() == 0)
        {
            System.out.println(prefix);
        } else
        {

            for (int i = 0; i < input.length(); i++)
            {
                permuation(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));

            }

        }

    }
    
    
    

}
