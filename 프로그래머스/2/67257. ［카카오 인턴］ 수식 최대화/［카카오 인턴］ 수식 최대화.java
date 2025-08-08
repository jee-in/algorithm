import java.util.Arrays;

class Solution {
    private String[][] sequence = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"}, 
                        {"-", "*", "+"}, {"*", "-", "+"}, {"*", "+", "-"}};
    
    public long solution(String expression) {
        Long answer = 0L;
        String[] source = expression.split("(?<=[^0-9])|(?=[^0-9])");

        for (String[] seq : sequence) {
            String[] copied = Arrays.copyOf(source, source.length);
            for (String s: seq) {
                for (int now = 0; now < copied.length; now++) {
                    String operand = copied[now];                    
                    if (!operand.equals(s)) {
                        continue;
                    }

                    int prev = now - 1;
                    int next = now + 1;

                    while (copied[prev].equals("%")) {
                        prev--;
                    }

                    while (copied[next].equals("%")) {
                        next++;
                    }
                    
                    long prevNum = Long.valueOf(copied[prev]);
                    long nextNum = Long.valueOf(copied[next]);

                    if (operand.equals("+")) {
                        copied[prev] = String.valueOf(prevNum + nextNum);
                    } else if (operand.equals("-")) {
                        copied[prev] = String.valueOf(prevNum - nextNum);
                    } else if (operand.equals("*")) {
                        copied[prev] = String.valueOf(prevNum * nextNum);
                    }

                    copied[next] = "%";
                    copied[now] = "%";
                }
            }
            

            for (String n : copied) {
                if (!n.equals("%")) {
                    answer = Math.max(answer, Math.abs(Long.valueOf(n)));
                    break;
                }
            }
        }
        
        return answer;
    }
    
    
}