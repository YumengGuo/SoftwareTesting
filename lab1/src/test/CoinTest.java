package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import lab1.Coin;

public class CoinTest {
	private Coin coins;
	@Before
	public void setUp() throws Exception{
		coins = new Coin();
	}
    @Test
    public void testIsFind() {
        assertEquals("Successfully find",true,coins.findCoins(93));
        assertEquals("Successfully find",true,coins.findCoins(88));
        assertEquals("Successfully find",true,coins.findCoins(72));
        assertEquals("Successfully find",true,coins.findCoins(56));
        assertEquals("Successfully find",true,coins.findCoins(42));
        assertEquals("Successfully find",true,coins.findCoins(33));
        assertEquals("Successfully find",true,coins.findCoins(8));
        assertEquals("Cannot find",false,coins.findCoins(98));
        assertEquals("Cannot find",false,coins.findCoins(89));
        assertEquals("Cannot find",false,coins.findCoins(74));
        assertEquals("Cannot find",false,coins.findCoins(46));
        assertEquals("Cannot find",false,coins.findCoins(29));
        assertEquals("Cannot find",false,coins.findCoins(4));
    }
}
