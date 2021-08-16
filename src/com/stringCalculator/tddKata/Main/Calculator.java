package com.stringCalculator.tddKata.Main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator
{
    public int Add(String numbers)
    {
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.startsWith("//")) // Deal with strings starting with // and having 0 or more delimiters of any length.
        {
            String[] numArray=getNumbersList(numbers);
            return getSum(numArray);
        }
        else // Deal with negative numbers and (, or \n) separated numbers.
        {
            String[] NumbersArray=numbers.replaceAll(" ","").split(",|\n");

            if(containsNegative(NumbersArray)) {
                ArrayList<Integer> NegativeNumbersList=getNegativeNumbersList(NumbersArray);
                throw new IllegalArgumentException("Negatives Not Allowed: "+NegativeNumbersList);
            }
            else {
                return getSum(NumbersArray);
            }
        }
    }

    private String[] getNumbersList(String numbers) {
        String[] numArray;
        String Delimiters = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));
        String ProcessString = numbers.substring(numbers.indexOf("\n") + 1);

        if(Delimiters.contains("[") && Delimiters.contains("]")) {
            String delim="";
            Pattern pat = Pattern.compile("\\[(.*?)]");
            Matcher m = pat.matcher(Delimiters);

            while(m.find()) {
                String s = m.group(1);
                delim=delim.concat(Pattern.quote(s)+"|");
            }
            delim = delim.substring(0,delim.length()-1);
            numArray=ProcessString.split(delim);
        }
        else {
            numArray = ProcessString.split(Pattern.quote(Delimiters));
        }
        return numArray;
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
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean containsNegative(String[] NumList) {
        for (String s : NumList) {
            if (isNumeric(s) && Integer.parseInt(s) < 0)
                return true;
        }
        return false;
    }

    private ArrayList<Integer> getNegativeNumbersList(String[] numbers) {
        ArrayList<Integer> NegativeNumbersList=new ArrayList<>();
        for (String number : numbers) {
            if (isNumeric(number) && Integer.parseInt(number) < 0) {
                NegativeNumbersList.add(Integer.parseInt(number));
            }
        }
        return NegativeNumbersList;
    }
}
