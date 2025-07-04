import java.util.*;
import java.time.*;

class MusicInfo implements Comparable<MusicInfo> {
    String title;
    String note;
    int duration;
    int index;
    
    public MusicInfo(String title, String note, int duration, int index) {
        this.title = title;
        this.note = note;
        this.duration = duration;
        this.index = index;
    }
    
    @Override
    public int compareTo(MusicInfo mi) {
        int result = Integer.compare(mi.duration, this.duration);
        if (result != 0) return result;
        
        return Integer.compare(this.index, mi.index);
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<MusicInfo> pq = new PriorityQueue<>();
        String replaced = convert(m);
        
        int index = 0;
        for (String musicinfo : musicinfos) {
            String[] splitted = musicinfo.split(",");
            LocalTime start = LocalTime.parse(splitted[0]);
            LocalTime end = LocalTime.parse(splitted[1]);
            String title = splitted[2];
            String note = convert(splitted[3]);
            int duration = (int)Duration.between(start, end).toMinutes();
            
            String fullNote = note;
            if (note.length() < duration) {
                int mod = duration / note.length();
                int remainder = duration % note.length();
                fullNote = note.repeat(mod) + note.substring(0, remainder + 1);
            } else if (note.length() > duration) {
                fullNote = note.substring(0, duration);
            }
            
            if (fullNote.contains(replaced)) {
                MusicInfo mi = new MusicInfo(title, note, duration, index++);
                pq.offer(mi);
            }
        }
        
        String answer = "(None)";
        if (!pq.isEmpty()) {
            answer = pq.poll().title;
        }
        
        return answer;
    }
    
    private static String convert(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}