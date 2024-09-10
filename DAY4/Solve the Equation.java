class Solution {
    public String solveEquation(String equation) {
        // Split the equation into left and right sides at '='
        String[] sides = equation.split("=");
        String leftSide = sides[0];
        String rightSide = sides[1];
        
        // Process the left and right sides separately
        int[] left = processSide(leftSide);
        int[] right = processSide(rightSide);
        
        // left[0] is coefficient of x on left side, right[0] is for right side
        // left[1] is constant on left side, right[1] is for right side
        
        // Rearrange the equation: move all x terms to the left, constants to the right
        int coefficientX = left[0] - right[0]; // Move right side's x term to left
        int constant = right[1] - left[1];     // Move left side's constant to right
        
        // Handle the cases
        if (coefficientX == 0 && constant == 0) {
            return "Infinite solutions";  // This happens if both sides are the same
        } else if (coefficientX == 0) {
            return "No solution";  // This happens if there's no x term but a non-zero constant
        } else {
            // Solve for x: x = constant / coefficientX
            return "x=" + (constant / coefficientX);
        }
    }
    
    // Helper function to process a side (either left or right) of the equation
    private int[] processSide(String side) {
        int coefficientX = 0;  // Coefficient of x
        int constant = 0;      // Constant term
        int i = 0, sign = 1;   // 'sign' tracks the sign of the current term
        
        while (i < side.length()) {
            if (side.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (side.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            
            int num = 0;
            boolean hasNum = false;
            
            // Parse the number before 'x' or constant
            while (i < side.length() && Character.isDigit(side.charAt(i))) {
                num = num * 10 + (side.charAt(i) - '0');
                i++;
                hasNum = true;
            }
            
            if (i < side.length() && side.charAt(i) == 'x') {
                // If the current term is an 'x' term
                if (!hasNum) {
                    num = 1;  // If there's no number before 'x', it's implicitly 1
                }
                coefficientX += sign * num;
                i++;  // Move past the 'x'
            } else {
                // It's a constant term
                constant += sign * num;
            }
        }
        
        return new int[]{coefficientX, constant};
    }
}
