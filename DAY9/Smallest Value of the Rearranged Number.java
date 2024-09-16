class Solution {
    public long smallestNumber(long num) {
        // Convert the number to a String to access digits
        String str = String.valueOf(Math.abs(num)); // Get the absolute value to deal with the digits
        
        // Convert the string to a character array for sorting
        char[] digits = str.toCharArray();
        
        // If the number is positive, sort in ascending order
        if (num >= 0) {
            Arrays.sort(digits);
            
            // If there are any leading zeros after sorting, find the first non-zero digit
            if (digits[0] == '0') {
                for (int i = 1; i < digits.length; i++) {
                    if (digits[i] != '0') {
                        // Swap the first non-zero digit with the first digit
                        char temp = digits[0];
                        digits[0] = digits[i];
                        digits[i] = temp;
                        break;
                    }
                }
            }
            
            // Convert the sorted character array back to a number
            return Long.parseLong(new String(digits));
        } 
        
        // If the number is negative, sort in descending order
        else {
            // Sort in descending order by reversing the natural ascending order
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            sb.reverse(); // Reverse the sorted digits
            
            // Convert the string back to a negative number
            return -Long.parseLong(sb.toString());
        }
    }
}
