package week7;

public class assg02 {
    //sort on eif
    static void sort(Employee[] employees, int[] eifValues) {
        int n = employees.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (eifValues[j] > eifValues[j + 1]) {
                    // Sswap EIF values
                    int tempEif = eifValues[j];
                    eifValues[j] = eifValues[j + 1];
                    eifValues[j + 1] = tempEif;
                    
                    // swap ppl
                    Employee tempEmp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = tempEmp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Create 
        Employee[] employees = {
            new Employee(45),  // older 
            new Employee(25),  // young 
            new Employee(18),  // very young 
            new Employee(35),  // middle-aged
            new Employee(50)   //oldest 
        };
        
        // calcuulating
        int[] eifValues = new int[5];
        for (int i = 0; i < 5; i++) {
            Employee e = employees[i];
            eifValues[i] = e.driveCar() + e.driveBike() + e.sing() + e.officeWork();
            System.out.println("Employee " + i + " age " + e.age + " EIF: " + eifValues[i]);
        }
        
        // Sort
        System.out.println("\nSorting employees by EIF...");
        sort(employees, eifValues);
        
        //PRINT
        System.out.println("\nEmployees sorted by EIF:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Employee age " + employees[i].age +", EIF: " + eifValues[i]);
        }
    }
}
