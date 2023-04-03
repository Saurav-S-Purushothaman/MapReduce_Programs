package totalprog;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class TotalMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
	protected void map(LongWritable key, Text value, Context context) throws IOException , InterruptedException{
		
		String[] emp = value.toString().split(",");

		
		
		String empno = new String(emp[0]);
		if(empno.startsWith("1")) {
			Integer empid = new Integer(emp[0]);
		
		context.write(new Text(emp[5]),new IntWritable(empid));
		}
	}
}
