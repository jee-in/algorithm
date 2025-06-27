import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for (int m : moves) {
            
            for (int i = 0; i < board.length; i++) {
                int toy = board[i][m - 1];
                
                if (toy== 0) {
                    continue;
                } else {
                    board[i][m - 1] = 0;
                    
                    if (!stack.empty() && stack.peek() == toy) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(toy);
                    }
                    
                    break;
                }
            }
            
        }
        
        return answer;
    }
}