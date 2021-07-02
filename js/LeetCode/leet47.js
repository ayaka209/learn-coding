/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if(nums.length == 1) return [nums];
    if(nums.length == 2) {
        let a = nums[0];
        let b = nums[1];
        if(a == b){
            return [[a,b]];
        }else{
            return [[a,b],[b,a]]
        }
    };
    let results = []
    let resultsUnique = new Set();
    for(let i =0 ; i<nums.length; i++){
        let ele = nums[i];
        let others = [...nums.slice(0,i), ...nums.slice(i+1,nums.length) ];
        let permutes = permuteUnique(others);
        for(let p of permutes){
            p.unshift(ele);
            if(!resultsUnique.has(p.toString())){
                results.push(p);
                resultsUnique.add(p.toString());
            }
        }
    }
    return results;
};
