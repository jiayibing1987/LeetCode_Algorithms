package contest;

public class CalculateAmountPaidinTaxes {

    public double calculateTax(int[][] brackets, int income) {
        int preT = 0;

        double tax = 0;
        for (int[] cur : brackets) {
            double temp = (double) (Math.min(cur[0], income) - preT) * ((double) cur[1] / 100d);
            tax += temp;
            preT = cur[0];
            if (income <= cur[0]) break;
        }
        return tax;
    }

    public static void main(String[] args) {
        CalculateAmountPaidinTaxes c = new CalculateAmountPaidinTaxes();
        int[][] a1 = new int[][] {{3,50},{7,10},{12,25}};
        System.out.println(c.calculateTax(a1, 10));
    }
}
