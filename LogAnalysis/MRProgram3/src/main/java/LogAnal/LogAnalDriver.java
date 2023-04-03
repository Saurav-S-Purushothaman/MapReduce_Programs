package LogAnal;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.Path;


public class LogAnalDriver {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
           Configuration conf = new Configuration();
           
           Job job = Job.getInstance(conf,"LogAnal");
           
           job.setJarByClass(LogAnalDriver.class);
           
           job.setMapperClass(LogAnalMapper.class);
           job.setReducerClass(LogAnalReducer.class);
           
           job.setMapOutputKeyClass(Text.class);
           job.setMapOutputValueClass(Text.class);
           
           job.setOutputKeyClass(Text.class);
           job.setOutputValueClass(Text.class);
           
           FileInputFormat.addInputPath(job, new Path(args[0]));
           FileOutputFormat.setOutputPath(job, new Path(args[1]));
           
           boolean jobStatus = job.waitForCompletion(true);
           if (jobStatus == false) {
        	   System.exit(1);
           }
	}
}
