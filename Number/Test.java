class CloseableExample implements AutoCloseable{

  void print(){
    System.out.println("Test print");
  }

  
  public void close() {

    System.out.println("Closing resources");
  }

  public static void main(String[] args) {
    try (
      CloseableExample ce = new CloseableExample();
      ) {
        ce.print();
    } catch (Exception e) {
        // TODO: handle exception
    }
   
    
  }
}
// public class GarbageCollectorEG {
//   public static void main(String[] args) {
//     GarbageCollectorEG garbageCollectorEG = new GarbageCollectorEG();
//     garbageCollectorEG = null;
//     System.gc();
//   }
//   @Override
// protected
//    void finalize(){
//          try {
//              // cleanup subclass state
//          } finally {
//              super.finalize();
//          }
//      }
//  }
