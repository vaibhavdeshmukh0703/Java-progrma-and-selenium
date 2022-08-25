
public class checkGivenTwoArrayisEqual {

    public static void checkIsEqual(String string) {

        int firstIndexOfOpening = string.indexOf("{");
        int firstIndexOfClosing = string.indexOf("}");
        String spliteString = string.substring(firstIndexOfOpening + 1, firstIndexOfClosing).replace(",", "");
        int[] array1 = new int[spliteString.length()];
        for (int i = 0; i < spliteString.length(); i++) {
            array1[i] = (Character.getNumericValue(spliteString.charAt(i)));
        }

        int lastIndexOfOpenning = string.lastIndexOf("{");
        int lastIndexOfClosing = string.lastIndexOf("}");
        String spliteString2 = string.substring(lastIndexOfOpenning + 1, lastIndexOfClosing).replace(",", "");
        int[] array2 = new int[spliteString2.length()];
        for (int j = 0; j < array2.length; j++) {
            array2[j] = (Character.getNumericValue(spliteString2.charAt(j)));
        }

        if (array1.length != array2.length) {
            System.out.println("not Identical");
            return;
        }

        boolean flag = false;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == (array2[j])) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }

        if (flag)
            System.out.println(" Identical");
        else
            System.out.println(" not Identical");

    }

    public static void main(String[] args) {
        String string = "{2,3,1}{1,2,3}";
        checkIsEqual(string);
    }
}
