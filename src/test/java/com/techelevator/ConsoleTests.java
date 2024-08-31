package com.techelevator;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsoleTests {


    @Test
    public void testIfNumberIsBetweenOneAndThree() {
        ConsoleService sut= new ConsoleService();
        String input="1";
        assertEquals(input,sut.inputStuffedAnimalOptions());


    }


}
