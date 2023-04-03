package LogAnal;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class LogAnalMapper  extends Mapper<LongWritable, Text, Text, Text>{
    @Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	 String[] cont = value.toString().split(",");
    	 
    	 context.write(new Text(cont[1]), new Text(cont[0]));
     }
}
