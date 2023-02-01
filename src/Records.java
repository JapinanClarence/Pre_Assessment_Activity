public class Records extends Employee {
    /*
     * Class params
     */
    private String code;
    private String componentName;
    private String peripheral;
    // private boolean value;
    
    /*
     * Constructors
     */
    public Records(){
        
    }
    public Records(String code, String componentName, String peripheral) {
        this.code = code;
        this.componentName = componentName;
        this.peripheral = peripheral;
    }

    public Records(String code, String componentName, String peripheral, String employeeName) {
        super(employeeName);
        this.code = code;
        this.componentName = componentName;
        this.peripheral = peripheral;
    }

    /*
     * Getters
     */
    public String getCode() {
        return this.code;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public String getPeripheral() {
        return this.peripheral;
    }


}
