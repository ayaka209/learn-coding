/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if(nums.length == 1) return [nums];
    if(nums.length == 2) return [[nums[0],nums[1]],[nums[1],nums[0]]];
    let results = []
    for(let i =0 ; i<nums.length; i++){
        let ele = nums[i];
        let others = [...nums.slice(0,i), ...nums.slice(i+1,nums.length) ];
        let permutes = permute(others);

        for(let p of permutes){
            p.unshift(ele);
            results.push(p);
        }
    }
    return results;
};
