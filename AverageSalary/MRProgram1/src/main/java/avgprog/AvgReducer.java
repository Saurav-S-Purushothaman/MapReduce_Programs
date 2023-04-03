package avgprog;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class AvgReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
  
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException{
		int sum = 0;
		int count = 0; 
		
		for (IntWritable val: value) {
			count++;
			sum+= val.get();
		}
		
		int avg = sum/count;
		
		context.write(key, new IntWritable(avg));
	}
}
