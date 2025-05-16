import java.util.*;

class Solution {
    class Song {
        int no;
        String genre;
        int play;
        
        public Song(int no, String genre, int play) {
            this.no = no;
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public String toString() {
            return "Song { no: " + no + ", genre: " + genre + ", play: " + play + " }";
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, List<Song>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            Song song = new Song(i, genre, play);
            
            List<Song> songs = genreMap.getOrDefault(genre, new ArrayList<>());
            songs.add(song);
            genreMap.put(genre, songs);
        }
        
        List<Map.Entry<String, List<Song>>> entryList = new ArrayList<>(genreMap.entrySet());        
        entryList.sort((a, b) -> {
            int bplay = 0;
            int aplay = 0;
            List<Song> aSongs = a.getValue();
            List<Song> bSongs = b.getValue();
            for (int i = 0; i < aSongs.size(); i++) {
                aplay += aSongs.get(i).play;
            }
            for (int i = 0; i < bSongs.size(); i++) {
                bplay += bSongs.get(i).play;
            }
            
            return bplay - aplay;
        });

        for (Map.Entry<String, List<Song>> genreEntry : entryList) {
            List<Song> songs = genreEntry.getValue();
            songs.sort((a, b) -> {
                if (b.play > a.play) return 1;
                else if (b.play < a.play) return -1;
                else {
                    if (a.no > b.no) return 1;
                    else if (a.no < b.no) return -1;
                    else return 0;
                }
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).no);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}