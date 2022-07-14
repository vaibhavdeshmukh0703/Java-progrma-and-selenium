package Arrays;

public class Threadsafe {
    private int myInt = 0;
      int addOne(){
        int temp = myInt;
        temp = temp + 1;
        myInt = temp;
        return temp;
    }
    public static void main(String[] args) {
        Threadsafe threadsafe = new Threadsafe();
    System.out.println(threadsafe.addOne());
    System.out.println(threadsafe.addOne());
   }
}
