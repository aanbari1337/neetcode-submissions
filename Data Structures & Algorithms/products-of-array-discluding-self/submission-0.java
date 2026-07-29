class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        var prefix = 1;
        for (int i = 0;i < nums.length; i++){
            products[i] = prefix;
            prefix *= nums[i];
        }
        var postfix = 1;
        for (int j = nums.length - 1; j >= 0; j--){
            products[j] *= postfix;
            postfix *= nums[j];
        }

        return products;
    }
}  
