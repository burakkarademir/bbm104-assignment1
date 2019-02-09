import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class HelloJava {
	//This method calculates the riemann sum for funtion 1,function 2 and function 3//
	public static double IntegrateRiemann(String  IntegrateRiemann,String name_of_function, double a, double b , int number_of_partitions){
		double total=0;
		if(name_of_function.equalsIgnoreCase("func1")){
			double sum=(b-a)/(number_of_partitions);
			double nsum=a+sum/2;
			for(int q=0;q<number_of_partitions;q++){
				double value=(nsum*nsum)-nsum+3;
				nsum += sum;
				double area=value*sum;
				total+=area;
				}
		}
		if(name_of_function.equalsIgnoreCase("func2")){
			double sum=(b-a)/(number_of_partitions);
			double nsum=a+sum/2;
			for(int q=0;q<number_of_partitions;q++){
				double sin;
				sin=Math.sin(nsum);
				double value=(3*sin-4)*(3*sin-4);
				nsum += sum;
				double area=value*sum;
				total+=area;
				}
		}
		if(name_of_function.equalsIgnoreCase("func3")){
			double sum=(b-a)/(number_of_partitions);
			double nsum=a+sum/2;
			for(int q=0;q<number_of_partitions;q++){
				double sin;
				sin=Math.sin(nsum);
				double value=asinh(nsum);
				nsum += sum;
				double area=value*sum;
				total+=area;
				}
		}
			return total;
		
		
		}
	//This method calculates arcsinh function without using Math class//
	public static double asinh(double x){
		double result=Math.log(x+Math.sqrt(x*x+1));
		return result;
	}
	//This method makes factorial calculation//
	public static double faktoriyel(double y){
		double sum=1.0;
		for(int i=1;i<=y;i++){
			sum=sum*(i);
		}
		return sum;

	}
	//This method calculates maclaurin series which are special cases of taylor series for approximation of arcsinh(x)//
	public static double arcsinh(double x){
		double sum=0;
		for (int n=0;n<=30;n++){
			double fakt=faktoriyel(2*n);
			double fakt2=faktoriyel(n);
			sum+=((Math.pow(-1, n)*fakt)/(Math.pow(4, n)*(Math.pow(fakt2, 2))*(2*n+1)))*Math.pow(x, 2*n+1);
		
	}
		return sum;
	}

	//This method takes one parameter which is number of digit and find armstrong numbers whose digit number is below or equal to the given digit parameter//
	public static void armstrong(int w){
        HashSet< Integer > numbers2 = new HashSet< Integer >();
		ArrayList <Integer> numbers3 = new ArrayList <Integer> ();
		ArrayList <String> numbers4 = new ArrayList <String> ();


			 int n, count = 0, a, b, c, sum = 0;
			 for (int v = 0 ; v <= w ; v++){
				 double  z=Math.pow(10, v)-1;
		         for(int i = 1; i <= z; i++)
		         {
		            n = i;
		            while(n > 0)
		            {
		                b = n % 10;
		                sum = (int) (sum + (Math.pow(b, v)));
		                n = n / 10;
		            }
		            if(sum == i){
		            	

		            	numbers2.add(sum);
		            	
		            }
		            sum = 0;

		        }
		        }
			
			 numbers3.addAll(numbers2);
			 Collections.sort(numbers3);

			 System.out.println("Armstrong"+" "+w+" "+"Result:"+" "+ numbers3);
		}
		


		
		
	public static void main(String[] args){ 
		//These lists keep the data parts//
		ArrayList <String> lines = new ArrayList <String> ();
		ArrayList <String> funcone = new ArrayList <String> ();
		ArrayList <String> functwo = new ArrayList <String> ();
		ArrayList <String> functhree = new ArrayList <String> ();
		//This codes reads txt file with scanner class//
		File file=new File(args[0]);
		try {
			Scanner scanner=new Scanner(file);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lines.add(line);
			}
			
			scanner.close();
			//This codes catches the  FileNotFoundException error and prints No File Found! on  console//
		} catch (FileNotFoundException e) {
			System.out.println("No File Found!");
			return;
		}
		//This codes seperates the input file//
		for(int f=0; f<lines.size();f++){
			String[] inputt=lines.get(f).split(" ");
			if (inputt[1].length()>4);
				if(inputt[1].equalsIgnoreCase("func1")){
					funcone.add(lines.get(f));
				}
				if(inputt[1].equalsIgnoreCase("func2")){
					functwo.add(lines.get(f));
				}
				if(inputt[1].equalsIgnoreCase("func3")){
					functhree.add(lines.get(f));
				}
				}
		//This codes takes the data and send to their methods//
		for (int y=0;y<funcone.size();y++){
			String[] input2=funcone.get(y).split(" ");
			String aString = input2[2];
		    double aDouble = Double.parseDouble(aString);
		    String aString2 = input2[3];
		    double aDouble2 = Double.parseDouble(aString2);
		    String number =input2[4] ;
		    int result = Integer.parseInt(number);
			double func1=IntegrateRiemann(input2[0],input2[1],aDouble,aDouble2,result);
			System.out.println(input2[0]+" "+ input2[1]+" "+aDouble+" "+aDouble2+" "+result+" "+"Result:"+" "+func1);
			
			}
		for (int y=0;y<functwo.size();y++){
			String[] input3=functwo.get(y).split(" ");
			String aString = input3[2];
		    double aDouble = Double.parseDouble(aString);
		    String aString2 = input3[3];
		    double aDouble2 = Double.parseDouble(aString2);
		    String number =input3[4] ;
		    int result = Integer.parseInt(number);
			double func2=IntegrateRiemann(input3[0],input3[1],aDouble,aDouble2,result);
			System.out.println(input3[0]+" "+ input3[1]+" "+aDouble+" "+aDouble2+" "+result+" "+"Result:"+" "+func2);
		}	
		for (int y=0;y<functhree.size();y++){
			String[] input4=functhree.get(y).split(" ");
			String aString = input4[2];
		    double aDouble = Double.parseDouble(aString);
		    String aString2 = input4[3];
		    double aDouble2 = Double.parseDouble(aString2);
		    String number =input4[4] ;
		    int result = Integer.parseInt(number);
			double func3=IntegrateRiemann(input4[0],input4[1],aDouble,aDouble2,result);
			System.out.println(input4[0]+" "+ input4[1]+" "+aDouble+" "+aDouble2+" "+result+" "+"Result:"+" "+func3);
		}	
		for (int m = 0; m<lines.size(); m++){
			String[] input5=lines.get(m).split(" ");
			if (input5[0].equalsIgnoreCase("arcsinh")){
				String aString = input5[1];
			    double aDouble = Double.parseDouble(aString);
				double res=arcsinh(aDouble);
				System.out.println(input5[0]+" "+input5[1]+" "+"Result:"+" "+res);
				}
			}
		
		for (int h = 0; h<lines.size(); h++){
			String[] input5=lines.get(h).split(" ");
			if (input5[0].equalsIgnoreCase("Armstrong")){
				String aString = input5[1];
			    int aDouble = Integer.parseInt(aString);
				armstrong(aDouble);
				
			}

		}

	
}
}