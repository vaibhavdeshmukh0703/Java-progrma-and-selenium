public class Employee {
    private String Employee_name;
    private int age;
    private double sallary;

    Employee(String Employee_name, int age, double sallary){
        this.Employee_name = Employee_name;
        this.age = age;
        this.sallary = sallary;
    }

    /**
     * @return the employee_name
     */
    public String getEmployee_name() {
        return Employee_name;
    }
    /**
     * @param employee_name the employee_name to set
     */
    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the sallary
     */
    public double getSallary() {
        return sallary;
    }
    /**
     * @param sallary the sallary to set
     */
    public void setSallary(double sallary) {
        this.sallary = sallary;
    }
   
    @Override
    public String toString() {
        return "Name is-->"+Employee_name+" Age is-->"+age+" Sallary is-->"+sallary+'\n';
    }    
    
}
