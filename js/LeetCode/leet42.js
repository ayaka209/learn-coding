/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let currentHeight = 0; // 现在柱子高度
    let start = 0; // 第一个柱子位置
    let end = 0; // 最后一个可积水柱子
    for(let i =0;i<height.length;i++){
        if(height[i] !== 0){
            start = i; // 找一个非0的开始积水
            break;
        }
    }
    end = height.length - 1;
    let water = 0;
    while(start < end){
        //起始柱子位置
        let currHeight = height[start];
        let tmpWater = 0;
        let foundNext = false;
        for(let i  = start+1; i < height.length; i++){
            // 找下一个更高或者同柱子;
            // 找不到，那就不能以这个柱子的高度为开始积水
            let nextHeight = height[i];

            if(nextHeight >= currHeight){ // 找到积水终点

                start = i; // 下一个起点
                foundNext = true;
                water += tmpWater;
                break;
            }else{
                tmpWater += (currHeight - nextHeight > 0) ? currHeight - nextHeight : 0 ;
            }
        }
        if(!foundNext){
            // 没有找到更高或者同高柱子;
            // 就只能找下一个最高柱子作为积水终点
            let nextHeight = -Infinity;
            let nextIndex = 0;
            for(let i = start + 1; i <= end; i++){
                if(height[i] > nextHeight){

                    nextIndex = i;
                    nextHeight = height[i];
                    foundNext = true;
                }
            }
            //console.log(nextIndex);
            if(foundNext){

                currHeight = nextHeight;
                tmpWater=  0;
                for(let i = start + 1; i <= nextIndex; i++){
                    nextHeight = height[i];
                    tmpWater += (currHeight - nextHeight > 0) ? currHeight - nextHeight : 0 ;
                }
                water += tmpWater;
                start = nextIndex;
            }
        }
    }
    return water;
};
