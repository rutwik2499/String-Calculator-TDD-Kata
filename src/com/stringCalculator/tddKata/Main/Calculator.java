package com.stringCalculator.tddKata.Main;

public class Calculator
{
    public int Add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.length()==1)
        {
            return Integer.parseInt(numbers);
        }
        else
        {
            return -1;
        }
    }
}
