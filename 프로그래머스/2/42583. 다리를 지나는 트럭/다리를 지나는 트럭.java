import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);

        int truck_index = 0;

        for (int time = 1; ; time++) {
            bridge.go();

            if (truck_index < truck_weights.length &&
                bridge.add(new Truck(truck_weights[truck_index]))) {
                truck_index++;
            }

            if (truck_index == truck_weights.length && bridge.trucks.isEmpty()) {
                return time;
            }
        }
    }

    static class Bridge {
        int length;
        int weight;
        List<Truck> trucks = new ArrayList<>();

        public Bridge(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }

        public boolean add(Truck truck) {
            if (weight - getTotal() < truck.weight) {
                return false;
            }
            trucks.add(truck);
            return true;
        }

        public void go() {
            trucks.forEach(Truck::go);
            trucks.removeIf(truck -> truck.distance >= length);
        }

        private int getTotal() {
            return trucks.stream()
                    .mapToInt(t -> t.weight)
                    .sum();
        }
    }

    static class Truck {
        int weight;
        int distance = 0;

        public Truck(int weight) {
            this.weight = weight;
        }

        public void go() {
            distance++;
        }
    }
}
