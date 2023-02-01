

public class Employee {
    //Class attribute
    private String employeeName;

    /*
     * Class constructors
     */
    protected Employee(){
        
    }
    protected Employee(String employeeName){
        this.employeeName = employeeName;
    }

    //Getter
    public String getEmployeeName(){
        return this.employeeName;
    }
    // public static boolean isAssigned(String param){
    //     if(param != "n/a"){
    //         return true;
    //     }
    //     return false;
    // }
}
