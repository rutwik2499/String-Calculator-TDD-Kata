package com.stringCalculator.tddKata.Test;
import com.stringCalculator.tddKata.Main.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator_Test
{
    Calculator m1=new Calculator();

    @Test
    public void testEmptyString()
    {
        assertEquals(0,m1.Add(""));
    }

    @Test
    public void testSingleNumberString()
    {
        assertEquals(5,m1.Add("5"));
    }

    @Test
    public void testTwoNumbersString()
    {
        assertEquals(12,m1.Add("5,7"));
    }

    @Test
    public void testMultiNumbersString()
    {
        assertEquals(250,m1.Add("10, 50, 90, 100"));
    }

    @Test
    public void testHandleNewLines()
    {
        assertEquals(6,m1.Add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimitersString()
    {
        assertEquals(3,m1.Add("//;\n1;2"));
        assertEquals(12,m1.Add("//;\n2;10"));
    }

    @Test
    public void testNegativeNumbersString()
    {
        try
        {
            m1.Add("-1,2,3,-5");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Negatives Not Allowed: [-1, -5]",e.getMessage());
        }
    }

    @Test
    public void testIgnoreNumbersMoreThanThousand()
    {
        assertEquals(3,m1.Add("1,2,1005"));
        assertEquals(12,m1.Add("//;\n2;10;1008"));

    }

    @Test
    public void testDelimitersOfAnyLength()
    {
        assertEquals(6,m1.Add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimitersOfAnyLength()
    {
        assertEquals(6,m1.Add("//[*][%]\n1*2%3"));
        assertEquals(16,m1.Add("//[***][+++][%%%]\n1***2***3+++5%%%5"));
    }
}
