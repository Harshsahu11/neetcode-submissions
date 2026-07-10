class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i=0;i<n;i++){
            double timeToTarget = (double)(target-position[i])/speed[i];
            cars[i][1] =  timeToTarget;
            cars[i][0] = position[i];
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));

        int fleets = 0;
        double maxTime = 0.0;

        for(int i=0;i<n;i++){
            double currentTime = cars[i][1];
            if(currentTime>maxTime){
                fleets++;
                maxTime=currentTime;
            }
        }
        return fleets;
    }
}
