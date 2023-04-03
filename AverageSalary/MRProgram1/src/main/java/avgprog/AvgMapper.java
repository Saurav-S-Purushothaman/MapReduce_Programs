package avgprog;

//import statement for all type
import java.io.IOException;
import org.apache.hadoop.io.*;

//import the parent class named Mapper to extend
import org.apache.hadoop.mapreduce.Mapper;

public class AvgMapper extends Mapper<LongWritable, Text,Text, IntWritable>{

	
	protected void map(LongWritable key, Text value, Context context) throws IOException , InterruptedException{
		//value.toString - convert text into String
		//value.toString.split() to split according to delimiter ,
		//string[] emp is string array named emp for storing the splitted data
		String[] emp = value.toString().split(",");
		//convert String inot integer object
		
		
		String empno = new String(emp[0]);
		if(empno.startsWith("1")) {
			Integer salary = new Integer(emp[4]);
		//new Text is used to write the string into a text
		// new IntWritable used to write the INteger int Intwritable
		context.write(new Text(emp[6]),new IntWritable(salary));
		}
	}
}
