package com.algorithm;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMinPriorityQueue()
    {
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        minQ.add(4);
        minQ.add(3);
        minQ.add(6);
        minQ.add(1);

        assertEquals(4, minQ.size());
        assertEquals(new Integer(1), minQ.poll());
        assertEquals(new Integer(3), minQ.peek());
        assertEquals(new Integer(3), minQ.poll());
    }

    public void testMaxPriorityQueue()
    {
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if(x>y) return -1;
                if(x.equals(y)) return 0;
                return 1;
            }
        });

        maxQ.add(4);
        maxQ.add(3);
        maxQ.add(6);
        maxQ.add(1);

        assertEquals(4, maxQ.size());
        assertEquals(new Integer(6), maxQ.poll());
        assertEquals(new Integer(4), maxQ.peek());
        assertEquals(new Integer(4), maxQ.poll());
    }

    public void testPollfromEmptyQueue() {
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        assertEquals(null, min.peek());
    }

    public void testOneNum() {
        MediaMaintenance mm = new MediaMaintenance();
        mm.add(1);
        assertEquals(new Integer(1), mm.peekMedian());
    }

    public void testMedian() {
        MediaMaintenance mm = new MediaMaintenance();
        mm.add(2);
        mm.add(1);
        mm.add(3);
        mm.add(0);
        assertEquals(new Integer(1), mm.peekMedian());
    }

    /*
        3
        7
        4
        1
        2
        6
        5
        [3, 3, 4, 3, 3, 3, 4]

     */

    public void testForumCase1() {
        MediaMaintenance mm = new MediaMaintenance();
        mm.add(3);
        assertEquals(new Integer(3), mm.peekMedian());
        mm.add(7);
        assertEquals(new Integer(3), mm.peekMedian());
        mm.add(4);
        assertEquals(new Integer(4), mm.peekMedian());
        mm.add(1);
        assertEquals(new Integer(3), mm.peekMedian());
        mm.add(2);
        assertEquals(new Integer(3), mm.peekMedian());
        mm.add(6);
        assertEquals(new Integer(3), mm.peekMedian());
        mm.add(5);
        assertEquals(new Integer(4), mm.peekMedian());

        List<Integer> medians = mm.getMedians();
        assertArrayEquals(medians.toArray(new Integer[] {}), new Integer[] {3,3,4,3,3,3,4});
    }

}
