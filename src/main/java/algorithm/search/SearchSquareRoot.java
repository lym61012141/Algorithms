package algorithm.search;

public class SearchSquareRoot {

    public static double getSquareRoot(double number, int decimalPlace) {
        double low = 0D;
        double high = number;
        double decimal = Math.pow(0.1D, decimalPlace);
        while (low <= high) {
            double mid = (low + high) / 2;
            double midValue = mid * mid;
            if (midValue - decimal <= number && number <= midValue + decimal) {
                return mid;
            } else if (midValue < number) {
                low = mid;
            } else if (midValue > number) {
                high = mid;
            }
        }
        return 0D;
    }

    public static void main(String[] args) {
        System.out.println(getSquareRoot(128D, 6));
        System.out.println(11.313708484172821D * 11.313708484172821D);
    }
}
