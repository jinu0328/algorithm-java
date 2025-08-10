class Solution {
    public int[] solution(int brown, int yellow) {
        int height;
        int width;
        
        for(int i = 1; ; i++) {
            height = i;
            if(yellow % height != 0) {
                continue;
            }
            width = yellow / height;
            
            if((width + 2) * (height + 2) == brown + yellow) {
                break;
            }
        }
        
        int[] result = new int[2];
        result[0] = width + 2;
        result[1] = height + 2;
        
        return result;
    }
}