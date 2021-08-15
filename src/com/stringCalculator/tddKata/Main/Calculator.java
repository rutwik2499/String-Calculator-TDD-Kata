package com.stringCalculator.tddKata.Main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator
{
    public int Add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.startsWith("//"))
        {
            String Delimiters = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));
            String ProcessString = numbers.substring(numbers.indexOf("\n") + 1);

            if(Delimiters.contains("[") && Delimiters.contains("]"))
            {
                String delim="";
                Pattern pat = Pattern.compile("\\[(.*?)\\]");
                Matcher m = pat.matcher(Delimiters);
                while(m.find())
                {
                    String s = m.group(1);
                    delim+=Pattern.quote(s)+"|";
                }
                delim = delim.substring(0,delim.length()-1);
                String[] numArray=ProcessString.split(delim);
                return getSum(numArray);
            }
            else
            {
                String[] arr = ProcessString.split(Pattern.quote(Delimiters));
                return getSum(arr);
            }
        }
        else
        {
            ArrayList<Integer> NegativeNumbersList;
            String num=numbers.replaceAll(" ","");
            String[] NumbersArray=num.split(",|\n");

            if(containsNegative(NumbersArray))
            {
                NegativeNumbersList=getNegativeNumbersList(NumbersArray);
                throw new IllegalArgumentException("Negatives Not Allowed: "+NegativeNumbersList);
            }
            else
            {
                return getSum(NumbersArray);
            }
        }
    }

    private int getSum(String[] numbers)
    {
        int sum=0;
        for (String number : numbers) {
            if (isNumeric(number) && Integer.parseInt(number)<=1000)
                sum += Integer.parseInt(number);
        }
        return sum;
    }

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean containsNegative(String[] NumList)
    {
        boolean flag=false;
        for (String s : NumList) {
            if (Integer.parseInt(s) < 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private ArrayList<Integer> getNegativeNumbersList(String[] numbers)
    {
        ArrayList<Integer> NegativeNumbersList=new ArrayList<>();
        for (String number : numbers) {
            if (isNumeric(number) && Integer.parseInt(number) < 0) {
                NegativeNumbersList.add(Integer.parseInt(number));
            }
        }
        return NegativeNumbersList;
    }
}
