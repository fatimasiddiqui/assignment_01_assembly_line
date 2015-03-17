import java.io.IOException;
import java.util.Scanner;


public class main {
	static Line obj;
	public static void main(String []args)throws IOException{
		 Scanner in = new Scanner(System.in);
		 float e1;
		 float e2;
		 float x1;
		 float x2;
		 int n;
		 System.out.println("Enter The time it takes to reach the first station of line 1:");
	      e1 = in.nextFloat();
	      System.out.println("Enter The time it takes to reach the first station of line 2:");
	      e2 = in.nextFloat();
	      System.out.println("Enter The time it takes to reach the end from line 1's last station:");
	      x1 = in.nextFloat();
	      System.out.println("Enter The time it takes to reach the end from line 2's last station:");
	      x2 = in.nextFloat();
	      System.out.println("Enter The number of stations in a line:");
	      n = in.nextInt();
	      obj.initialization(n,e1,e2,x1,x2);
	    float[] stations1 = new float[n];
	    float[] stations2 = new float[n];
	    float[] s1tos2 = new float[n-1];
	    float[] s2tos1 = new float[n-1];
	    float num;
	   for(int i = 0; i<n; i++){
		   
		   System.out.println("Enter The value for stations on first line:");
		   num = in.nextFloat();
		   stations1[i] = num;
		   System.out.println("Enter The value for stations on second line:");
		   num = in.nextFloat();
		   stations2[i] = num;
	   }
for(int i = 0; i<n-1; i++){
		   
		   System.out.println("Enter The value for time from stations line1 to stations line2:");
		   num = in.nextFloat();
		   s1tos2[i] = num;
		   System.out.println("Enter The value for time from stations line2 to stations line1:");
		   num = in.nextFloat();
		   s2tos1[i] = num;
	   }
	   
	    obj.values(stations1,stations2,s1tos2,s2tos1,e1,e2,x1,x2);
	    obj.execute();
	    }
		

}
