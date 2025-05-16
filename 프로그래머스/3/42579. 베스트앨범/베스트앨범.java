import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르 맵 만들기 [장르, 노래 (인덱스, 재생 수)]
        Map<String, List<Song>> genreMap = IntStream.range(0, genres.length).mapToObj(i -> new Song(genres[i], i, plays[i])).collect(Collectors.groupingBy(x -> x.genre));
        
        // 장르 정렬하기 (기준: 노래 재생 수 총합, 내림차순)
        List<List<Song>> songList = new ArrayList<>(genreMap.values());
        songList.sort(Comparator.comparingInt((List<Song> songs) -> 
                                             songs.stream()
                                              .mapToInt(song -> song.played).sum()).reversed());
        
        // 장르별로 노래 정렬하기 (기준: (1) 노래 재생 수, 내림차순 (2) 고유 번호, 오름차순)
        return songList.stream().flatMap(
            songs -> songs.stream().sorted(
                (a, b) -> {
                    if (a.played != b.played) return Integer.compare(b.played, a.played);
                    return Integer.compare(a.no, b.no);
                }).limit(2)
        ).mapToInt(x -> x.no).toArray();
    }
}

class Song {
    String genre;
    int no;
    int played;
    
    public Song (String genre, int no, int played) {
        this.genre = genre;
        this.no = no;
        this.played = played;
    }
}