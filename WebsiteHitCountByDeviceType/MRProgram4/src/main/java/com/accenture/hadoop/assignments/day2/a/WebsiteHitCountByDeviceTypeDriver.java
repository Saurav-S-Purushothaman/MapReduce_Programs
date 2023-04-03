package com.accenture.hadoop.assignments.day2.a;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WebsiteHitCountByDeviceTypeDriver {
	public static void main(String[] args) throws Exception {
		
		
		Configuration conf = new Configuration();
		// creating the job instance
		Job job = Job.getInstance(conf, "WebsiteHitCountByDeviceType");

		// set the Mapper, Reducer, Driver details to job
		job.setJarByClass(WebsiteHitCountByDeviceTypeDriver.class);
		job.setMapperClass(WebsiteHitCountByDeviceTypeMapper.class);
		job.setReducerClass( WebsiteHitCountByDeviceTypeReducer.class);
		// set the map & reduce output key,value types
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// set the file input and output paths
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// job submission
		boolean jobStatus = job.waitForCompletion(true);
		if (jobStatus == false) {
			System.exit(1);
		}
	}
	
}