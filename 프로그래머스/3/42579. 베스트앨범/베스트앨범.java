import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        // 1. 장르별 총 재생 수와 노래 리스트 구성
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 총 재생 수 누적
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            // 노래 리스트에 추가
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        // 2. 장르를 총 재생 수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalPlays.get(g2) - genreTotalPlays.get(g1));

        // 3. 결과 수록곡 리스트
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            // 노래를 재생 수 내림차순, 고유번호 오름차순 정렬
            songs.sort((s1, s2) -> {
                if (s2.play != s1.play) return s2.play - s1.play;
                return s1.id - s2.id;
            });

            // 최대 2곡까지 수록
            bestAlbum.add(songs.get(0).id);
            if (songs.size() > 1) {
                bestAlbum.add(songs.get(1).id);
            }
        }

        // 결과 리스트를 배열로 변환
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        int id;
        int play;

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}
