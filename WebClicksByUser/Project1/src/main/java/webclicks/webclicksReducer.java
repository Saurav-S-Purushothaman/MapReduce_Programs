package webclicks;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;

public class webclicksReducer extends Reducer<Text, Text, Text, IntWritable>  {
	protected void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException{
		
		int count = 0; 
		
		for (Text val: value) {
			count++;
		}
			
		context.write(key, new IntWritable(count));
	}

}
