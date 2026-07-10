class Car{
    int position;
    double time;
    Car(int position,double time){
        this.position = position;
        this.time = time;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for(int i=0;i<n;i++){
            double timeToTarget = (double)(target-position[i])/speed[i];
            cars[i] = new Car(position[i],timeToTarget);
        }

        Arrays.sort(cars,(a,b)->Integer.compare(b.position,a.position));

        Stack<Double> st = new Stack();

        for(Car car : cars){
            if(st.isEmpty() || car.time>st.peek()){
                st.push(car.time);
            }
        }
        return st.size();
    }
}
