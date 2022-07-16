class SuperPerson{
    SuperPerson(){
       System.out.println("from SuperPerson"); 
    }
}
      class Person extends SuperPerson{
        int id;
        String name;
        Person(int id,String name){
            System.out.println("From Person class");
            this.id = id;
            this.name = name;
        }
        // void print(){
        //     System.out.println(id+" "+name);
        // }
      }
      class Employee extends Person{
        float salary;
        String name="vaibhav";
        Employee(int id, String name,float salary){
           super(id, name);
           this.salary = salary;
        }
        
        void print(){
            System.out.println(id+ " " +super.name+" "+salary);
        }
        void work(){
           super.print();// print not available at parent class so it show error.cannot find symbol.
            print(); // if ivaible print method
        }
      }
      class Test1{
        public static void main(String[] args) {
            Employee emp = new Employee(1,"Shekhar",50000);
            emp.work();
        }
      }