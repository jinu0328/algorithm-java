import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int initialNum = Integer.parseInt(br.readLine());
            int check = 0;
            for(int i = 2; i <= 64; i++) {
                int num = initialNum;
                List<Integer> nums = new ArrayList<>();

                while(num > 0) {
                    nums.add(num % i);
                    num /= i;
                }

                check = checkSame(nums);
                if(check == 1) {
                    break;
                }
            }
            bw.write(check + "\n");
        }

        bw.flush();
    }

    private static int checkSame(List<Integer> nums) {
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) != nums.get(nums.size() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }
}


