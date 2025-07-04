import java.util.InputMismatchException;
import java.util.Scanner;

import com.certificate.controller.CertificateController;
import com.department.controller.DepartmentController;
import com.employee.controller.EmployeeController;
import com.exceptions.EmployeeException;
import com.helper.HibernateHelper;
import com.util.Validator;

/** 
 * <p>
 * Handles operations based on user input
 * </p>
 * @author   Gowtham R
 * @version  1.0
 */
public class EmployeeApplication {
    private Scanner scanner = new Scanner(System.in);
    private CertificateController certificateController = new CertificateController();
    private DepartmentController departmentController = new DepartmentController(); 
    private EmployeeController employeeController = new EmployeeController();  

    /** 
     * <p>
     * Handles the management services with respect to user input
     * </p>
     */
    public void handleChoice() {
        boolean isExited = false;
        do {
            System.out.println("\n------------------------\n");
            System.out.println("Welcome to EMS...!");
            System.out.println("Enter Choice :");
            System.out.println("1. Employee Services");
            System.out.println("2. Department Services");
            System.out.println("3. Certificate Services"); 
            System.out.println("4. Exit");
            int choice = readChoice();
            switch (choice) {
            case 1:
                employeeController.handleChoice();
                break;

            case 2:
                departmentController.handleChoice();
                break;

            case 3:
                certificateController.handleChoice();
                break;

            case 4:
                isExited = true;
                System.out.println("Thank you !");
                break;

            default:
                System.out.println("Enter valid choice");
            } 
        } while (!isExited);
    }

    public int readChoice() {
        boolean isValid = false;
        do {
            try {
                System.out.println("Enter Choice : ");
                int choice = scanner.nextInt();
                isValid = true;
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number !");
                scanner.next();
            }
        } while (!isValid);
        return 0;
    }
    /**
     * Main method
     * Use password Prod@1287$ in testing
     */
    public static void main(String[] args) {
        EmployeeApplication mainController = new EmployeeApplication();
        mainController.handleChoice();
        String password = "Prod@123%";
        try {
            HibernateHelper.closeFactory();
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}