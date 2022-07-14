public class ConvertRomanToInteger {
    public static int romanToInt(String value){
        int j=-1;
        for(int i=0;i<value.length();i++){
            System.out.println(i);
        }

        while (value[j++]) {

            System.out.println(j);
        }
        return 1;
    }
   public static void main(String[] args) {
       String value = "x";
       int values = romanToInt(value);
       System.out.println(values);
   } 
}
