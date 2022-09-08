package com.example.Employees;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * EmployeeManager
 */
public class EmployeeManager {

   public static void main(String[] args) {
      try {

         Employee e1 = new Employee(1);
         Employee e2 = new Employee(1);

         Map<Employee, String> hm = new HashMap<>();
         hm.put(e1, "vaibhav");
         hm.put(e2, "jack");

         System.out.println(hm.size());

            Set<Employee> Keys = hm.keySet();
            for (Employee key : Keys) {
               System.out.println(hm.get(key) + "" + key);
            }
         
         for(Map.Entry<Employee, String> m : hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
         }
        

      } catch (Exception e) {
         // TODO: handle exception
      }
   }
}
