class StringSCP{
    public  static void main (String args[]) {
        String name= new String("vaibhav");
        System.out.println(name);
        System.out.println(name.concat("deshmukh"));
        System.out.println(name);
        name =name.concat("name");
        System.out.println(name);

        // Check == And .equals() method
        String name1 = new String("vaibhav");
        String name2 = new String("vaibhav");
        String name3 = "vaibhav";
        String name4 = "vaibhav";
        System.out.println(name1 == name2);
        System.out.println(name2.equals(name1));
        System.out.println(name1 == name3);
        System.out.println(name1.equals(name3));
        System.out.println(name3 == name4);
        System.out.println(name3.equals(name4));

    } 
    
}