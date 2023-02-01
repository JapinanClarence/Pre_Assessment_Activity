
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

    /*
     * Class attributes
     */
    private final ArrayList<Records> record = new ArrayList<>();
    
    //used for auto increminting our code
    private int id = 0001;

    /**
     * Will add record to the array record
     *
     * @param componentName
     * @param peripheral
     * @param employeeName
     */
    public void addRecords(String componentName, String peripheral, String employeeName) {

        // will auto increment code
        if (record.iterator().hasNext()) {
            this.id++;
        }

        // will get the current year
        int currentDate = Year.now().getValue();

        String code = currentDate + String.format("%04d", id);

        Records recordObject = new Records(code, componentName, peripheral, employeeName);
        record.add(recordObject);
        
        
        if (recordObject.getEmployeeName().equals("n/a")) {
            System.out.println("*-----Record is added!-----*");
            System.out.println("Code: " + recordObject.getCode());
            System.out.println("Component: " + recordObject.getComponentName());
            System.out.println("Peripheral: " + recordObject.getPeripheral());
            System.out.println("Assigned employee: " + recordObject.getEmployeeName());

        } else {
            System.out.println("*-----Record is successfully assigned!-----*");
            System.out.println("Code: " + recordObject.getCode());
            System.out.println("Component: " + recordObject.getComponentName());
            System.out.println("Peripheral: " + recordObject.getPeripheral());
            System.out.println("Assigned employee: " + recordObject.getEmployeeName());

        }

    }

    /**
     * Will ask the user the specific record they want to view
     */
    public void displayRecords() {

        try {
            Scanner scan = new Scanner(System.in);
            boolean isContinue = true;
            do {
                System.out.println("""
                        View Record:
                        a. Peripheral Record
                        b. Available Peripherals
                        c. Assigned Peripherals
                        d. Input Devices
                        e. Output Devices
                        f. Input/Output Devices
                        g. Exit
                        """);
                System.out.print("Enter: ");
                char option = scan.next().charAt(0);

                switch (option) {
                    case 'a' ->
                        peripheralRecord();
                    case 'b' ->
                        availablePeripherals();
                    case 'c' ->
                        assignedPeripherals();
                    case 'd' ->
                        inputDevice();
                    case 'e' ->
                        outputDevice();
                    case 'f' ->
                        inputOutputDevice();
                    case 'g' ->
                        isContinue = false;

                    default ->
                        throw new IllegalStateException("Unexpected value: " + option);
                }
            } while (isContinue);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    /**
     * Will display all of the record
     */
    public void peripheralRecord() {

        System.out.println("*-----RECORDS-----*");
        for (Records list : record) {
            System.out.println("Code: " + list.getCode());
            System.out.println("Component Name: " + list.getComponentName());
            System.out.println("Peripherals: " + list.getPeripheral());
            System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
            System.out.println("*-----------------*");
        }

    }

    /**
     * Display available peripherals
     */
    public void availablePeripherals() {

        System.out.println("*------RECORDS-----*");
        for (Records list : record) {
            if (list.getEmployeeName().equals("n/a")) {
                System.out.println("Code: " + list.getCode());
                System.out.println("Component Name: " + list.getComponentName());
                System.out.println("Peripherals: " + list.getPeripheral());
                System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
                System.out.println("*-----------------*");
            }
        }
    }

    /**
     * Display Assigned Peripherals
     */
    public void assignedPeripherals() {

        System.out.println("*-----RECORDS-----*");
        for (Records list : record) {
            if (!list.getEmployeeName().equals("n/a")) {
                System.out.println("Code: " + list.getCode());
                System.out.println("Component Name: " + list.getComponentName());
                System.out.println("Peripherals: " + list.getPeripheral());
                System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
                System.out.println("*-----------------*");
            }
        }
    }

    /**
     * Will display all input devices
     */
    public void inputDevice() {

        System.out.println("*-----RECORDS-----*");

        for (Records list : record) {
            if (list.getPeripheral().equals("Input Device")) {
                System.out.println("Code: " + list.getCode());
                System.out.println("Component Name: " + list.getComponentName());
                System.out.println("Peripherals: " + list.getPeripheral());
                System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
                System.out.println("*-----------------*");
            }
        }
    }

    /**
     * Will display all output devices
     */
    public void outputDevice() {

        System.out.println("*-----RECORDS-----*");

        for (Records list : record) {
            if (list.getPeripheral().equals("Output Device")) {
                System.out.println("Code: " + list.getCode());
                System.out.println("Component Name: " + list.getComponentName());
                System.out.println("Peripherals: " + list.getPeripheral());
                System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
                System.out.println("*-----------------*");
            }
        }
    }

    /**
     * Will display all input/output devices
     */
    public void inputOutputDevice() {
        System.out.println("*-----RECORDS-----*");

        for (Records list : record) {
            if (list.getPeripheral().equals("Input/Output Device")) {
                System.out.println("Code: " + list.getCode());
                System.out.println("Component Name: " + list.getComponentName());
                System.out.println("Peripherals: " + list.getPeripheral());
                System.out.println("Assigned to (Employee name): " + list.getEmployeeName());
                System.out.println("*-----------------*");
            }
        }
    }

    /**
     *
     * @param code Displays the current record data, then ask the user to update
     *             record
     */
    public void updateRecord(String code) {
        try {
            Scanner scan = new Scanner(System.in);
            for (Records list : record) {
                if (list.getCode().equals(code)) {
                    // displays the record code
                    System.out.println("Code: " + list.getCode());

                    /*
                     * ask the new record data
                     */
                    System.out.print("Update component: ");
                    String componentName = scan.next();

                    // provides option to the user
                    System.out.print("""
                            Choose peripheral:
                            a. Input Device
                            b. Output Device
                            c. Input/Output Device
                            """);

                    System.out.print("Enter: ");
                    char option = scan.next().charAt(0);

                    String peripheral;

                    // switch expression
                    peripheral = switch (option) {
                        case 'a' ->
                            "Input Device";
                        case 'b' ->
                            "Ouput Device";
                        default ->
                            "Input/Output Device";
                    };

                    System.out.print("Update employee: ");
                    String employeeName = scan.next();

                    record.set(0, new Records(list.getCode(), componentName, peripheral, employeeName));

                    System.out.println("*-----Record code:" + list.getCode() + " was successfully updated!-----*");

                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Delete record method
     * 
     * @param code
     */
    public void deleteRecord(String code) {
        try {
            for (Records list : record) {
                if (list.getCode().equals(code)) {
                    record.remove(list);
                    System.out.println("*-----Record Successfully deleted-----*");
                } else {
                    System.out.println("*-----Code " + code + " not found!-----*");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * Show report of the records
     */
    public void showReport() {

        try {
            Scanner scan = new Scanner(System.in);
            boolean isContinue = true;

            do {

                int total = 0;
                System.out.println("""
                        *-----Show Reports-----*
                        a. Available Peripherals
                        b. Assigned Peripherals
                        c. Input Devices
                        d. Output Devices
                        e. Employees with Peripherals Assigned
                        f. Exit
                        """);
                System.out.print("Enter: ");
                char option = scan.next().charAt(0);

                switch (option) {
                    // Displays all available peripherals
                    case 'a' -> {
                        System.out.println("*-----Total-----*");
                        for (Records list : record) {
                            if (list.getEmployeeName().equals("n/a")) {
                                total++;
                            }
                        }
                        System.out.println("Available peripherals : " + total);
                    }
                    // displays all asigned peripherals
                    case 'b' -> {
                        System.out.println("*-----Total-----*");
                        for (Records list : record) {
                            if (!list.getEmployeeName().equals("n/a")) {
                                total++;
                            }
                        }
                        System.out.println("Assigned Peripherals: " + total);
                    }
                    // display all input devices
                    case 'c' -> {
                        System.out.println("*-----Total-----*");
                        for (Records list : record) {
                            if (list.getPeripheral().equals("Input Device")) {
                                total++;
                            }
                        }
                        System.out.println("Total input devices: " + total);
                    }
                    // display all output devices
                    case 'd' -> {
                        System.out.println("*-----Total-----*");
                        for (Records list : record) {
                            if (list.getPeripheral().equals("Output Device")) {
                                total++;
                            }
                        }
                        System.out.println("Total input devices: " + total);
                    }
                    // display total employees with records assigned to it
                    case 'e' -> {

                        int count = 0;
                        System.out.println("*-----Total-----*");

                        for (Records lists : record) {
                            for(Records list : record){
                                if(list.getEmployeeName() != lists.getEmployeeName()){
                                    count++;
                                }
                            }
                        }
                        System.out.println("Employees with peripherals assigned: " + count);
                    }
                    case 'f' -> {
                        isContinue = false;
                        System.out.println("*-----Program Terminated-----*");
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + option);
                }

            } while (isContinue);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
