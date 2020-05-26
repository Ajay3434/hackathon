package hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.JSONObject;

public class input  {
	void inp() throws Exception
	{
		File f=new File("Memory.txt");
		InputStream fis=new FileInputStream(f);
        InputStreamReader ir=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(ir);
        ArrayList<Float> ls=new ArrayList<Float>();
        int i=0;
        String bline="";
        String str="[0-9]+";
        while((bline=br.readLine())!=null)
        {
         i++;
         if(i%2==0)
         {
        	 StringTokenizer st=new StringTokenizer(bline,": ");
        	 while(st.hasMoreTokens())
        	 {
        		 String tok=st.nextToken();
        		 if(tok.matches(str))
        		 {
        			 float val=Float.parseFloat(tok);
        			 if(val!=0)
        			 {
        				 val=val/1000;
        				 ls.add(val);
        			 }
        		 }
        	 }
         }
        }
       float avg;
       float sum=0;
       float max=0;
       float maxsum=0;
       for(float x:ls)
       {
    	   max=x;
    	   sum=sum+x;
    	   if(maxsum<max)
    	   {
    		   maxsum=max;
    	   }
       }
       avg=sum/ls.size();
       System.out.println("{");
       System.out.print("\n\"AverageMemory(MB)\":");
       System.out.printf("%.2f",avg);
       System.out.println("\"values\":{");
       i=0;
      for(float x: ls)
      {
    	  i++;
    	  System.out.print("\t\""+i+"s\":");
    	  System.out.printf("%.2f,\n",x);
      }
      System.out.println("},");
      System.out.print("\n\"MaxMemory(MB)\":");
      System.out.printf("%.2f,\n",maxsum);
      System.out.println("}");
      File f2=new File("OUTPUT.txt");
      OutputStream fos=new FileOutputStream(f2);
      PrintStream ps=new PrintStream(fos);

      ps.println("{");
      ps.print("\n\"AverageMemory(MB)\":");
      ps.printf("%.2f",avg);
      ps.println("\"values\":{");
      i=0;
     for(float x: ls)
     {
   	  i++;
   	  ps.print("\t\""+i+"s\":");
   	  ps.printf("%.2f,\n",x);
     }
     ps.println("},");
     ps.print("\n\"MaxMemory(MB)\":");
     ps.printf("%.2f,\n",maxsum);
     ps.println("}");
	}
}
