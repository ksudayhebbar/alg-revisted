package com.alg.rev.array;

public class BullsAndCows
{

    public static String getHint(String secret, String guess)
    {
        if (secret == null || guess == null)
            return "";
        if (guess.length() != secret.length())
        {
            return "Guess char length is diffrent";
        }       
        int bullCount = 0;
        for (int i = 0; i < secret.length(); i++)
        {
            Character sChar = secret.charAt(i);
            Character gChar = guess.charAt(i);
            if (sChar.equals(gChar))
            {
                bullCount++;
            }

        }

        int cowCount = Math.abs(guess.length()-bullCount);

        

        return "B" + bullCount + "C" + cowCount;

    }
    
    public static void main(String[] args)
    {
        System.err.println(BullsAndCows.getHint("1807", "7810"));
        
        System.err.println(BullsAndCows.getHint("1807", "7719"));
        
        System.err.println(BullsAndCows.getHint("1807", "1819"));
    }
    
    
    
}
