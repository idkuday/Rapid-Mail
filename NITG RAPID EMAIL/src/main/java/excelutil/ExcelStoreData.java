package excelutil;

public class ExcelStoreData {
	public String a[];
	ExcelUtil ob;
	int c,d,z;
	public int total;
	public ExcelStoreData(String path,String sheet){
		c=1;
		ob= new ExcelUtil(path, sheet);
		int x=ob.getRow();
		int y=ob.getColumn(x)-1;
		String s;
		int f=0,m=0;
		for(int i=0;i<=x;i++) {
			
			for(int j=0;j<=y;j++)
			{
				s=ob.getCellData(i, j);
				if(!(s.equals(""))) {
					f++;
					if(f==1)
					{
						z=i;
						d=j;
						a = new String[y-j];
	                    m=-1;
					}
					if(m==-1&&j<a.length)
					{
					 a[j]=s;
					}
					
//					disp();
				}		
				
					
			}
			if(m==-1)
				break;

			
		}
		total = x-c;		
	}
	void disp()
	{
		for(int p=0;p<a.length;p++)
		{
			System.out.println(a[p]);
			
		}
	}
	public String[][] student()
	{
		int x=ob.getRow();
		String arr[][]=new String[x-c][a.length];
		String s;
		for(int i=0;i<x-c;i++) {
			
			for(int j=0;j<a.length;j++)
			{
				s=ob.getCellData(i+z+1, j+d);
				arr[i][j]=s;
				
			}
			}
		return arr;
		
	}


}
