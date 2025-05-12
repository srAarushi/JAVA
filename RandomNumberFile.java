import java.io.*;
import java.util.Random;
import java.util.Scanner;

class RandomNumberFile {
	private int[] arr;
	private int[] num;
	RandomNumberFile(int n) {
		arr = new int[n];
		num = new int[n];
	}
	void swap(int p, int q) {
		int temp = num[p];
		num[p] = num[q];
		num[q] = temp;
	}
	void printArray(int[] a) {
		for(int x : a)
			System.out.print(x+" ");
	}
	public static void main(String[] args) {
		Random rd = new Random();
		//int n = 30;
		int mn = 1;
		int mx = 100;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of random integers to be generated: ");
		int n = sc.nextInt();
		RandomNumberFile rnf = new RandomNumberFile(n);
		for(int i=0; i<n; ++i) {
			rnf.arr[i] = rd.nextInt(mx-mn+1)+mn;
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("numobj.txt"));
			oos.writeObject(rnf.arr);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("numobj.txt"));
			rnf.num = (int[])ois.readObject();
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Random Array:");
		rnf.printArray(rnf.arr);
		System.out.println("\nRandom Number from File:");
		rnf.printArray(rnf.num);
		//Insertion Sort
		for(int i=0; i<rnf.num.length; ++i) {
			int j = i;
			while(j>0 && rnf.num[j-1]>rnf.num[j]) {
				rnf.swap(j, j-1);
				--j;
			}
		}
		System.out.println("\nSorted Array:");
		rnf.printArray(rnf.num);
	}
}