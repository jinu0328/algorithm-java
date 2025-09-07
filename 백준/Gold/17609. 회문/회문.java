import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            char[] s = br.readLine().toCharArray();
            int i = 0;
            int j = s.length - 1;

            int result = 0;
            while(i <= j) {
                if(s[i] == s[j]) {
                    i++;
                    j--;
                }
                else {
                    if(checkP(i + 1, j, s) || checkP(i, j - 1, s)) {
                        result = 1;
                        break;
                    } else {
                        result = 2;
                        break;
                    }
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
    }

    private static boolean checkP(int i, int j, char[] s) {
        int l = i;
        int h = j;
        while(l <= h) {
            if(s[l] == s[h]) {
                l++;
                h--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
