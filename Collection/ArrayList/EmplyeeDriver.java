import java.util.ArrayList;
import java.util.List;
public class EmplyeeDriver {
   public static void main(String[] args) {
    List<Employee> empList = new ArrayList<>();
    Employee e1 = new Employee("vaibhav", 25, 10000);
    Employee e2 = new Employee("vishal", 26, 10000);
    Employee e3 = new Employee("varun", 28, 10000);
    Employee e4 = new Employee("vishnu", 21, 10000);
    Employee e5 = new Employee("viraj", 22, 10000);

    empList.add(e1);
    empList.add(e2);
    empList.add(e3);
    empList.add(e4);
    empList.add(e5);

    for (Employee employee : empList) {
        if(employee.getAge()>25){
            employee.setSallary(employee.getSallary()*1.10);
        }
    }
    
    System.out.println(empList.toString());

   } 
}
