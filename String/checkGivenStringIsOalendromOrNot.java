class checkGivenStringIsOalendromOrNot {
   public static void main(String[] args) {
      System.out.println(isPalindrom1("madam"));
   }

   public static boolean isPalindrom(String string) {
      String orginalString = string;
      String temp = "";
      for (int i = string.length() - 1; i >= 0; i--) {
         temp = temp + string.charAt(i);
      }

      if (orginalString.equalsIgnoreCase(temp)) {
         return true;
      }
      return false;
   }

   public static boolean isPalindrom1(String name) {

      int forwordPointer = 0;
      int backwordPointer = name.length() - 1;

      while (forwordPointer < backwordPointer) {
         if (name.charAt(forwordPointer) != name.charAt(backwordPointer))
            return false;

         forwordPointer++;
         backwordPointer--;
      }

      return true;
   }
}
