package webclicks;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class webclicksMapper extends Mapper<LongWritable, Text,Text, Text> {
	protected void map(LongWritable key, Text value, Context context) throws IOException , InterruptedException{
		String[] data = value.toString().split(",");
		String user = data[0];
		String country = data[1];
		context.write(new Text(country),new Text(user));
		
	}
	
}
