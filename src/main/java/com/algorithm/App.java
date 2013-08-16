package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Maintenance median ..." );

        if(args.length < 1) {
            System.out.println("please specify the data file.");
            System.exit(-1);
        }

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        MediaMaintenance mm = new MediaMaintenance();

        try {
            String line = reader.readLine();

            while(line != null) {
               Integer num = Integer.parseInt(line);
               mm.add(num);
               line = reader.readLine();
            }

        } finally {
            reader.close();
        }

        List<Integer> medians = mm.getMedians();
        Iterator<Integer> integerIterator = medians.iterator();
        Long sum = 0L;
        while(integerIterator.hasNext()) {
            sum += integerIterator.next();
        }

        long result = sum % 10000L;

        System.out.println("the result is " + result);
    }
}
