import java.util.*;
public class First
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of process: ");
		int n=sc.nextInt();
		int pid[]=new int[n];
		int at[]=new int[n];
		int bt[]=new int[n];
		int ct[]=new int[n];
		int ta[]=new int[n];
		int wt[]=new int [n];
		int temp;
		float avgwt=0,avgta=0;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter process"+(i+1)+"arrival time");
			at[i]=sc.nextInt();
			System.out.println("Enter process "+(i+1)+"burst time ");
			bt[i]=sc.nextInt();
			pid[i]=i+1;
		} 
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-(i+1);j++)
			{
				if(at[j]>at[j+1])
				{
					temp=at[j];
					at[j]=at[j+1];
					at[j+1]=temp;
					temp=bt[j];
					bt[j]=bt[j+1];
					bt[j+1]=temp;
					temp=ct[j];
					ct[j]=ct[j+1];
					ct[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				ct[i]=at[i]+bt[i];
			}
			else
			{
				if(at[i]>ct[i-1])
				{
					ct[i]=at[i]+bt[i];
				}
				else
				{
					ct[i]=ct[i-1]+bt[i];
				}
			}
			ta[i]=ct[i]-at[i];
			wt[i]=ta[i]-bt[i];
			avgwt +=wt[i];
			avgta +=ta[i];
		}
		System.out.println("\npid  arrival  burst  complete  turn  waiting");
		for(int i=0;i<n;i++)
		{
			System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
		}
		sc.close();
		System.out.println("\nAverage waiting time: "+(avgwt/n));
		System.out.println("\nAverage turnaround time: "+(avgta/n));
	}
}