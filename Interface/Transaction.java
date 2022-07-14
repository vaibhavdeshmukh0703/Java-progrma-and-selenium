package Interface;

/**
 * Transaction
 */
public interface Transaction {

    public void withdraw(int amount);
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
        System.out.println("Aount Withdaw sucessfully and remaining baance is -> "+balance);

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
}
    
}