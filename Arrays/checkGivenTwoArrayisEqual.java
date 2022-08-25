
public class checkGivenTwoArrayisEqual {

    public static void checkIsEqual(String string) {

        String[] spliteString = string.split("}");
        String string1 = spliteString[0].replace("{", "").replaceAll(",", "");
        String string2 = spliteString[1].replace("{", "").replaceAll(",", "");

        int[] array1 = new int[string1.length()];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Character.getNumericValue(string1.charAt(i));
        }

        int[] array2 = new int[string2.length()];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = Character.getNumericValue(string2.charAt(i));
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
