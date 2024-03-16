package webclicks5;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class minTimeReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	 private HashMap<Text, Integer> tmap2;
	    @Override
	    public void setup(Context context) throws IOException,
	                                     InterruptedException
	    {
	        tmap2 = new HashMap<Text,Integer>();
	    }
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException{
	    int sum = 0;
            // this gets the value
		for (IntWritable val: value) {
			sum += val.get();
		}
		   tmap2.put(key, sum);

	}
	@Override
    public void cleanup(Context context) throws IOException,
                                       InterruptedException
    {
		Map.Entry<Text, Integer> minEntry = null;
        for (Map.Entry<Text, Integer> entry : tmap2.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }
		context.write(minEntry.getKey(), new IntWritable(minEntry.getValue()));
        }
    }
