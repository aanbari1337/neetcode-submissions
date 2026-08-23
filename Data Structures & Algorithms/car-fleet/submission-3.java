class Solution {
     private class Car {
        int position;
        int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        
        // time = (target - position) / speed

       Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));

        Deque<Car> stack = new ArrayDeque<>();

        for(Car car : cars){
            if(!stack.isEmpty() && (double)(target - stack.peek().position) / stack.peek().speed  >= (double)(target - car.position) / car.speed){
                continue;
            }
            stack.push(car);
        }
        return stack.size();
    }
}
