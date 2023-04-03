package avgprog;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class AvgDriver {
  public static void main(String[] args)throws IOException ,ClassNotFoundException, InterruptedException{
	  
	  Configuration conf = new Configuration();
	  
	  //create job instance and setjavbyclass is the entry point of MR job execution
	  Job job = Job.getInstance(conf,"AvgProg");
	  job.setJarByClass(AvgDriver.class);
	  
	  //invode the mapper and reducer class
	  job.setMapperClass(AvgMapper.class);
	  job.setReducerClass(AvgReducer.class);
	  
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
