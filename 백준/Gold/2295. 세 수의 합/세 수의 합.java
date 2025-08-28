import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sums = new int[N * (N + 1) / 2];
        int sumsIndex = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                sums[sumsIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);

        int answer = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if(isExist(sums, target)) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.println(answer);
    }

//    private static boolean isExist(int[] sums, int target) {
//        return Arrays.binarySearch(sums, target) >= 0;
//    }

    private static boolean isExist(int[] sums, int target) {
        int first = 0;
        int last = sums.length - 1;

        while(first <= last) {
            int mid = (first + last) / 2;
            if(sums[mid] == target) {
                return true;
            }
            else if (sums[mid] > target) {
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }
        return false;
    }
}