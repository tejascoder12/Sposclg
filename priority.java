import java.util.*;

public class Prio
{
  public static void main(String args[])
  {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the no of processes:");
  int n=sc.nextInt();
  
  int bt[]=new int[20];
  int at[]=new int[20];
  int wt[]=new int[20];
  int tt[]=new int[20];
  int ct[]=new int[20];  
 int pp[]=new int[20];
 int p[]=new int[20];
int k=0,i,temp;
int st=0,tot=0;
float awt=0,att=0;
  
  for(i=0;i<n;i++)
  { System.out.println("Process ["+(i+1)+"] :");
  System.out.println("enter the brust time:arival:priority");
  bt[i]=sc.nextInt();
  at[i]=sc.nextInt();
  pp[i]=sc.nextInt();
    p[i]=i+1;
  }
  
    for(i=0;i<n-1;i++)
     {
      for(int j=i+1;j<n;j++)
       {
         if((pp[i]>pp[j])||at[i]>=at[j])
          {
           temp=pp[i];
           pp[i]=pp[j];
           pp[j]=temp;
           
           temp=bt[i];
           bt[i]=bt[j];
           bt[j]=temp;
           
           temp=p[i];
           p[i]=p[j];
           p[j]=temp;
           
           temp=at[i];
           at[i]=at[j];
           at[j]=temp;
          }
          
       }
     }
     
    for(i=1;i<=n;i++)
     {
      if(i==0)
      {
      k=bt[0];
      ct[0]=k;
      }
       else
       {
        k=bt[i-1]+k;
        ct[i-1]=k;
        
       }
       
     for(int j=i+1;j<=n;j++)
       {
         if((pp[i]<pp[j])||at[i]<=k)
          {
           temp=pp[i];
           pp[i]=pp[j];
           pp[j]=temp;
           
           temp=bt[i];
           bt[i]=bt[j];
           bt[j]=temp;
           
           temp=p[i];
           p[i]=p[j];
           p[j]=temp;
           
           temp=at[i];
           at[i]=at[j];
           at[j]=temp;
          }
          
       }
     }
  wt[0]=0;
  tt[0]=bt[0];
  
  for(i=0;i<n;i++)
  {
  tt[i]=ct[i]-at[i];
  wt[i]=tt[i]-bt[i];
  awt+=wt[i];
  att+=tt[i];
  
  }
  System.out.println("Processes || arival time || brust time || waiting time || priority || turnaround time ||completeion");
  awt=awt/n;
  att=att/n;
  for(i=0;i<n;i++)
  {
  System.out.println(i+1+" \t\t "+at[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+pp[i]+"\t\t"+tt[i]+"\t\t"+ct[i]);
  
  }
  
  System.out.println("avg wt:"+awt);
  System.out.println("avg tt:"+att);
  
  
  
  
  
  }
}
