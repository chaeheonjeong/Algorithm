const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const arr = [];
const vowel = ['a', 'e', 'i', 'o', 'u'];

for(let line of input){
    if(line === 'end') break;
    arr.push(line);
}

for(let item of arr){
    let flag = false;

    if(isIncludeVowel(item) && !isIncludeSame(item) && !isIncludeThree(item)){
        flag = true;
    }

    if(flag) console.log(`<${item}> is acceptable.`);
    else console.log(`<${item}> is not acceptable.`);
}

function isIncludeVowel(s){
    for(v of vowel){
        if(s.includes(v)) return true;
    }
    return false;
}

function isIncludeSame(s){
    if(s.length === 1) return false;

    for(let i=0; i<s.length-1; i++){
        if(s.charAt(i) === s.charAt(i+1)){
            if(s.charAt(i) !== 'e' && s.charAt(i) !== 'o') return true;
        }
    }

    return false;
}

function isIncludeThree(s){
    if(s.length === 1 || s.length === 2) return false;

    let cntV = 0;
    let cntC = 0;
    for(let i=0; i<s.length; i++){
        if(vowel.includes(s.charAt(i))){
            cntV++;
            cntC = 0;
        } else {
            cntC++;
            cntV = 0;
        }

        if(cntV >= 3 || cntC >= 3) return true;
    }

    return false;
}