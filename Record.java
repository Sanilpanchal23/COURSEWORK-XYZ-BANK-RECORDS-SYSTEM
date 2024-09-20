import java.util.Scanner;

public class Record { // Define a class named Record

    // Declare private instance variables for the Record class
    private String recordID;
    private String customerID;
    private String loanType;
    private double interestRate;
    private double AmountLeft; // Variable naming convention should start with lowercase
    private int termYears;

    // Constructor for the Record class
    public Record(String recordID, String customerID, String loanType, double interestRate, double AmountLeft, int termYears) {
        // Initialize instance variables with values passed to the constructor
        this.recordID = recordID;
        this.customerID = customerID;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.AmountLeft = AmountLeft;
        this.termYears = termYears;
    }

    // Method to update record information
    public void updateRecord(String recordID, String customerID, String loanType, double interestRate, double AmountLeft, int termYears) {
        // Update instance variables with new values passed to the method
        this.recordID = recordID;
        this.customerID = customerID;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.AmountLeft = AmountLeft;
        this.termYears = termYears;
    }

    // Method to read and update record information from user input
    public void readAndUpdateRecordFromInput(Scanner scanner) {
        try {
            System.out.print("Enter Record ID: ");
            this.recordID = scanner.nextLine(); // Read user input for record ID
            System.out.print("Enter Customer ID: ");
            this.customerID = scanner.nextLine(); // Read user input for customer ID
            System.out.print("Enter Loan Type: ");
            this.loanType = scanner.nextLine(); // Read user input for loan type
            System.out.print("Enter Interest Rate: ");
            this.interestRate = scanner.nextDouble(); // Read user input for interest rate
            System.out.print("Enter Amount Left to Pay: ");
            this.AmountLeft = scanner.nextDouble(); // Read user input for amount left to pay
            System.out.print("Enter Term in Years: ");
            this.termYears = scanner.nextInt(); // Read user input for term in years
        } catch (Exception e) {
            // Catch and handle any exceptions that occur during input reading
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    // Getter method for record ID
    public String getRecordID() {
        return recordID;
    }

    // Setter method for record ID
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    // Getter method for customer ID
    public String getCustomerID() {
        return customerID;
    }

    // Setter method for customer ID
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Getter method for loan type
    public String getLoanType() {
        return loanType;
    }

    // Setter method for loan type
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    // Getter method for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter method for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter method for amount left to pay
    public double getAmountLeft() {
        return AmountLeft;
    }

    // Setter method for amount left to pay
    public void setAmountLeft(double AmountLeft) {
        this.AmountLeft = AmountLeft;
    }

    // Getter method for term in years
    public int getTermYears() {
        return termYears;
    }

    // Setter method for term in years
    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }
}