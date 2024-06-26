import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr1 =  new int[n];
        for (int i=0; i<n; i++)
        {
            arr1[i]=i+1;
        }
        System.out.println("Enter the length of interval:");
        int m = sc.nextInt();
        System.out.print("Path: ");
        int j = 0;
        do {
            System.out.print(arr1[j]);
            j = (j + m-1) % n;
        } while (j!=0);
    }
}
