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
    public void testSingleNumberString() // 1
    {
        assertEquals(5,m1.Add("5"));
    }
}
