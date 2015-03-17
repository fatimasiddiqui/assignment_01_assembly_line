import java.io.IOException;
import java.util.Scanner;


public class Line {
	int n = 100;
	static float[] station1 = new float[100] ;
	static float[] station2 = new float [100];
	static float[] s2tos1 = new float[100];
	static float[] s1tos2 = new float[100] ;
	static float[] f1 = new float[100] ;
	static float[] f2 = new float[100] ;
	static float[] I1 = new float[100] ;
	static float[] I2 = new float[100] ;
	static float e1;
	static float e2;
	static float x1;
	static float x2;
	static int noofstations;
	static float fstar;
	static int istar;
	
    
	public static void initialization(int n, float e11, float e22, float x11, float x22){
		noofstations = n;
		for(int i = 0; i<n; i++){
			station1[i] = 0;
			station2[i] = 0;
			f1[i] = 0;
			f2[i] = 0;
			I1[i] = 0;
			I2[i] = 0;
			//System.out.println("stations done");
		}
		
		for(int j = 0; j<n-1; j++){
			s1tos2[j] = 0;
			s2tos1[j] = 0;
			//System.out.println("time from one station to other done");
		}
		e1 = e11;
		e2 = e22;
		x1 = x11;
		x2 = x22;
		//System.out.println("starting and ending point initialized!");
	}
	public static void values(float[] stations1, float[] stations2, float[] s1tos2g, float[] s2tos1g, float e11, float e22, float x11, float x22){
		int s1 = stations1.length; 
		int s2 = stations2.length;
		int s1tos2len = s1tos2g.length;
		int s2tos1len = s2tos1g.length;
		//System.out.println("Length");
		//System.out.println(s1tos2len);
		
		e1 = e11;
		System.out.println(e1);
		e2 = e22;
		System.out.println(e2);
		x1 = x11;
		System.out.println(x1);
		x2 = x22;
		System.out.println(x2);
		for(int i = 0; i<s1;i++){
			station1[i] = stations1[i];
			System.out.println(station1[i]);
			
		}
		for(int i = 0; i <s2;i++){
			station2[i] = stations2[i];
			System.out.println(station2[i]);
		}
		for(int j = 0; j<s1tos2len; j++){
			s1tos2[j] = s1tos2g[j];
			System.out.println(s1tos2[j]);
			
			
		}
		for(int j = 0; j<s2tos1len; j++){
			s2tos1[j] = s2tos1g[j];
			System.out.println(s2tos1[j]);
			
		}
	}
	public static void execute(){
		System.out.println(noofstations);
		for(int i = 0; i< noofstations; i++){
			if(i == 0){
				f1[i] = e1 + station1[i];
				f2[i] = e2 + station2[i];
			}
			else{
				float f1minimum1 = f1[i-1]+station1[i];
				float f1minimum2 = f2[i-1] + s2tos1[i-1]+station1[i];
				float f2minimum1 = f2[i-1]+ station2[i];
				float f2minimum2 = f1[i-1] + s1tos2[i-1] + station2[i];
				if (f1minimum1 < f1minimum2){
					f1[i] = f1minimum1;
					I1[i]= 1;
				}
				else if(f1minimum2 < f1minimum1){
					f1[i] = f1minimum2;
					I1[i] = 2;
				}
				else{
					f1[i] =f1minimum1;
					I1[i] = 1;
				}
				if (f2minimum1 < f2minimum2){
					f2[i] = f2minimum1;
					I2[i] = 2;
					
				}
				else if(f2minimum2 < f2minimum1){
					f2[i] = f2minimum2;
					I2[i] = 1;
				}
				else{
					f2[i] = f2minimum1;
					I2[i]= 2;
				}
			}
		}
		float f1minimum = f1[noofstations-1] +  x1;
		float f2minimum = f2[noofstations-1] + x2;
		if(f1minimum < f2minimum){
			fstar = f1minimum;
			istar = 1;
		}
		else if(f1minimum > f2minimum){
			fstar = f2minimum;
			istar = 2;
		}
		else{
			fstar = f1minimum;
			istar = 1;
		}
		System.out.println("The fastest time required is:");
		System.out.println(fstar);
		System.out.println("The fastest path is Through:");
		System.out.println(istar);
		//if(istar == 1){
			//for(int i = 0; i<noofstations; i++){
				//System.out.println(I1[i]);
			//}
		//}
		//if(istar == 2){
			//for(int i = 0; i<noofstations; i++){
				//System.out.println(I2[i]);
			//}
		//}
		
	}
	 
}



