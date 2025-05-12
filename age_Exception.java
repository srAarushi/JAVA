class MyException extends Exception{
    MyException(String msg){
        super(msg);
    }
}
public class age_Exception {
    public static void validate(int age) throws MyException{
       if(age < 18) {
        throw new MyException("Age Exception(Not a valid age)");
       } else {
        System.out.println("Age is valid");
       }
    }
    public static void main(String[] args){
        try{
            validate(20);
            validate(15);
        } catch(MyException e){
            e.printStackTrace();
            e.getMessage();
        }
    }
}