import java.util.InputMismatchException; // Importing InputMismatchException class for handling input errors
import java.util.Scanner; // Importing Scanner class to read input from the user

public class XYZBank { // Class declaration

    public static void main(String[] args) { // Main method
        Scanner scanner = new Scanner(System.in); // Creating Scanner object for input

        int maxRecords = 0; // Initializing variable to store maximum number of records
        while (maxRecords <= 0) { // Loop to ensure a positive integer for maximum records
            try { // Handling potential input mismatch exceptions
                System.out.print("Enter the maximum number of records: "); // Prompting user for input
                maxRecords = scanner.nextInt(); // Reading maximum records input
                if (maxRecords <= 0) { // Checking if input is non-positive
                    System.out.println("Please enter a positive integer."); // Prompting user for positive input
                }
            } catch (InputMismatchException e) { // Catching input mismatch exceptions
                System.out.println("Invalid input. Please enter a positive integer."); // Prompting user for valid input
                scanner.next(); // Clearing invalid input
            }
        }
        scanner.nextLine(); // Clearing the input buffer

        Record[] records = new Record[maxRecords]; // Creating an array to store records
        int completedRecords = 0; // Variable to keep track of completed records

        String continueOption = "Yes"; // Variable to control continuation of record entry
        while (completedRecords < maxRecords && (continueOption.equalsIgnoreCase("Yes"))) { // Loop for entering records
            System.out.println("Enter details for record " + (completedRecords + 1) + ":"); // Prompting for record details

            System.out.print("Record ID (XXXXXX): "); // Prompting for record ID
            String recordID = scanner.nextLine(); // Reading record ID input
            while (!recordID.matches("\\d{6}")) { // Loop to validate record ID format
                System.out.print("Invalid input. Please enter a 6-digit number: "); // Prompting for valid input
                recordID = scanner.nextLine(); // Reading record ID input again
            }

            System.out.print("Customer ID (AAAXXX): "); // Prompting for customer ID
            String customerID = scanner.nextLine(); // Reading customer ID input
            while (!customerID.matches("[A-Z]{3}\\d{3}")) { // Loop to validate customer ID format
                System.out.print("Invalid input. Please enter in the format AAAXXX: "); // Prompting for valid input
                customerID = scanner.nextLine(); // Reading customer ID input again
            }

            String loanType; // Variable to store loan type
            do { // Loop to ensure valid loan type input
                System.out.print("Loan Type (Auto/Builder/Mortgage/Personal/Other): "); // Prompting for loan type
                loanType = scanner.nextLine().trim(); // Reading loan type input and trimming whitespace
                if (!loanType.equals("Auto") && !loanType.equals("Builder") && !loanType.equals("Mortgage") && !loanType.equals("Personal") && !loanType.equals("Other")) { // Checking for valid loan type
                    System.out.println("Invalid loan type. Please enter one of the specified types."); // Prompting for valid input
                }
            } while (!loanType.equals("Auto") && !loanType.equals("Builder") && !loanType.equals("Mortgage") && !loanType.equals("Personal") && !loanType.equals("Other")); // Loop condition

            double interestRate = 0; // Variable to store interest rate
            while (interestRate <= 0) { // Loop to ensure positive interest rate input
                try { // Handling potential input mismatch exceptions
                    System.out.print("Interest Rate: "); // Prompting for interest rate
                    interestRate = scanner.nextDouble(); // Reading interest rate input
                    if (interestRate <= 0) { // Checking for non-positive input
                        System.out.println("Please enter a positive interest rate."); // Prompting for valid input
                    }
                } catch (InputMismatchException e) { // Catching input mismatch exceptions
                    System.out.println("Invalid input. Please enter a valid number."); // Prompting for valid input
                    scanner.next(); // Clearing invalid input
                }
            }

            double AmountLeft = 0; // Variable to store amount left to pay
            while (AmountLeft <= 0) { // Loop to ensure positive amount left input
                try { // Handling potential input mismatch exceptions
                    System.out.print("Amount Left to Pay (in thousands pounds): "); // Prompting for amount left
                    AmountLeft = scanner.nextDouble(); // Reading amount left input
                    if (AmountLeft <= 0) { // Checking for non-positive input
                        System.out.println("Please enter a positive amount."); // Prompting for valid input
                    }
                } catch (InputMismatchException e) { // Catching input mismatch exceptions
                    System.out.println("Invalid input. Please enter a valid number."); // Prompting for valid input
                    scanner.next(); // Clearing invalid input
                }
            }

            int termYears = 0; // Variable to store term in years
            while (termYears <= 0) { // Loop to ensure positive term input
                try { // Handling potential input mismatch exceptions
                    System.out.print("Term in Years: "); // Prompting for term in years
                    termYears = scanner.nextInt(); // Reading term input
                    if (termYears <= 0) { // Checking for non-positive input
                        System.out.println("Please enter a positive number of years."); // Prompting for valid input
                    }
                } catch (InputMismatchException e) { // Catching input mismatch exceptions
                    System.out.println("Invalid input. Please enter a valid number."); // Prompting for valid input
                    scanner.next(); // Clearing invalid input
                }
            }

            records[completedRecords] = new Record(recordID, customerID, loanType, interestRate, AmountLeft, termYears); // Creating new record object
            completedRecords++; // Incrementing completed records count

            if (completedRecords < maxRecords) { // Checking if more records can be registered
                System.out.print("Do you want to register another file? (Yes/No): "); // Prompting for continuation
                continueOption = scanner.next(); // Reading continuation option
                while (!(continueOption.equalsIgnoreCase("Yes") || continueOption.equalsIgnoreCase("No"))) { // Loop to ensure valid input for continuation
                    System.out.println("Invalid input. Please enter Yes or No."); // Prompting for valid input
                    System.out.print("Do you want to register another file? (Yes/No): "); // Prompting for continuation
                    continueOption = scanner.next(); // Reading continuation option again
                }

                scanner.nextLine(); // Clearing input buffer
            }
        }


        System.out.println("\nMaximum number of records: " + maxRecords); // Printing the maximum number of records
        System.out.println("Registered records: " + completedRecords); // Printing the number of registered records
        System.out.println("------------------------------------------------------------------------------------------"); // Printing a separator line
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Record ID", "Customer ID", "Loan Type", "Interest Rate", "Amount Left", "Term Years"); // Printing headers for record details
        System.out.println("------------------------------------------------------------------------------------------"); // Printing a separator line
        for (Record record : records) { // Looping through each record in the records array
            if (record != null) { // Checking if the record is not null
                System.out.printf("%-15s %-15s %-15s %-15.2f %-15.2f %-15d\n", record.getRecordID(), record.getCustomerID(), record.getLoanType(), record.getInterestRate(), record.getAmountLeft(), record.getTermYears()); // Printing record details
            }
        }
        System.out.println("------------------------------------------------------------------------------------------"); // Printing a separator line

        scanner.close(); // Closing the Scanner object to prevent resource leak
    }
}