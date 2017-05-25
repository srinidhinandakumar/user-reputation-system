import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;



public class DataPreprocess 
{
	private static String FILENAME;
    private static final String FILENAME1 = "data.csv";
	public static void main(String[] args) 
	{
	BufferedReader br = null;
	FileReader fr = null;
	BufferedWriter bw = null;
	FileWriter fw = null;
	double x=0;
        
	try {
			fw = new FileWriter(FILENAME1,true);
       		bw = new BufferedWriter(fw);
			int cpu_sum=0;
			double mem_sum=0;
			double cpu_mean,mem_mean;
              
			for(int i=2;i<=31;i++)
			{
            	for(int j=1;j<=5;j++)
				{
						if(i<10)
           				FILENAME="/home/coed/Desktop/server/vm_0"+i+j+".txt";
           				else
                        FILENAME="/home/coed/Desktop/server/vm_"+i+j+".txt";
					
						System.out.println(FILENAME);
						fr = new FileReader(FILENAME);
						br = new BufferedReader(fr);
						String sCurrentLine;
						String[] str;
                        
          				//MEAN CALCULATION
						br = new BufferedReader(new FileReader(FILENAME));
						cpu_sum=0;
						mem_sum=0;
						int count=0,k=0;
						while ((sCurrentLine = br.readLine()) != null) 
						{
							count++;
               				k=0;
                			str=sCurrentLine.split("\\s+");
                			for(String s : str)
							{
								k=k+1;
                        		if(k==1)
                    			cpu_sum=cpu_sum+Integer.parseInt(s);
								else if(k==2)
                    			mem_sum=mem_sum+Double.parseDouble(s);
           					}
						}
	    
	                    
	           			cpu_mean=cpu_sum/count;
            			mem_mean=mem_sum/count;
           
           				br.close();
            			bw.write(new decimalFormat("#.##").format(cpu_mean)+","+new DecimalFormat("#.##").format(mem_mean)+"\n");
            	}
            }
		} catch (IOException e) 
		{
			e.printStackTrace();
			
		} finally 
		{
			try {
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
