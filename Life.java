package as;

import java.util.Scanner;

public class Life {
	
	// This Program run through CLI and for end this program follow given instructions.
	Scanner sc=new Scanner(System.in);
	  
	  
	  
	Integer [][] cells;
	Integer rows;
	Integer columns;
	Integer k=1;
	  
	  public void setCells(Integer [][] cells,Integer ROWS,Integer COLUMNS)
	  {
	    this.rows=ROWS;
	    this.columns=COLUMNS;
	    this.cells=new Integer[rows][columns];
	    for(int i=0;i<ROWS;i++)
	      for(int j=0;j<COLUMNS;j++)
	      this.cells[i][j]=cells[i][j];  
	  }
	  
	  public void getCells()
	  {
	    for(int i=0;i<rows;i++)
	    {  
	      for(int j=0;j<columns;j++)
	      System.out.print(cells[i][j]);
	    
	        System.out.println();
	    }
	    System.out.println();
	  }
	  
	    public void getStates() 
	    {
	    	Integer n;
	     
	     do {
	       
	       System.out.println("===========Program Start=============");
	        System.out.println("1. Get Next State 2. Check Cell 3. EXIT ");
	        System.out.print("\t\t\tEnter choice =");
	        Integer ch=sc.nextInt();
	        
	        switch(ch)
	        {
	        case 1:gameOfLife();
	               print();
	        break;
	        case 2:gameOfLife();
	               PrintCell();
	               
	        break;
	        case 3:System.exit(0);
	        
	        break;
	        }
	        System.out.print("\t\t\tDo u want to continue press 1 oterwise 0 = ");
	         n=sc.nextInt();
	        }while(n!=0);
	    
	    }
	  
	  
	     public void  gameOfLife()
	     {
	           for (int i = 0; i < rows; i++)
	          {
	                     for (int j = 0; j < columns; j++)
	                   {
	                      int Cell = cells[i][j];
	                     n(i,j,Cell);
	                      
	                  }
	            }

	             
	     }
	     
	     public void n(int i,int j,int Cell) 
	     {
	                int count=0;
	        
	          
	              int a = i - 1;
	              int b = i + 1;
	              int c = j - 1;
	              int d = j + 1;
	              

	                 if (a >= 0 && cells[a][j]==1)
	                   count++; 
	                 
	                 if(b <rows && cells[b][j]==1)
	              
	                count++;
	                
	              
	              
	              
	              if(c >=0 && cells[i][c]==1)
	              {
	                count++;
	                
	              }
	              
	              if(d <columns && cells[i][d]==1)
	              {
	                count++;
	                
	              }
	              
	              //lower right side diagonal
	              if(j>=0 && j<columns-1 && i>=0 && i<rows-1)
	              {  
	                 if(cells[b][d]==1)
	                   count++;
	                     
	                  // grid[b][d]=5;
	              }
	              
	              //upper left side diagonal
	              if(i>0 && i<rows && j>0 && j<columns)
	              {
	                if(cells[a][c]==1)
	                  count++;
	                    
	                  //grid[a][c]=5;
	              }
	              
	              //lower left side diagonal
	              if(j>0 && j<columns && i>=0 && i<rows-1)
	              {
	                if(cells[b][c]==1)
	                  count++;
	                    
	                  //grid[b][c]=5;
	              }
	              
	              //upper side right diagonal
	              if(i>0 && i<rows && j>=0 && j<columns-1)
	              {
	                if(cells[a][d]==1)
	                  count++;
	                  
	              }
	              
	              if(Cell==1)
	              {  
	              if(count<2)
	            	  cells[i][j]=0;
	              
	              if(count>3)
	            	  cells[i][j]=0;
	              
	              if(count==2|| count==3)
	              {
	            	  cells[i][j]=cells[i][j];
	              }
	              }
	              
	              if(Cell==0)
	              {
	                if(count==3)
	                cells[i][j]=1;
	              }

	}
	     
	   public void print()
	   {
	      //   int k=1;
	         if(k<rows)
	         System.out.println("State :"+k++);
	     
	       for(int i=0;i<rows;i++)
	       {   
	        
	         for(int j=0;j<columns;j++)
	           System.out.print(cells[i][j]);
	         
	         System.out.println();
	       }
	       
	     }
	      
	   
	   public void PrintCell()
	    {
	        int counte = 0;
	      System.out.println("Enter The Cell Which You Want To Check ");
	      System.out.println("Enter Row");
	      int r=sc.nextInt();
	      System.out.println("Enter Column");
	      int c=sc.nextInt();
	      if(r<rows && c<columns)
	      {  
	      for(int i=0;i<rows;i++)
	      {
	        for(int j=0;j<columns;j++)
	          if(cells[r][c]==0)
	            counte=0;
	          else
	            counte=1;
	      }  
	        if(counte==0)
	          System.out.print("cell status is Dead");
	        if(counte==1)
	          System.out.print("cell status is Live");
	            
	      }
	      else
	      {
	        System.out.println("Please Enter valid  Rows And Column");
	        PrintCell();
	      }
	      
	    }

	public static void main(String[] args) {
		
		 // TODO Auto-generated method stub
	    
	     Scanner sc=new Scanner(System.in);
	     
	     System.out.println("Enter  Number Of Rows");
	     Integer ROWS=sc.nextInt();
	     
	     System.out.println("Enter  Number Of Columns");
	     Integer COLUMN=sc.nextInt();
	     
	     Integer [][] cells=new Integer[ROWS][COLUMN];
	     
	     System.out.println( "Enter The Elements States Press 1 For Live OR Press 0 For Dead" );
	     
	     for(int i=0;i<ROWS;i++)   
	       for(int j=0;j<COLUMN;j++)
	         cells[i][j]=sc.nextInt();
	     
	     Life li=new Life();
	     li.setCells(cells, ROWS, COLUMN);
	     li.getCells();
	     li.getStates();
	     


	}
	
	
	
	

}
