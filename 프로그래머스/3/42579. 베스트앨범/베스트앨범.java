import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르별 맵 생성 [장르, 노래(인덱스, 재생 수)]
        Map<String, List<Song>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int played = plays[i];
            
            List<Song> songs = genreMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new Song(i, played));
            genreMap.put(genre, songs);
        }
        
        // 장르 정렬 (기준: 노래 재생수의 합) (내림차순)
        List<Map.Entry<String, List<Song>>> songList = new ArrayList<>(genreMap.entrySet());
        System.out.println(songList);
        songList.sort(Comparator.comparingInt(
            (Map.Entry<String, List<Song>> entry) -> 
                entry.getValue().stream().mapToInt(song -> song.played).sum()
        ).reversed());

        
        // 장르를 순회하면서 노래 정렬 (기준: 노래 재생 수 (내림차순), 고유 번호(오름차순))
        for (int i = 0; i < songList.size(); i++) {
            List<Song> songs = songList.get(i).getValue();
            songs.sort((a, b) -> {
                if (a.played != b.played) return Integer.compare(b.played, a.played);
                return Integer.compare(a.no, b.no);
            });
            
            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                answer.add(songs.get(j).no);
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
    
    @Override
    public String toString() {
        return "Song { " + "no: " + no + ", played: " + played + "}";
    }
}