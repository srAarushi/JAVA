// Write a class file – box with three data members(length, width, 
// height) and a method volume() . Also implement the application class Demo where an 
// object of the box class is created with user entered dimensions and volume is printed.
// Input: length,width and height.
//  Output: Volume 
import java.util.Scanner;
class Box{
    int length;
    int breadth;
    int height;
 
    Box(int l,int b,int h){
        length = l;
        breadth = b;
        height = h;
    }

    void print(){
        int vol = length*breadth*height;
         System.out.println("Volume is : "+vol);
        }
    }
    public class L3_1 {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the length, breadth and height:");
int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
Box obj = new Box(a,b,c);
obj.print();
    }
}