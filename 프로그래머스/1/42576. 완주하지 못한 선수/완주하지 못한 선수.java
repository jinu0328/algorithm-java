import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> names = new HashMap<>();
        for(String participantName : participant) {
            names.put(participantName, names.getOrDefault(participantName, 0) + 1);
        }
        
        for(String completedParticipantName : completion) {
            names.put(completedParticipantName, names.get(completedParticipantName) - 1);
            if(names.get(completedParticipantName) == 0) {
                names.remove(completedParticipantName);
            }
        }
        
        String answer = names.keySet().stream()
                .findFirst().get();
        return answer;
    }
}