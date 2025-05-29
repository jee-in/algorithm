import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        List<Integer> holding = new ArrayList<>();
        List<Integer> deck = new ArrayList<>();
        int n = cards.length;
        int initSize = n / 3;
        int totalRound = n / 3 + 1;
        int round = 0;
        
        // 시작 카드 초기화
        for (int i = 0; i < initSize; i++) {
            holding.add(Integer.valueOf(cards[i]));
        }
        holding.sort((a, b) -> Integer.compare(a, b));        
        List<Integer[]> holdingPairs = findPairs(holding, n);
        
        while (round <= totalRound) {
            round += 1;
            
            // 더 이상 가져올 카드 뭉치가 없으면 라운드 종료
            if (round == totalRound) {
                break;
            }
            
            // 덱 카드 추가
            int index = initSize + 2 * (round - 1);
            deck.addAll(List.of(cards[index], cards[index + 1]));
            
            // 시작 카드에서 카드 2장을 제출할 수 있는 경우 (코인 소모량 0)
            if (!holdingPairs.isEmpty()) {
                Integer[] firstPair = holdingPairs.get(0);
                
                holding.removeAll(List.of(firstPair[0], firstPair[1]));
                holdingPairs.remove(firstPair);

                continue;
            }
                        
            // 시작 카드에서 카드를 제출할 수 있는 방법이 없고 coin이 0이면 라운드 종료
            if (coin == 0) {
                break;
            }
            
            // 시작 카드에서 1장, deck 카드에서 1장 제출할 수 있는 경우 (코인 소모량 1)
            boolean canMixMatch = false;
            Iterator<Integer> holdingIt = holding.iterator();
            while (holdingIt.hasNext()) {
                Integer h = holdingIt.next();
                
                if (deck.contains(Integer.valueOf(n + 1 - h))) {
                    holdingIt.remove();
                    deck.remove(Integer.valueOf(n + 1 - h));
                    coin -= 1;
                    
                    canMixMatch = true;
                    break;
                }
            }
            
            if (canMixMatch) {
                continue;
            }
                        
            // 위 방법이 불가능하고 deck 카드에서 2장 갖고 올 수 있는 coin 수가 없다면 라운드 종료
            if (coin < 2) {
                break;
            }
            
            // deck 카드에서 카드 2장 제출할 수 있는 경우 (코인 소모량 2)
            deck.sort((a, b) -> Integer.compare(a, b));
            List<Integer[]> deckPairs = findPairs(deck, n);
            if (!deckPairs.isEmpty()) {
                Integer[] deckPair = deckPairs.get(0);
                deck.removeAll(List.of(deckPair[0], deckPair[1]));
                
                coin -= 2;
                continue;
            }
            
            // 제출할 수 있는 카드가 없다면 라운드 종료
            break;
        }
        
        return round;
    }
    
    static List<Integer[]> findPairs(List<Integer> sortedList, int n) {
        List<Integer[]> pairs = new ArrayList<>();
        int start = 0;
        int end = sortedList.size() - 1;
        
        while (start < end) {
            Integer startCard = sortedList.get(start);
            Integer endCard = sortedList.get(end);
            int sum = startCard + endCard;
            
            if (sum == n + 1) {
                pairs.add(new Integer[]{startCard, endCard});
                start++;
                end--;
            } else if (sum < n + 1) {
                start++;
            } else {
                end--;
            }
        }
        
        return pairs;
    }
}