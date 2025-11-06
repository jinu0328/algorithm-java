import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] rawNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            rawNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(rawNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if(rawNumbers[0].equals("0")) {
            return "0";
        }
        
        String result = "";
        for(String s : rawNumbers) {
            result += s;
        }
        return result;
    }
}