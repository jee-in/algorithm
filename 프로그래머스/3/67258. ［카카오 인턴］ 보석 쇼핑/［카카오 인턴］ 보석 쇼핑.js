function solution(gems) {
    const gemTypes = new Set(gems).size;
    const gemMap = new Map();
    let answer = [0, gems.length - 1];
    let start = 0;

    for (let end = 0; end < gems.length; end++) {
        const gem = gems[end];
        gemMap.set(gem, (gemMap.get(gem) || 0) + 1);

        while (gemMap.size === gemTypes) {
            if ((end - start) < (answer[1] - answer[0])) {
                answer = [start, end];
            }

            const startGem = gems[start];
            gemMap.set(startGem, gemMap.get(startGem) - 1);
            if (gemMap.get(startGem) === 0) gemMap.delete(startGem);
            start++;
        }
    }

    return [answer[0] + 1, answer[1] + 1];
}
