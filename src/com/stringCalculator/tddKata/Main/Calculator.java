package com.stringCalculator.tddKata.Main;

import java.util.regex.Pattern;

public class Calculator
{
    int sum=0;

    public int Add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else
        {
            numbers=numbers.replaceAll(" ","");
            String[] arr=numbers.split(",");
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
        for (String number : numbers) {
            if(isNumeric(number))
                sum+=Integer.parseInt(number);
        }
        return sum;
    }
}
