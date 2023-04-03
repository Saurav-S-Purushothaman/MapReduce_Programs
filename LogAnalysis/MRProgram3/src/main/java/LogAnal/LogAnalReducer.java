package LogAnal;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class LogAnalReducer extends Reducer<Text,Text,Text,Text>{
   
	protected void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException {
	   
	    String result = "";
		for (Text val : value) {
		
		   result += val.toString();
		   result += ",";
	   }
		
		result = result.replaceAll(",$","");
	    
	    
	    context.write(key,  new Text(result));
   }
}
