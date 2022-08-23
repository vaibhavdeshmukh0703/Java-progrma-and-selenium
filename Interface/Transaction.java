package Interface;

/**
 * Transaction
 */
public interface Transaction {

    public void withdraw(int amount);

default void msg(){System.out.println("default method");}  
static int cube(int x){return x*x*x;};

}

/**
 * InnerTransaction
 */
class InnerTransaction implements Transaction {

    @Override
    public void withdraw(int amount) {
        // TODO Auto-generated method stub
        int balance = 1000;
        balance -= amount;
        System.out.println("Amount is Withdaw sucessfully and remaining balance is -> "+balance);

    }

}

class TransactionFactory {
        public Transaction createTransaction(){
            return new InnerTransaction();
        }
}

/**
 * InnerTransaction_1
 */ 
 class AmozonTransaction {
public static void main(String[] args) {
    TransactionFactory tf = new TransactionFactory();
    Transaction tr = tf.createTransaction();
    
    tr.withdraw(100);
    tr.msg();

    int cube = Transaction.cube(5);
    System.out.println(cube);
}
    
}