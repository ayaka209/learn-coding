function fn(index,curr = 1 ,next = 1){
    console.log(curr);
    if(index === 1) return curr;
    return fn(index -1, next, curr+next);
}

console.log(fn(5));
