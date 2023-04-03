package webclicks4;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class maxTimespentReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
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
	
		for (IntWritable val: value) {
			sum += val.get();
		}
		   tmap2.put(key, sum);
		
		
	}
	@Override
    public void cleanup(Context context) throws IOException,
                                       InterruptedException
    {
		/*
		 for (Map.Entry<String, Integer> entry : tmap2.entrySet())
	        {
	 
	            String c = entry.getKey();
	            Integer name = entry.getValue();
	            String max = tmap2.values().stream().max(Integer::compare).get();
	            context.write(new (count), new Text(name));
	        }
	        */
		
		Map.Entry<Text, Integer> maxEntry = null;
        for (Map.Entry<Text, Integer> entry : tmap2.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
		context.write(maxEntry.getKey(), new IntWritable(maxEntry.getValue()));
        }
    }

