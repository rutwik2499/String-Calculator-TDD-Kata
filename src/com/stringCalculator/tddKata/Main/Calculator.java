package com.stringCalculator.tddKata.Main;

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
            int sum=0;
            String delimiter=Character.toString(numbers.charAt(2));
            String num=numbers.substring(4);
            String[] arr=num.split(Pattern.quote(delimiter));
            return getSum(arr);
        }
        else
        {
            numbers=numbers.replaceAll(" ","");
            String[] arr=numbers.split(",|\n");
            return getSum(arr);
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
            if(isNumeric(number))
                sum+=Integer.parseInt(number);
        }
        return sum;
    }
}
