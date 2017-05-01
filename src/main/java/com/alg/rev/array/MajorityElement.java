package com.alg.rev.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement
{

    public static List<Integer> majorityElement(int num[])
    {

        Map<Integer, Integer> majorityEle = new HashMap<Integer, Integer>();

        for (int ele : num)
        {

            if (majorityEle.containsKey(ele))
            {
                majorityEle.put(ele, majorityEle.get(ele) + 1);
            } else
            {
                majorityEle.put(ele, 1);
            }

        }
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> ele : majorityEle.entrySet())
        {

            if (ele.getValue() > num.length / 3)
            {
                result.add(ele.getKey());
            }

        }
        return result;
    }

}
