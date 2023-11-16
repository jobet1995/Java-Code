import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Employee> employeeStack = new Stack<>();
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("1. Insert");
      System.out.println("2. Delete");
      System.out.println("3. Display");
      System.out.println("4. Search");
      System.out.println("5. Exit");

      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          insertEmployee(scanner, employeeStack);
          break;
        case 2:
          deleteEmployee(employeeStack);
          break;
        case 3:
          displayEmployees(employeeStack);
          break;
        case 4:
          searchEmployee(employeeStack);
          break;
        case 5:
          System.out.println("Exiting program. Goodbye!");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
      }

      System.out.print("Do you want to continue? (YES/NO): ");
    } while (scanner.next().equalsIgnoreCase("YES"));
  }

  private static void insertEmployee(Scanner scanner, Stack<Employee> employeeStack) {
    scanner.nextLine();
    System.out.print("Enter employee's full name: ");
    String fullName = scanner.nextLine();
    System.out.print("Enter employee number: ");
    String empNumber = scanner.nextLine();

    Employee employee = new Employee(fullName, empNumber);
    employeeStack.push(employee);

    System.out.println("Employee inserted successfully.");
  }

  private static void deleteEmployee(Stack<Employee> employeeStack) {
    if (!employeeStack.isEmpty()) {
      Employee removedEmployee = employeeStack.pop();
      System.out.println("Employee deleted: " + removedEmployee);
    } else {
      System.out.println("No employee to delete. Stack is empty.");
    }
  }

  private static void displayEmployees(Stack<Employee> employeeStack) {
    System.out.println("Employee List:");
    for (Employee employee : employeeStack) {
      System.out.println("Employee Number: " + employee.getEmpNumber());
      System.out.println("Employee Name: " + employee.getFullName());
    }
  }

  private static void searchEmployee(Stack<Employee> employeeStack) {
    if (!employeeStack.isEmpty()) {
      Employee topEmployee = employeeStack.peek();
      System.out.println("Top employee: " + topEmployee);
    } else {
      System.out.println("No employee found. Stack is empty.");
    }
  }
}

class Employee {
  private String fullName;
  private String empNumber;

  public Employee(String fullName, String empNumber) {
    this.fullName = fullName;
    this.empNumber = empNumber;
  }

  public String getEmpNumber() {
    return empNumber;
  }

  public String getFullName() {
    return fullName;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "fullName='" + fullName + '\'' +
        ", empNumber='" + empNumber + '\'' +
        '}';
  }
}