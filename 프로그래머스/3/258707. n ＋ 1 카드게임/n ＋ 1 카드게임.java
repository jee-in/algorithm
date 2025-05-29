import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int initSize = n / 3;
        int totalRound = n / 3 + 1;
        List<Integer> holding = IntStream.range(0, initSize)
            .map(index -> cards[index]).boxed().collect(Collectors.toList());
        List<Integer> deck = new ArrayList<>();
        
        int round = 0;
        while (round <= totalRound) {
            round++;
            if (round == totalRound) {
                break;
            }
            
            int cardIdx = initSize + 2 * (round - 1);
            int deckCard1 = cards[cardIdx];
            int deckCard2 = cards[cardIdx + 1];
            deck.add(deckCard1);
            deck.add(deckCard2);
            
            // 들고 있는 카드 2장 제출 (coin 소모량 0)
            List<Integer[]> combis = findCombis(holding, n);
            if (!combis.isEmpty()) {                
                Integer[] combi = combis.get(0);
                holding.remove(combi[0]);
                holding.remove(combi[1]);
                
                continue;
            }
            
            if (coin == 0) {
                break;
            }
            
            // 들고 있는 카드 1장과 deck 카드 1장 제출 (coin 소모량 1)
            boolean isMatch = false;
            
            Iterator<Integer> holdIt = holding.iterator();
            while (holdIt.hasNext()) {
                Integer h = holdIt.next();
                if (deck.contains(Integer.valueOf(n + 1 - h))) {
                    holdIt.remove();
                    deck.remove(Integer.valueOf(n + 1 - h));
                    isMatch = true;
                    coin -= 1;
                    break;
                }                
            
            }
            if (isMatch) {                
                continue;
            }
            
            if (coin < 2) {
                break;
            }
            
            // deck 카드 2장 제출 (coin 소모량 2)
            List<Integer[]> deckCombis = findCombis(deck, n);
            if (!deckCombis.isEmpty()) {                
                Integer[] deckCombi = deckCombis.get(0);
                deck.remove(deckCombi[0]);
                deck.remove(deckCombi[1]);
                
                coin -= 2;
                continue;
            }
            
            break;
        }
        
        return round;
    }
    
    static List<Integer[]> findCombis(List<Integer> cardList, int n) {
        List<Integer> sorted = new ArrayList<>(cardList);
        sorted.sort((a, b) -> Integer.compare(a, b));
        List<Integer[]> combis = new ArrayList<>();
        
        int start = 0;
        int end = cardList.size() - 1;  
        
        while (start < end) {
            Integer startCard = sorted.get(start);
            Integer endCard = sorted.get(end);
            int sum = startCard + endCard;
            
            if (sum == n + 1) {
                combis.add(new Integer[]{startCard, endCard});
                start++;
                end--;
            } else if (sum > n + 1) {
                end--;
            } else {
                start++;
            }
        }
        
        return combis;
    }
    
    
}