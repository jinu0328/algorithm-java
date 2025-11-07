import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int space = brown + yellow;

        for (int height = 3; height <= space; height++) {
            if (space % height == 0) {
                int width = space / height;
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[0];
    }
}
