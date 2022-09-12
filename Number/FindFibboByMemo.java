import java.util.HashMap;
import java.util.Map;

class FindFibboByMemo{
  static int [] memo = new int[5];
    public static void main(String[] args){
      
        findFiboSeries(5);      
    }
     private static Map<Integer, Integer> memoizeSet = new HashMap<>();
    private static int findFiboSeries(int n ) {
       
        int result =0;
        
         if(n==0){
           return 0;
         }
         else if(n==1){
         return 1;
         }
         if(memoizeSet.containsKey(n)){
            return memoizeSet.get(n);
         }
         else{
            result = findFiboSeries(n-1) + findFiboSeries(n-2);
         }
         memo[n] = result;
         return result;
   
    }
}