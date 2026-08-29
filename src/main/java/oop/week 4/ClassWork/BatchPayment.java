class FeeAccount {
    String type = "FeeAccount";
}

class HostelFeeAccount extends FeeAccount {
}

public class BatchPayment {
    static int hostelCount = 0;
    static int dayScholarCount = 0;

    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            hostelCount++;
            System.out.println("Paid in two installments (hostel account)");
        } else {
            dayScholarCount++;
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static void main(String[] args) {
        BatchPayment batch = new BatchPayment();
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        for (FeeAccount acc : accounts) {
            batch.processPayment(acc, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}