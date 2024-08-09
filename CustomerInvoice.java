import java.util.*;

class Customer {
    private int id, discount;
    private String name;

    public Customer(int i, int d, String n) {
        id=i;
        discount=d;
        name=n;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int new_discount) {
        discount=new_discount;
    }

    public String toString() {
        return name+"( "+id+" )"+" "+discount+"%.";
    }
}


class Invoice {
    private int invoice_id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer c, double a) {
        invoice_id=id;
        customer=c;
        amount=a;
    }

    public int getID() {
        return invoice_id;
    }

    public String getCustomer() {
        return customer.toString();
    }

    public void setCustomer(Customer cust1) {
        customer=cust1;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double new_amount) {
        amount=new_amount;
    }

    public int getCustomerID() {
        return customer.getID();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount() {
        int discount=getCustomerDiscount();
        double final_amt=(amount-((discount/100.0)*amount));
        final_amt=Double.parseDouble(String.format("%.2f", final_amt));
        return final_amt;
    }

    public String toString() {
        return "Invoice [ ID = "+invoice_id+" customer = "+customer.toString()+" Payable = "+getAmountAfterDiscount()+"]";
    }
}


class CustomerInvoice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String choice, name, cont;
        int id, discount;
        double amount;
        Invoice bill=null;
        Customer customer=null;
        do {
            System.out.println("Enter operation :-");
            choice=sc.nextLine();
            sc.nextLine();
            switch(choice.toLowerCase()) {
                case "create customer":
                    System.out.println("Enter customer name :-");
                    name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter customer ID : ");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter discount percentage :-");
                    discount=sc.nextInt();
                    sc.nextLine();
                    customer=new Customer(id, discount, name);
                    System.out.println("Customer account created.");
                    break;
                case "generate invoice":
                    if(customer==null) {
                        System.out.println("Customer account not present.");
                        break;
                    }
                    System.out.println("Enter invoice ID :-");
                    id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter purchase amount :-");
                    amount=sc.nextDouble();
                    sc.nextLine();
                    bill=new Invoice(id,customer,amount);
                    System.out.println("Invoice generated.");
                    break;
                case "get customer name":
                    System.out.println("Customer name : "+bill.getCustomerName());
                    break;
                case "get customer id":
                    System.out.println("Customer ID : "+bill.getCustomerID());
                    break;
                case "get customer discount":
                    System.out.println("Customer discount = "+bill.getCustomerDiscount());
                    break;
                case "get customer details":
                    System.out.println("Customer details : "+bill.getCustomer());
                    break;
                case "get amount":
                    System.out.println("Payable amount : "+bill.getAmount());
                    break;
                case "set amount":
                    System.out.println("Enter new amount :-");
                    double amt=sc.nextDouble();
                    sc.nextLine();
                    bill.setAmount(amt);
                    System.out.println("New amount added.");
                    break;
                case "get final amount":
                    System.out.println("Final amount = "+bill.getAmountAfterDiscount());
                    break;
                case "print invoice":
                    System.out.println(bill.toString());
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            System.out.println("Do youy want to continue?");
            //sc.nextLine();
            cont=sc.nextLine();
        } while(cont.toLowerCase().equals("yes"));
        System.out.println("\nSystem terminated");
    }
}