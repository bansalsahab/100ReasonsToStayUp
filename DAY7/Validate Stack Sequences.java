class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n =pushed.length;
        int i =0;
        int j =0 ;
        Stack<Integer> st =  new Stack<>();
        while(i<n && j<n){
            st.push(pushed[i]);
            while(!st.isEmpty() && j<n &&  st.peek() == popped[j] ){
                st.pop();
                j++;
            }
            i++;
        }  
        return st.isEmpty();

    }
}
