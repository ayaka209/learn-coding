function merge_sort(array){
   return merge_sort_c(array,0,array.length - 1);
}
function merge_sort_c(array,p,r){

    if(r <= p) return [array[p]];
    let q = Math.floor( (p+r) / 2);
    let array1 = merge_sort_c(array,p,q);

    let array2 = merge_sort_c(array,q+1,r);
    return merge(array1,array2);
}
function merge(array1,array2){
    let i = 0;
    let k = 0;
    let array = [];
    while(i+k < array1.length + array2.length){
        if(array1.length === i  && array2.length > k){
            array.push(array2[k]);
            k++;
        }else if(array2.length === k && array1.length > i){
            array.push(array1[i]);
            i++;
        }else{
            if(array1[i] < array2[k]){
                array.push(array1[i]);
                i++;
            }else{
                array.push(array2[k]);
                k++;
            }
        }
    }

    return array;
}

console.log(merge_sort([1,3,4,5,6,2,4,6,8,1,3,5,7,0]))
