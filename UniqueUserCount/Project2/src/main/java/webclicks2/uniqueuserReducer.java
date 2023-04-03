package webclicks2;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import java.util.ArrayList;


import java.io.IOException;

public class uniqueuserReducer extends Reducer<Text, Text, Text, IntWritable> {
protected void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException{
		ArrayList<String> arr = new ArrayList<String>();
	
		for (Text val: value) {
			if(!arr.contains(val.toString()))
			arr.add(val.toString());
		}
		int count = arr.size();
			
		context.write(key, new IntWritable(count));
	}

}
