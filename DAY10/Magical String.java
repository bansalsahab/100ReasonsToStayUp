class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; 

        int[] magical = new int[n + 1];
        magical[0] = 1;
        magical[1] = 2;
        magical[2] = 2;

        int head = 2; 
        int tail = 3; 
        int num = 1; 

        int countOnes = 1;
        while (tail < n) {
            for (int i = 0; i < magical[head] && tail < n; i++) {
                magical[tail] = num;
                if (num == 1) {
                    countOnes++;
                }
                tail++;
            }
            num = num == 1 ? 2 : 1; 
            head++;
        }

        return countOnes;
    }
}
