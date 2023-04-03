package totalprog;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class TotalDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		  
		
		  Job job = Job.getInstance(conf,"TotalProg");
		  job.setJarByClass(TotalDriver.class);
		  
		 
		  
		  job.setMapperClass(TotalMapper.class);
		  job.setReducerClass(TotalReducer.class);
		  

		  job.setMapOutputKeyClass(Text.class);
		  job.setMapOutputValueClass(IntWritable.class);
		  
	
		  job.setOutputKeyClass(Text.class);
		  job.setOutputValueClass(IntWritable.class);
		  
		  FileInputFormat.addInputPath(job, new Path(args[0]));
		  FileOutputFormat.setOutputPath(job, new Path(args[1]));

	      boolean jobStatus = job.waitForCompletion(true);
	      if (jobStatus == false) {
	    	  System.exit(1);
	      }

	}

}
