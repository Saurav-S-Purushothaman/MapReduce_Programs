package webclicks4;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class maxTimespentDriver {
public static void main(String[] args)throws IOException ,ClassNotFoundException, InterruptedException{
		
		Configuration conf = new Configuration();
		  
		  
		  Job job = Job.getInstance(conf,"WebclicksProg");
		  job.setJarByClass(maxTimespentDriver.class);
		  
		 
		  job.setMapperClass(maxTimeSpentMapper.class);
		  job.setReducerClass(maxTimespentReducer.class);
		  
		  //output of mapper class
		  job.setMapOutputKeyClass(Text.class);
		  job.setMapOutputValueClass(IntWritable.class);
		  
		  //output of reducer or entire job
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
