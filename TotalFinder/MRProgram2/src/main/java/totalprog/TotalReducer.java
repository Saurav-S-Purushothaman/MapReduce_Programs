package totalprog;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class TotalReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException{
		int count = 0;
		
		for (IntWritable val: value) {
			count++;
		}
		
		
		
		context.write(key, new IntWritable(count));
	}
}
