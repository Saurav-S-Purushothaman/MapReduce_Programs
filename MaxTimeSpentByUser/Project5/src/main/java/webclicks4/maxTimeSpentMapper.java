package webclicks4;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.util.HashMap;
import java.util.Map;

public class maxTimeSpentMapper extends Mapper<LongWritable, Text,Text, IntWritable>  {
	/* 
	private HashMap<Text, Integer> tmap;
	 
	    @Override
	    public void setup(Context context) throws IOException,
	                                     InterruptedException
	    {
	        tmap = new HashMap<Text,Integer>();
	    }
	    */
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException , InterruptedException{
		String[] data = value.toString().split("\t");
		String users = data[4];
		int timespent = new Integer(data[6]);
		context.write(new Text(users), new IntWritable(timespent));
		//tmap.put(new Text(users), timespent);
	/*
		if (tmap.size() > 10)
        {
            tmap.remove(tmap.firstKey());
        }
        */
		
		
	}
	/*
	@Override
    public void cleanup(Context context) throws IOException,
                                       InterruptedException
    {
        for (Map.Entry<Text,Integer> entry : tmap.entrySet())
        {
 
            Text user = entry.getKey();
            Integer timespent = entry.getValue();
 
            context.write(user, new IntWritable(timespent));
        }
    }
    */
}
