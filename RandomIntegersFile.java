import java.io.*;
class RandomIntegersFile
{
	public static void main(String args[]) throws IOException
	{
		int min = 0;
		int max = 10000;
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("randnum.txt"));
		for(int i = 0; i < 1000; i++)
		{
			dos.writeInt(min + (int)Math.floor((max - min)*Math.random()));
		}
		dos.close();
		DataInputStream dis = new DataInputStream(new FileInputStream("randnum.txt"));
		int[] arr = new int[1000];
		System.out.println("Read Random Integers from File:"); 
		for(int i = 0; i < 1000; i++)
		{
			arr[i] = dis.readInt();
			System.out.print(arr[i]+" ");
		}
		dis.close();
	}
}

