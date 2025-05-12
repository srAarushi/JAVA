// Find the no. of occurrence of each element in a user entered list of nos.

import java.util.Scanner;
import java.util.Arrays;
public class L2_5 {
    public static void main(String[] args){
        int n;
        System.out.println("Enter size of array: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0 ; i< n ;i++){
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);
        for ( int i = 0 ; i< n ; i++){
            int count = 1 ; 
            for ( int j = i+1 ; j< n;j++){
                if(arr[i] == arr[j]){
                    count++;
                } else {
                    break;
                }
            }
            System.out.println("Occurrence of" + arr[i] + "= " + count);
            i += count - 1;
        }
    }
}