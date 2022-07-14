class checkGivenStringIsOalendromOrNot {
   public static void main(String[] args) {
      System.out.println(isPalindrom("mom"));
   } 

   public static boolean isPalindrom(String string){
       String orginalString = string;
        String temp="";
       for(int i=string.length()-1;i>=0;i--){
        temp = temp + string.charAt(i);
       }
       
       if(orginalString.equalsIgnoreCase(temp)){
        return true;
       }
       return false;
   }
}
