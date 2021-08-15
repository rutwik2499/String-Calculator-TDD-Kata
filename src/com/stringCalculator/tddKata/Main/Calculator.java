package com.stringCalculator.tddKata.Main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator
{
    public int Add(String numbers)
    {
        int sum=0;

        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.startsWith("//"))
        {
            if(numbers.contains("[") && numbers.contains("]"))
            {
                String delim="";
                String num=numbers.substring(numbers.indexOf("\n")+1);
                Pattern pat = Pattern.compile("\\[(.*?)\\]");
                Matcher m = pat.matcher(numbers);

                while(m.find())
                {
                    String s = m.group(1);
                    delim+=Pattern.quote(s)+"|";
                }
                delim = delim.substring(0,delim.length()-1);
                String[] numArray=num.split(delim);
                return getSum(numArray);
            }
            else
            {
                String delimiter = Character.toString(numbers.charAt(2));
                String num = numbers.substring(4);
                String[] arr = num.split(Pattern.quote(delimiter));
                return getSum(arr);
            }
        }
        else
        {
            int NegativeCount=0;
            ArrayList<String> NegativeNumbersList=new ArrayList<>();
            numbers=numbers.replaceAll(" ","");
            String[] arr=numbers.split(",|\n");

            for(String s : arr)
            {
                if (Integer.parseInt(s) < 0)
                {
                    NegativeNumbersList.add(s);
                    NegativeCount++;
                }
                else
                {
                    if(Integer.parseInt(s)<=1000) sum += Integer.parseInt(s);
                }
            }

            if(NegativeCount>0)
            {
                throw new IllegalArgumentException("Negatives Not Allowed: "+NegativeNumbersList);
            }
            else
            {
                return sum;
            }
        }
    }

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int getSum(String[] numbers)
    {
        int sum=0;
        for (String number : numbers) {
            if(isNumeric(number) && Integer.parseInt(number)<=1000)
            {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
