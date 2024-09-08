class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed.length == 1 || flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } 
                else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } 
                else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                if (n == 0) {
                    return true;
                }
            }
        }
        return n <= 0; 
    }
}
