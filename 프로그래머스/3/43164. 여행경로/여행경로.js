function solution(tickets) {
    let map = new Map();
    let answer = [];

    for (const [from, to] of tickets) {
        if (!map.has(from)) map.set(from, []);
        map.get(from).push(to);
    }

    for (const key of map.keys()) {
        map.get(key).sort();
    }

    function dfs(airport) {
        const destList = map.get(airport);
        while (destList && destList.length > 0) {
            const next = destList.shift();
            dfs(next);
        }
        answer.push(airport);
    }

    dfs('ICN');

    return answer.reverse();
}
