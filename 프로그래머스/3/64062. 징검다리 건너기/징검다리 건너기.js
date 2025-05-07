function solution(stones, k) {    
    let left = 0;
    let right = 200000000;
    
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        
        if (canCross(stones, mid, k)) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return left;
}

function canCross(stones, mid, k) {
    let collapsedCnt = 0;
    for (let i = 0; i < stones.length; i++) {
        if (stones[i] - mid <= 0) {
            collapsedCnt++;
        } else {
            collapsedCnt = 0;
        }
        
        if (collapsedCnt >= k) {
            return false;
        }
    }
    
    return true;
}