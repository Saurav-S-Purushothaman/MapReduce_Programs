package com.accenture.hadoop.assignments.day2.a;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WebsiteHitCountByDeviceTypeMapper extends Mapper<Object, Text, Text, IntWritable>{
    protected void map(Object key, Text value, Context context)throws IOException, InterruptedException {
		
    	String[] webclicks = value.toString().split("\t");
    	Integer val = Integer.parseInt(webclicks[5]);
    	
		context.write(new Text(webclicks[7]),new IntWritable(val));
	}
}
