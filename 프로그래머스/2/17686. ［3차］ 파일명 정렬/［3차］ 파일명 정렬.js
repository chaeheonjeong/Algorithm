function compare(a, b){
    if(a[1] < b[1]) return -1;
    if(a[1] > b[1]) return 1;
    
    let numA = parseInt(a[2]);
    let numB = parseInt(b[2]);
    if(numA < numB) return -1;
    if(numA > numB) return 1;
    
    return 0;
}

function solution(files) {
    const format = Array.from({length: files.length}, ()=>[]);
    for(let i=0; i<files.length; i++){
        format[i].push(files[i]);
        let start = 0;
        let file = files[i].toLowerCase();
        for(let j=0; j<file.length; j++){
            if((file[j] >= '0' && file[j] <= '9') 
                && (file[j-1] < '0' || file[j-1] > '9')){
                
                format[i].push(file.substring(start, j));
                start = j;
            }
            else if((file[j] > '9' || file[j] < '0') 
               && (file[j-1] >= '0' && file[j-1] <= '9')){
                format[i].push(file.substring(start, j));
                start = j;
            }
        }
        if(start !== file.length) format[i].push(file.substring(start, file.length))
    }
    
    format.sort(compare);

    const answer = [];
    for(let name of format){
        answer.push(name[0]);
    }
    
    return answer;
}