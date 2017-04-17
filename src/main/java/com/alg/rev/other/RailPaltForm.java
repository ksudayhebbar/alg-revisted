package com.alg.rev.other;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RailPaltForm
{

    public static class Rail implements Comparable<Rail>
    {
        public String name;
        public Date arrivalDate;
        public Date deptDate;

        public Rail(String name, Date arrivalDate, Date deptDate)
        {
            super();
            this.name = name;
            this.arrivalDate = arrivalDate;
            this.deptDate = deptDate;
        }

        public int compareTo(Rail o)
        {
            if (this.arrivalDate.after(o.arrivalDate))
            {
                return 1;
            } else if (this.arrivalDate.equals(o.arrivalDate))
            {
                return 0;
            } else
            {
                return -1;
            }

        }

        @Override
        public String toString()
        {
            return "Rail [name=" + name + ", arrivalDate=" + arrivalDate + ", deptDate=" + deptDate + "]";
        }

    }

    public void platformChooser(List<Rail> rails)
    {

        int paltform[] = new int[8];
        int count=0;
        for (Rail r : rails)
        {
            
            

        }

    }

    public static void main(String[] args)
    {

        List<Rail> rails = new ArrayList<Rail>();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);

        Date dTime = (Date) cal.getTime();

        Rail r = new Rail("A", aTime, dTime);

        rails.add(r);

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 15);
        cal.set(Calendar.SECOND, 0);
        aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 45);
        cal.set(Calendar.SECOND, 0);

        dTime = (Date) cal.getTime();

        r = new Rail("B", aTime, dTime);

        rails.add(r);

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);

        dTime = (Date) cal.getTime();

        r = new Rail("C", aTime, dTime);

        rails.add(r);

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);

        dTime = (Date) cal.getTime();

        r = new Rail("D", aTime, dTime);

        rails.add(r);

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);

        dTime = (Date) cal.getTime();

        r = new Rail("E", aTime, dTime);

        rails.add(r);

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        aTime = (Date) cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);

        dTime = (Date) cal.getTime();

        r = new Rail("F", aTime, dTime);

        rails.add(r);

        java.util.Collections.sort(rails);

        System.out.println(rails);

    }

}
