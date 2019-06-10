	import java.util.*;
	import java.lang.*;
	import java.io.*;
	class Hash
	{
		
	static long findHash(char ch[])
	{
	String s;
	long hashvalue;
	if(ch.length!=1)
	{
	s=Integer.toString((int)ch[0])+Integer.toString((int)ch[ch.length/2])+Integer.toString((int)ch[(ch.length)-1]);
	hashvalue=Integer.parseInt(s);
	}
	else
	{
	hashvalue=(int)ch[0];	
	}


	return(hashvalue);	
	}	
			
		
	}


	class StringMatch
	{
			char word[];
			long hashvalue,m,n,spurious;
			Scanner S;
			void RabinKarp(String fname)
			{
					
				File f=new File(fname);
								try{
					if(!f.exists())
				{
					throw(new Exception("File Doesnot exists"));
				}
				S=new Scanner(System.in);	
				String wordtemp;
				System.out.print("Enter text to be Search:");
			hashvalue=Hash.findHash(word=((wordtemp=S.nextLine()).toCharArray()));
				long n=word.length;	
				hashvalue=Hash.findHash(word);
				byte[] text=new byte[word.length];
		
				m=f.length();
				for(int i=0;i<=m-n;i++)
				{
					FileInputStream fis=new FileInputStream(f);
					fis.skip(i);
					fis.read(text);
					char[] temp;
					long hashText=Hash.findHash(temp=(new String(text)).toCharArray());
					if(hashText==hashvalue)
					{
						if(Arrays.equals(temp,word))
						{
							System.out.println("'"+wordtemp+"' Found at("+i+")!");
						}
						else
						{
							System.out.println("spurious hit");
							spurious++;
						}
					}
					
					fis.close();
				}
			
							System.out.println("Spurious hit:"+spurious);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
		
			}
		
	}


	class Main
	{
		public static void main(String[] a)
		{			
		StringMatch S=new StringMatch();
		System.out.print("Enter File Name with extension:");
		S.RabinKarp(new Scanner(System.in).nextLine());
		}
	}
