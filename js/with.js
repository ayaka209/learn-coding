
function test(obj){

    with (obj) {
        a = 2;
    }
}

let o1 = {
    a:1
}

let o2 = {
    b:1
}
test(o1)
test(o2)
console.log(o1.a);
console.log(o2.a);
console.log(a); // 暴露到了Global
