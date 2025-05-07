function solution(want, number, discount) {
    var answer = 0;
    const SALE_PERIOD = 10;
    let wantList = [];
    
    for (let i = 0; i < want.length; i++) {
        let count = number[i];
        while (count > 0) {
            wantList.push(want[i]);
            count--;
        }
    }
    
    for (let start = 0; start < discount.length - SALE_PERIOD + 1; start++) {
        let wantListCopy = Array.from(wantList);
        
        for (let idx = start; idx < start + SALE_PERIOD; idx++) {
            if (wantListCopy.includes(discount[idx])) {
                let firstIndex = wantListCopy.findIndex(x => x == discount[idx]);
                wantListCopy.splice(firstIndex, 1);
            }
        }
        answer += wantListCopy.length == 0? 1: 0;
    }
    
    return answer;
}