import java.util.Scanner;

public class Main {
    static Egg[] eggs;
    static int n;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();
            eggs[i] = new Egg(d, w);
        }

        solve(0);
        System.out.println(result);
    }

    private static void solve(int index) {
        if(index == n) {
            int broken = 0;
            for(int i = 0; i < eggs.length; i++) {
                if(eggs[i].isBroken()) {
                    broken++;
                }
            }
            result = Math.max(broken, result);
            return;
        }

        Egg current = eggs[index];
        if(current.isBroken()) {
            solve(index + 1);
        }
        else {
            boolean hit = false;
            for(int i = 0; i < n; i++) {
                if(i == index) {
                    continue;
                }
                Egg other = eggs[i];
                if(!eggs[i].isBroken()) {
                    hit = true;
                    current.hit(other);
                    solve(index + 1);
                    current.rollback(other);
                }
            }

            if(!hit) {
                solve(index + 1);
            }
        }
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public void hit(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        public void rollback(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }

        public boolean isBroken() {
            return durability <= 0;
        }
    }
}