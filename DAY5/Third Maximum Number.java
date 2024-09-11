public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        boolean hasThird = false;

        for (int num : nums) {

            if (num == first || num == second || num == third) {
                continue;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
                hasThird = true;
            }
        }

        return (third != Long.MIN_VALUE) ? (int) third : (int) first;

        
    }
}
  
