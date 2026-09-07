class Account {

    String regNo;
    double totalFee;

    Account(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * daysLate * 0.01;
    }

    final void printSummary(int daysLate) {

        if (daysLate <= 0) {

            System.out.println(
                regNo + " - On time, no late fee"
            );

        } else {

            double lateFee =
                calculateLateFee(daysLate);

            System.out.println(
                regNo +
                " | Total Fee: Rs " +
                totalFee +
                " | Late Fee: Rs " +
                lateFee
            );
        }
    }
}

public class LateFeeDemo {

    public static void main(String[] args) {

        Account[] accounts = {
            new Account("RA001", 200000),
            new Account("RA002", 150000),
            new Account("RA003", 180000),
            new Account("RA004", 220000)
        };

        int[] daysLate = {
            10, 0, -2, 5
        };

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].printSummary(daysLate[i]);
        }
    }
}
