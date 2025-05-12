// Program to find no. of objects created out of a class using ‘static’ 
//modifier.

public class ObjectCounter {
    private static int numberOfObjects = 0;

    public ObjectCounter() {
        numberOfObjects++;
    }
    public static void main(String[] args) {
        
        ObjectCounter obj1 = new ObjectCounter();
        ObjectCounter obj2 = new ObjectCounter();
        ObjectCounter obj3 = new ObjectCounter();

        System.out.println("Number of objects created: " + ObjectCounter.numberOfObjects);
    }
}