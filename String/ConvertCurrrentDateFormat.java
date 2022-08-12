import java.util.HashMap;
import java.util.Map;

public class ConvertCurrrentDateFormat {
    public static void main(String[] args) {
        // 08-08-2022 to 8-aug-2022
        String date = "02-02-2022";

        Map<Integer, String> month = new HashMap<Integer, String>();

        month.put(1, "Jan");
        month.put(2, "Feb");

        String[] spliteDateArray = date.split("\\-");
        int monthNumber = Integer.parseInt(spliteDateArray[1]);

        spliteDateArray[1] = month.get(monthNumber);
        String newDate = String.join("-", spliteDateArray);
        System.out.println(newDate);

        String newDateUsingReplace = date.replace("-02", "-Feb");
        System.out.println(newDateUsingReplace);
    }
}
