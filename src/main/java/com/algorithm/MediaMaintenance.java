package com.algorithm;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-15
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class MediaMaintenance {

    private PriorityQueue<Integer> maxQ;
    private PriorityQueue<Integer> minQ;
    private ArrayList<Integer> medians;

    public MediaMaintenance()  {

       maxQ = new PriorityQueue<Integer>();
       minQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if(x>y) return -1;
                if(x.equals(y)) return 0;
                return 1;
            }
        });

        medians = new ArrayList<Integer>();
    }

    public void add(Integer num) {
        Integer max = minQ.peek();
        Integer min = maxQ.peek();

        if(max != null && num > max) {
            maxQ.add(num);
        } else if( min != null && num < min){
            minQ.add(num);
        } else {
            minQ.add(num);
        }

        while(minQ.size() - maxQ.size() > 1) {
            maxQ.add(minQ.poll());
        }

        while(maxQ.size() - minQ.size() > 1) {
            minQ.add(maxQ.poll());
        }

        //adjust 2 heaps.
        medians.add(peekMedian());
    }

    public Integer peekMedian() {
        int sizeMax = maxQ.size();
        int sizeMin = minQ.size();

        if(sizeMax == sizeMin) {
            return minQ.peek();
        } else if (sizeMin > sizeMax) {
            return minQ.peek();
        }
        return maxQ.peek();
    }

    public List<Integer> getMedians() {
        return medians;
    }
}
