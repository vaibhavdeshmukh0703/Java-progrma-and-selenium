package com.example.Employees;

class Employee{
    private int id;
    Employee(int id){
        this.id = id;
    }
   @Override
  
    public int hashCode() {
        // TODO Auto-generated method stub
        final int prime = 31;
        int result = 1;
        result = result * prime + id;
        return result;

    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Employee other = (Employee)obj;
        if(id != other.id) return false;
        return true;

    }
}
