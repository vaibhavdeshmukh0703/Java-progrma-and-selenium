public class SortArrayCmd {

    public static void SortArrayCmd(String[] array) {
        // 10,20,30,40
        int size = array.length;
        int[] intArray = new int[size];
        for (int count = 0; count < size; count++) {
            intArray[count] = Integer.parseInt(array[count]);
        }
        int temp;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) {// (4,3)
                    temp = intArray[i]; // temp = 4
                    intArray[i] = intArray[j]; // 3
                    intArray[j] = temp;
                }
            }
        }

        for (int count = 0; count < intArray.length; count++) {
            System.out.print(intArray[count]);
        }
    }

    public static void main(String[] args) {
        SortArrayCmd(args);
    }
}
