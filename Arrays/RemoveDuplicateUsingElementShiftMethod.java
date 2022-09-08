public class RemoveDuplicateUsingElementShiftMethod {
    public static void removeDuplicate(int[] array, int elementToRemove) {
        System.out.println(array.length);
        for (int index = 0; index < array.length; index++) {// 1 2 3 4 5
            if (array[index] == elementToRemove) {

                for (int newIndex = index; newIndex < array.length - 1; newIndex++) {
                    array[newIndex] = array[newIndex + 1];
                }

                break;
               // array[index] = 100;
            }

            //System.out.println(index+" "+array[index]);
           // return array;
        }
        for(int i : array){
            System.out.println(i+" " );
        }
        //return array;
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };
        int elementToRemove = 30;
         removeDuplicate(array, elementToRemove);
        
    }
}
