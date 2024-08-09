import java.util.*;

class Account {
    String acc_no, name, address, phone, dob;
    double balance;

    public Account(String ac, String n, String ad, String p, String d, double bal) {
        acc_no=ac;
        name=n;
        address=ad;
        phone=p;
        dob=d;
        balance=bal;
    }

    public String getAccountNumber() {
        return acc_no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double new_balance) {
        balance=new_balance;
    }

    public String toString() {
        return "[Name : "+name+" Account no. : "+acc_no+" address : "+address+" Phone : "+phone+" DOB : "+dob+" Balance : "+balance+"]";
    }
}


class SavingsAccount extends Account {
    public SavingsAccount(String ac, String n, String ad, String p, String d, double bal) {
        super(ac, n, ad, p, d, bal);
    }

    public double deposit(double amount) {
        setBalance(balance+amount);
        return getBalance();
    }

    public double withdraw(double amount) {
        if(amount<=balance) {
            setBalance(balance-amount);
            return getBalance();
        }
        else {
            System.out.println("Insufficient balance. Try depositing");
            return getBalance();
        }
    }
}


class LoanAccount extends Account {
    double loan;

    public LoanAccount(String ac, String n, String ad, String p, String d, double bal, double l) {
        super(ac, n, ad, p, d, bal);
        loan=l;
    }

    public double initiateLoan() {
        setBalance(balance+loan);
        return getBalance();
    }

    public double getLoan() {
        return loan;
    }

    public double topUp(double new_loan) {
        loan+=new_loan;
        setBalance(balance+loan);
        return getBalance();
    }

    public double settleLoan() {
        setBalance(balance-loan);
        loan=0;
        return getBalance();
    }

    public String toString() {
        return "[Name : "+name+" Account no. : "+acc_no+" address : "+address+" Phone : "+phone+" DOB : "+dob+" Balance : "+balance+" Loan = "+loan+"]";
    }
}



/**
 * SavingsAndLoanAccount
 */
public class SavingsAndLoanAccount {

    public static void main(String[] args) {
        String choice=null, cont=null;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Select banking operation :-");
            choice=sc.nextLine();
            switch(choice.toLowerCase()) {
                case "savings account":
                    savingsOperations();
                    break;
                case "loan account":
                    loanOperations();
                    break;
                default:
                    System.out.println("Account does not exist");
            }
            System.out.println("Continue banking?");
            cont=sc.nextLine();
        } while(!cont.toLowerCase().equals("no"));
        System.out.println("\nSystem terminated");
    }

    public static void savingsOperations() {
        Scanner sc=new Scanner(System.in);
        SavingsAccount savings=null;
        String choice=null, cont=null;
        do {
            System.out.println("Enter savings operations :-");
            choice=sc.nextLine();
            switch(choice.toLowerCase()) {
                case "create account":
                    System.out.println("Enter account number :-");
                    String acc_no=sc.nextLine();
                    System.out.println("Enter name :-");
                    String name=sc.nextLine();
                    System.out.println("Enter address :-");
                    String address=sc.nextLine();
                    System.out.println("Enter phone no. :-");
                    String phone=sc.nextLine();
                    System.out.println("Enter DOB :-");
                    String dob=sc.nextLine();
                    System.out.println("Enter openning balance :-");
                    double balance=sc.nextDouble();
                    sc.nextLine();
                    savings=new SavingsAccount(acc_no, name, address, phone, dob, balance);
                    System.out.println("Savings account created."+savings.toString());
                    break;
                case "deposit":
                    System.out.println("Enter deposit amount :-");
                    double dep=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Balance = "+savings.deposit(dep));
                    break;
                case "withdraw":
                    System.out.println("Enter withdrawal amount :-");
                    double with=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Balance = "+savings.withdraw(with));
                    break;
                case "close account":
                    savings=null;
                    System.out.println("Account closed.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println("Continue with savings account?");
            cont=sc.nextLine();
        } while(!cont.toLowerCase().equals("no"));
    }

    public static void loanOperations() {
        Scanner sc=new Scanner(System.in);
        String choice=null, cont=null;
        LoanAccount loan_var=null;
        do {
            System.out.println("Enter loan operations :-");
            choice=sc.nextLine();
            switch(choice.toLowerCase()) {
                case "create account":
                    System.out.println("Enter account number :-");
                    String acc_no=sc.nextLine();
                    System.out.println("Enter name :-");
                    String name=sc.nextLine();
                    System.out.println("Enter address :-");
                    String address=sc.nextLine();
                    System.out.println("Enter phone no. :-");
                    String phone=sc.nextLine();
                    System.out.println("Enter DOB :-");
                    String dob=sc.nextLine();
                    System.out.println("Enter openning balance :-");
                    double balance=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter loan amount :-");
                    double loan_amt=sc.nextDouble();
                    sc.nextLine();
                    loan_var=new LoanAccount(acc_no, name, address, phone, dob, balance, loan_amt);
                    System.out.println("Loan account created."+loan_var.toString());
                    break;
                case "new loan":
                    System.out.println("Loan initiated. Balance = "+loan_var.initiateLoan());
                    break;
                case "top up":
                    System.out.println("Enter top up amount :-");
                    double amt=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Top up successful. Balance = "+loan_var.topUp(amt));
                    break;
                case "view loan":
                    System.out.println("Current loan = "+loan_var.getLoan());
                    break;
                case "settle":
                    System.out.println("Loan settled. Balance = "+loan_var.settleLoan());
                    System.out.println("Current loan = "+loan_var.getLoan());
                    break;
                case "close account":
                    loan_var=null;
                    System.out.println("Account closed.");
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            System.out.println("Continue with loan account?");
            cont=sc.nextLine();
        } while(!cont.toLowerCase().equals("no"));
    }
}