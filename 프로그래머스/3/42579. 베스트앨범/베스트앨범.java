import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Musics musics = new Musics();
        for(int i = 0; i < plays.length; i++) {
            musics.add(genres[i], new Music(i, plays[i]));
        }
        
        List<Music> topMusics = musics.getTopMusics();
        
        return topMusics.stream().mapToInt(music -> music.id).toArray();
    }
    
    static class Musics {
        Map<String, List<Music>> musics = new HashMap<>();
        
        public void add(String genre, Music music) {
            List<Music> musicList = musics.get(genre);
            if(musicList == null) {
                musicList = new ArrayList<>();
            }
            musicList.add(music);
            musics.put(genre, musicList);
        }
        
        public List<Music> getTopMusics() {
            List<Music> topMusics = new ArrayList<>();
            List<List<Music>> musicLists= new ArrayList<>(musics.values());
            musicLists.sort(new Comparator<List<Music>>() {
                @Override
                public int compare(List<Music> o1, List<Music> o2) {
                    return o2.stream().mapToInt(music -> music.plays).sum() 
                        - o1.stream().mapToInt(music -> music.plays).sum();
                }
            });
            for(List<Music> topMusicList : musicLists) {
                topMusicList.sort(new Comparator<Music>() {
                    @Override
                    public int compare(Music o1, Music o2) {
                        return o2.plays - o1.plays;
                    }
                });
                topMusics.add(topMusicList.get(0));
                if(topMusicList.size() > 1) {
                    topMusics.add(topMusicList.get(1));
                }
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