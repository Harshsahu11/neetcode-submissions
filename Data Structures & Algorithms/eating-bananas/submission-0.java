class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right,pile);
        }

        int originalSpeed = right;

        while(left<=right){
            int mid = left+(right-left)/2;
            long hoursNeeded =0;
            for(int pile : piles){
                hoursNeeded+= (long)Math.ceil((double)pile/mid);
            }
            if(hoursNeeded<=h){
                originalSpeed = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return originalSpeed;
    }
}
