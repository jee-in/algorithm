import java.util.*;
import java.util.stream.*;

class Solution {
    private static int n;
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        
        List<Integer> holding = new ArrayList<>();
        List<Integer> deck = new ArrayList<>();
        n = cards.length;
        int initSize = n / 3;
        
        holding = IntStream.range(0, initSize).map(x -> cards[x]).boxed().collect(Collectors.toList());
        
        for (int index = initSize; index <= n; index = index + 2) {
            answer = (index - initSize) / 2 + 1;
            if (index == n) {
                break;
            }
            
            deck.addAll(List.of(cards[index], cards[index + 1]));
                        
            List<Integer[]> combis = findCombis(holding);
            if (!combis.isEmpty()) {
                Integer[] combi = combis.get(0);
                holding.remove(combi[0]);
                holding.remove(combi[1]);
                
                continue;
            }
            
            if (coin == 0) {
                break;
            }
                
            int available = 0;
            Iterator<Integer> it = deck.iterator();
            while (it.hasNext()) {
                int deckCard = it.next();
                if (holding.contains(n + 1 - deckCard)) {
                    it.remove();
                    deck.remove(Integer.valueOf(deckCard));
                    holding.remove(Integer.valueOf(n + 1 - deckCard));
                    coin = coin - 1;
                    
                    available = 1;
                    break;
                }
            }
            
            if (available > 0) {
                continue;
            }
            
            if (coin >= 2) {
                List<Integer[]> deckCombis = findCombis(deck);
                if (!deckCombis.isEmpty()) {
                    Integer[] deckCombi = deckCombis.get(0);
                    deck.remove(deckCombi[0]);
                    deck.remove(deckCombi[1]);
                                        
                    coin = coin - 2;
                    continue;
                }
            }
            
            break; 
        }
        
        return answer;
    }
    
    static List<Integer[]> findCombis(List<Integer> cards) {
        cards.sort((a, b) -> Integer.compare(a, b));
        List<Integer[]> combis = new ArrayList<>();
                
        int start = 0;
        int end = cards.size() - 1;
        while (start < end) {
            
                int card1 = cards.get(start);
                int card2 = cards.get(end);

                if (card1 + card2 == n + 1) {
                    combis.add(new Integer[] {card1, card2});
                    end--;
                    start++;
                } else if (card1 + card2 < n + 1) {
                    start++;
                } else {
                    end--;
                }

            
        }
        
        return combis;
        
    }
}