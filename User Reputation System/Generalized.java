import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Generalized{

	private static final String FILENAME = "test.txt";
	private static final String RULEA = "ruleseta.txt";
	private static final String RULEB = "rulesetb.txt";
	private static final String FILENAME1 = "test_res.txt";

	public static void main(String[] args) 
	{

		BufferedReader br = null, br1 = null;
		FileReader fr = null;
        BufferedWriter bw = null, bw1 = null;
        FileWriter fw = null, fw1 = null;
	
		try 
		{

			fw = new FileWriter(FILENAME1,false);
			bw = new BufferedWriter(fw);
			br = new BufferedReader(new FileReader(FILENAME));
			br1 = new BufferedReader(new FileReader(RULEB));
			fw1 = new FileWriter(RULEA);
			bw1 = new BufferedWriter(fw1);
			int cpu=0,x,k=0;
            double mem=0.0;
            String clas, sCurrentLine=null, line;
            String[] str,str1=null;

            int i=0;
            double arr[]=new double[12];
            fr=new FileReader(RULEB);
            int c=fr.read();
                        
            while((line=br1.readLine())!=null)
			{
            
            	arr[i]=Double.parseDouble(line);
            	System.out.println(arr[i]);
            	
				bw1.write(line); //writing rulesb to a
				i++;
            
            }
            
            
			double r=4;
			int j=3;
			int index[]=new int[4];
			while(r>0)
			{
				for(i=0;i<12;i++)
				{
					if(arr[i]==r)
					{
						break;
					}
				}
 	   		 	   	index[j]=i;
			j--;
			r--;
 	   	}

		for(i=0;i<4;i++)
		{
 	   		System.out.println(index[i]);
 	   	} 	   	
        while ((sCurrentLine = br.readLine()) != null) 
		{
			x=0;
	    
			str=sCurrentLine.split(",");
            for(String s : str)
			{
				k++;
                x=x+1;
                if(x==1)
				cpu=Integer.parseInt(s);
				else if(x==2)
				mem=Double.parseDouble(s);
 	   	
				if(k%2==0)
				{
					if(cpu>arr[index[3]-2] && mem>arr[index[3]-1])
					{ //rule4
						bw.write(cpu+","+mem+",A\n");
					}		
					else if(cpu>arr[index[2]-2] && (mem<arr[index[2]-1] || mem<arr[index[2]-1]))
					{
						bw.write(cpu+","+mem+",B\n");
					}
					else if((cpu<arr[index[1]-2] || cpu==arr[index[1]-1]) && mem>arr[index[1]-1])
					{
						bw.write(cpu+","+mem+",C\n");
					}
					else if((cpu<arr[index[0]-2] || cpu==arr[index[0]-2]) && (mem<arr[index[0]-1] || mem==arr[index[0]-1]))
					{
						bw.write(cpu+","+mem+",D\n");
					}
				}
			}
			r--;
		}
	
	
		} //try
       
		catch (IOException e) 
		{
			e.printStackTrace();

		} finally 
		{
			try 
			{

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				
				if (bw != null)
					bw.close();
				
				if (fw != null)
					fw.close();

			} catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
