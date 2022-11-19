import java.util.*;

public class P1
{
  static int pageFrame=0;
  static int lru(int pageString[])
  {
    
    
    ArrayList<Integer> page=new ArrayList<Integer> ();
    HashMap<Integer,Integer> indexe=new HashMap<> ();
    
    int n=pageString.length;
    int page_fault=0,curPage;
    
    for(int i=0;i<n;i++)
    {
      curPage=pageString[i];
      if(page.size() < pageFrame)
       {
         if(!page.contains(curPage))
         {
           page.add(curPage);
           page_fault++;
           disp(page,page_fault);
         }
       
       indexe.put(curPage,i);
       }
      else
       {
         if(!page.contains(curPage))
         {  int lru=Integer.MAX_VALUE,PTR=0,temp;
         
           for(int j=0;j<page.size();j++)
           {
             temp=page.get(j);
             if(indexe.get(temp)<lru)
             {
               lru=indexe.get(temp);
               PTR=j;
             }
           
           }
           indexe.remove(page.get(PTR));
           page.set(PTR,curPage);
           page_fault++;
           disp(page,page_fault);
         }
         indexe.put(curPage,i);
       }
            
    }
  return page_fault;
  }
  
 static void disp(ArrayList<Integer> page,int page_fault)
 {
  System.out.print("At pageFault-"+page_fault+":: Page-");
  for(int i=0;i<page.size();i++)
  {
   System.out.print(" "+page.get(i));
  }
  System.out.println();
 
 }
 
public static void main(String args[])
{
  int page[]={2,3,1,3,7,5,0,7,9,0,2,5,6,7,8,9,1};
  pageFrame=3;
  int k;
  System.out.println("__implement");
  k=lru(page);
  System.out.println("no of page fault:"+k);
  


} 	
  	

}
