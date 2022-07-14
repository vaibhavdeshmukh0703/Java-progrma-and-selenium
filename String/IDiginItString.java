public class IDiginItString {
    public static void main(String[] args) {
        isDigite("myspaceclass154432124");
    }
     static void isDigite(String string){
       
        String temp="";
        for(int i=0;i<string.length();i++){
            if(Character.isDigit(string.charAt(i))){
                temp = temp+ string.charAt(i);
            }
        }
        System.out.println(Integer.parseInt(temp));
    }
}
