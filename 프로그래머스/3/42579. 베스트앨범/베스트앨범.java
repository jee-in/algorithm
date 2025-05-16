import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르 맵 생성 [장르, 노래(인덱스, 재생 수, 장르)]
        Map<String, List<Song>> genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int played = plays[i];
        
            List<Song> songs = genreMap.getOrDefault(genre, new ArrayList<>());  
            songs.add(new Song(i, played));
            genreMap.put(genre, songs);
        }
        
        // 장르에 속해 있는 노래 재생 수의 합의 내림차순 정렬
        Set<Map.Entry<String, List<Song>>> entrySet = genreMap.entrySet();
        List<Map.Entry<String, List<Song>>> entryList = new ArrayList<>(entrySet);
                
        entryList.sort(
            Comparator.comparingInt(
                entry -> entry.getValue().stream().mapToInt(song -> song.played).sum()
            )
        );
        
        // 장르별로 재생 수가 많은 노래 내림차순 정렬, 2개 선택
        for (int i = entryList.size() - 1; i >= 0; i--) {
            
            List<Song> songs = entryList.get(i).getValue();
            songs.sort((a, b) -> {
                if (a.played != b.played) return Integer.compare(b.played, a.played);
                return Integer.compare(a.no, b.no);
            });
            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                Song song = songs.get(j);
                answer.add(song.no);
            }
        }
                
        System.out.println(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {
    int no;
    int played;
    // String genre;
    
    public Song(int no, int played) {
        this.no = no;
        this.played = played;
    }
    
    @Override
    public String toString() {
        return "Song { " + "no: " + no + ", played: " + played + " }";    
    }
}