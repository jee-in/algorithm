class Solution {
    public int solution(int coin, int[] cards) {        
        int n = cards.length;
        int initSize = n / 3;
        boolean[] submitted = new boolean[n + 1];
        int totalRound = n / 3 + 1;
        int round = 0;
        
        e: while (round <= totalRound) {
            round++;
            if (round == totalRound) {
                break;
            }
            
            for (int i = 0; i < initSize - 1; i++) {
                for (int j = i + 1; j < initSize; j++) {
                    if ((cards[i] + cards[j] == n + 1) && !submitted[i] && !submitted[j]) {
                        submitted[i] = true;
                        submitted[j] = true;
                        continue e;
                    }
                }
            }
            
            int index = initSize + 2 * (round - 1);
            
            k: for (int i = 0; i < index + 1; i++) {
                for (int j = initSize; j < index + 2; j++) {
                    if ((cards[i] + cards[j] == n + 1) && !submitted[i] && !submitted[j]) {
                        if (i >= initSize) {
                            coin -= 1;
                        }
                        if (j >= initSize) {
                            coin -= 1;
                        }
                        
                        if (coin < 0) {
                            break e;
                        }
                        
                        submitted[i] = true;
                        submitted[j] = true;
                        continue e;
                    }
                }
            }
            
            break;
        }
        
        return round;
    }
}