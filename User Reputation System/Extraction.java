import java.io.*;
import java.io.FileWriter;

class Extraction
{
    public static void main(String args[])
    {
        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("cloud.r");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String string;
            //Read File Line By Line
            String str="";
            String rules="";
            
			int flag=0,len=0;
            char c='0';
            
			while ((string = br.readLine()) != null)   
			{
                if(string.isEmpty())
                continue;
                str=string.substring(0,5);
                if(str.equals("Final"))
				{
                    flag=1;
                }
                else if(str.equals("Defau"))
				{
                    flag=0;
                }
                if(flag==1)
				{
                    rules=rules+string;
                    len=rules.length();
                    c=rules.charAt(len-1);
					//System.out.println(c);
                    if((c==']')||(c==':'))
                    {   
						rules=rules+"\n";
                    }
                }

            }
            
            System.out.println(rules);

            FileWriter fw=new FileWriter("testout.txt");
            fw.write(rules);
            fw.close();
            in.close();
            fstream.close();
            
            fstream = new FileInputStream("testout.txt");
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            int count=0;
      
            int a,b=0,d,e,i,f;
            String beg="";
            String end="";
            fw=new FileWriter("rulesetb.txt");
            
            String rules1="";
            while ((string = br.readLine()) != null)   
			{
                count++;
                if(count%2==0)
                    c=string.charAt(string.length()-2);
                else if(count!=1)
				{
                    switch(c)
                    {
                        case '1':
                            a=string.indexOf('=');
                            b=string.lastIndexOf('=');
                            d=string.indexOf("memory");
                            e=string.indexOf('-');
                           // System.out.println("a="+a+"b="+b+"d="+d+"e="+e);
                            for(i=a+1;i<d;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    beg=beg+string.charAt(i);
                                }
                            }
                            System.out.println(beg);
                            
                            for(i=b+1;i<e;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    end=end+string.charAt(i);
                                }
                            }
                            System.out.println(end);
                            System.out.println(c);
                            System.out.println();
                            rules1=rules1+beg+"\n"+end+"\n"+c+"\n";
                            beg="";
                            end="";
                            
                            break;
                            
                        case '2':
                            a=string.indexOf('=');
                            b=string.indexOf('>');
                            d=string.indexOf("memory");
                            e=string.indexOf('-');
                            
                            for(i=a+1;i<d;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    beg=beg+string.charAt(i);
                                }
                            }
                            System.out.println(beg);
                            
                            for(i=b+1;i<e;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    end=end+string.charAt(i);
                                }
                            }
                            System.out.println(end);
                            System.out.println(c);
                            System.out.println();
                            rules1=rules1+beg+"\n"+end+"\n"+c+"\n";

                            beg="";
                            end="";
                            
                            break;
                            
                        case '3':
                            a=string.indexOf('>');
                            b=string.indexOf('=');
                            d=string.indexOf("memory");
                            e=string.indexOf('-');
                            
                            for(i=a+1;i<d;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    beg=beg+string.charAt(i);
                                }
                            }
                            System.out.println(beg);
                            
                            for(i=b+1;i<e;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    end=end+string.charAt(i);
                                }
                            }
                            System.out.println(end);
                            System.out.println(c);
                            System.out.println();
                            rules1=rules1+beg+"\n"+end+"\n"+c+"\n";

                            beg="";
                            end="";
                            
                            break;
                            
                        case '4':
                            a=string.indexOf('>');
                            f=string.lastIndexOf('>');
                           // b=string.indexOf('=');
                            d=string.indexOf("memory");
                            e=string.indexOf('-');
                            for(i=a+1;i<f-1;i++)
                            {
                                if(string.charAt(i)=='>')
                                {   b=i;
                                    break;
                                }
                            }
                            
                           
                            for(i=a+1;i<d;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    beg=beg+string.charAt(i);
                                }
                            }
                            System.out.println(beg);
                            
                            for(i=b+1;i<e;i++)
							{
                                if((string.charAt(i)!=' ') && (string.charAt(i)!='\t'))
								{
                                    end=end+string.charAt(i);
                                }
                            }
                            System.out.println(end);
                            System.out.println(c);
                            System.out.println();
                            rules1=rules1+beg+"\n"+end+"\n"+c+"\n";

                            beg="";
                            end="";
                            
                            break;
                            
                        default: System.out.println("Invalid.");
                    }
                }
                
            }

            fw.write(rules1);
            fw.close();
            
           
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        
    }
}
