import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int count = 0;
        int currentWeight = 0;
        Queue<Truck> trucks = new LinkedList<>();
        for(int weights : truck_weights) {
            trucks.add(new Truck(weights));
        }
        List<Truck> running = new ArrayList<>();
        List<Truck> completed = new ArrayList<>();
        while(completed.size() < truck_weights.length) {
            count++;
            if(!trucks.isEmpty()) {
                Truck truck = trucks.peek();
                if(currentWeight + truck.weight <= weight) {
                    Truck currentTruck = trucks.poll();
                    running.add(currentTruck);
                    currentWeight += currentTruck.weight;
                }
            }
            
            for(Truck runningTruck : running) {
                runningTruck.move();
                if(runningTruck.position == bridge_length) {
                    currentWeight -= runningTruck.weight;
                    completed.add(runningTruck);
                }
                
            }
        }
        
        return count + 1;
    }
    
    static class Truck {
        int position = 0;
        int weight;
        
        public Truck(int weight) {
            this.weight = weight;
        }
        
        public void move() {
            position++;
        }
    }
}