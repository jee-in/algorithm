function solution(gems) {
    let gemCnt = gems.length;
    var answer = [1, gemCnt];
    let gemKindCnt = new Set(gems).size;
    let gemMap = new Map();
    
    let start = 0;
    for (let end = 0; end < gemCnt; end++) {
        gemMap.set(gems[end], (gemMap.get(gems[end]) || 0) + 1);
        
        while(gemMap.size == gemKindCnt) {
            if (end - start < answer[1] - answer[0]) {
                answer = [start + 1, end + 1];
            }
            
            gemMap.set(gems[start], gemMap.get(gems[start]) - 1);
            if (gemMap.get(gems[start]) == 0) {
                gemMap.delete(gems[start]);
            }
            
            start++;
        }
        
    }
    
    return answer;
}