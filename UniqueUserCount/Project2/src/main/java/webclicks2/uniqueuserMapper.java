package webclicks2;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class uniqueuserMapper extends Mapper<LongWritable, Text,Text, Text> {
	protected void map(LongWritable key, Text value, Context context) throws IOException , InterruptedException{
		String[] data = value.toString().split("\t");
		String users = data[4];
		String ur = data[5];
		if (data[5].contains("eyewear")) {
			String url = data[5].toString();
			context.write(new Text(url),new Text(users));
		}
		
		
	}
}
