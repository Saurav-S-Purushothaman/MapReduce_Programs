package webclicks3;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


import java.io.IOException;


public class timespentReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException{
	    int sum = 0;
	
		for (IntWritable val: value) {
			sum += val.get();
		}
		
		context.write(key, new IntWritable(sum));
	}
	/*
	 @Override
	    public void cleanup(Context context) throws IOException,
	                                       InterruptedException
	    {
		 
		 int max = 0;
		 for (IntWritable val:value) {
			 if (val.get()>max) {
				 max = val.get();
			 }
		 }
		 context.write(key, IntWritable(max));
	        
	    }*/
}
