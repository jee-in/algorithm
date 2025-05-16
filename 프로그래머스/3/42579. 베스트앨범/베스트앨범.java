import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르 맵 생성 [장르, 노래 (고유 번호, 재생 수)]
        Map<String, List<Song>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int played = plays[i];
            
            List<Song> songs = genreMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new Song(i, played));
            genreMap.put(genre, songs);
        }
        
        // 장르 정렬
        List<Map.Entry<String, List<Song>>> entryList = new ArrayList<>(genreMap.entrySet());
        entryList.sort(Comparator.comparingInt(
                        (Map.Entry<String, List<Song>> entry) -> 
                            entry.getValue().stream().mapToInt(song -> song.played).sum()
                      )
                      .reversed());
                
        // 장르 내 노래 정렬
        for (Map.Entry<String, List<Song>> entry : entryList) {
            List<Song> songs = entry.getValue();
            songs.sort((a, b) -> {
                if (a.played != b.played) return Integer.compare(b.played, a.played);
                return Integer.compare(a.no, b.no);
            });
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).no);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {
    int no;
    int played;
    
    public Song (int no, int played) {
        this.no = no;
        this.played = played;
    }
    
    public String toString() {
        return "Song { " + "no: " + no + ", played: " + played  + " }"; 
    }
}