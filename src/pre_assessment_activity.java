import java.util.Scanner;

public class pre_assessment_activity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Methods method = new Methods();
        try (Scanner scan = new Scanner(System.in)) {
            boolean isContinue = true;
            // loop will continue if isContinue == true
            do {
                // Shows the system menu
                System.out.println("""

                        *----------------System Menu---------------*
                        a -> Add new Peripheral
                        b -> Display Records List
                        c -> Update Record
                        d -> Delete Record
                        e -> Reports
                        f-> Exit
                        """);
                System.out.print("Enter option: ");
                // switch condition
                char operator = scan.next().charAt(0);

                switch (operator) {
                    // create records
                    case 'a' -> {
                        // component name
                        System.out.print("Enter component name: ");
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
                        if (option == 'a') {
                            peripheral = "Input Device";
                        } else if (option == 'b') {
                            peripheral = "Output Device";
                        } else {
                            peripheral = "Input/Output Device";
                        }
                        // enter employee
                        System.out.print("Enter employee name(n/a if none): ");
                        String employeeName = scan.next();

                        method.addRecords(componentName, peripheral, employeeName);
                    }
                    // display records
                    case 'b' ->
                        method.displayRecords();
                    // edit records
                    case 'c' -> {
                        System.out.print("Enter code: ");
                        String code = scan.next();

                        method.updateRecord(code);

                    }
                    // delete records
                    case 'd' -> {
                        System.out.print("Enter code: ");
                        String code = scan.next();

                        method.deleteRecord(code);
                    }
                    // Show detailed report
                    case 'e' -> {
                        method.showReport();
                    }
                    // Terminates the program
                    case 'f' -> {
                        isContinue = false;
                        System.out.println("Program Terminated");
                    }
                    default ->
                        throw new IllegalStateException("Unexpected value: " + operator);
                }
            } while (isContinue);
        }
    }

}
