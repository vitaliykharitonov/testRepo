package HomeWorkLesson3;

public class CurrencyConverter {
    private double commission;
    private double exchangeRate;

    public CurrencyConverter(double commission, double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }
    public double calculateTotalAmount(int usdAmount) {
        double uahAmount = Math.round(convertUsdToUah(usdAmount));
        System.out.println("Converted amount is: " + uahAmount + " UAH");
        double commissionAmount = (double) Math.round(calculateCommission(uahAmount) * 100) / 100;
        System.out.println("Commission is: " + commissionAmount + " UAH");
        return uahAmount - commissionAmount;
    }
    private double convertUsdToUah(int usdAmount) {
        return usdAmount * exchangeRate;
    }
    private double calculateCommission(double uahAmount) {
        return uahAmount * commission;
    }
}
