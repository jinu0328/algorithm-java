import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Genres myGenres = new Genres();

        for (int i = 0; i < plays.length; i++) {
            myGenres.add(genres[i], new Music(i, plays[i]));
        }

        List<Music> topMusics = myGenres.getTopMusics();

        return topMusics.stream()
                .mapToInt(music -> music.id)
                .toArray();
    }

    static class Genres {
        private final Map<String, Genre> genres = new HashMap<>();

        public void add(String genreName, Music music) {
            Genre genre = genres.get(genreName);

            if (genre == null) {
                genre = new Genre();
                genres.put(genreName, genre);
            }

            genre.add(music);
        }


        public List<Music> getTopMusics() {
            List<Music> result = new ArrayList<>();

            List<Genre> genreList = new ArrayList<>(genres.values());

            genreList.sort((g1, g2) -> g2.totalPlay - g1.totalPlay);

            for (Genre genre : genreList) {
                List<Music> topMusics = genre.getTopMusics();
                result.addAll(topMusics);
            }

            return result;
        }
    }

    static class Genre {
        private int totalPlay = 0;
        private final List<Music> musics = new ArrayList<>();

        public void add(Music music) {
            musics.add(music);
            totalPlay += music.plays;
        }

        public List<Music> getTopMusics() {
            List<Music> topMusics = new ArrayList<>();
            musics.sort((m1, m2) -> m2.plays - m1.plays);
            
            topMusics.add(musics.get(0));
            
            if (musics.size() > 1) {
                topMusics.add(musics.get(1));
            }
            
            return topMusics;
        }
    }

    static class Music {
        int id;
        int plays;

        public Music(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
}
