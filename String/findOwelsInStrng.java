public class findOwelsInStrng {

    public static boolean isWovel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static void countWovels(String string){
        int count=0;
        for(int i=0; i<string.length();i++){
            if(isWovel(string.charAt(i))){
                count++;
            }
         }
        System.out.println("Wovels Count is"+count);
    }

    public static void main(String[] args) {
        // vowels (a, e, i, o, u)
        String string = "Vaibhav"; // a=2 e=0 i=1 o=0
        findOwelsInStrng.countWovels(string);
    }
}
