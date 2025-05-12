//Write a Java program to generate an 
//ArrayIndexOutofBoundsException and handle it using catch statement
import java.util.Scanner;
public class L7_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        try{
            for ( int i = 0 ; i<=5; i++){
                arr[i] = sc.nextInt();
                
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception in thread 'main' java.lang.ArrayIndexOutOfBoundsException:" + 5);
        }
    } 
}