package Practice_Upgrade;
import java.util.*;



public class Sumoffarraywithscanner {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		int sum =0;
		for (int i =0; i<size; i++)
		{
			System.out.println("Enter Element : " +(i+1));
			arr[i]=sc.nextInt();
			sum = sum+arr[i];			
		}
		System.out.println("Sum of array : " + sum);
	}

}
