<?php
function frequencySort($s) {
    $array = str_split($s,1); // 转为字符数组 // 非英文字符要考虑用mb_str_split

    $sort = [];
    for($i = 0; $i < count($array); $i++){
        if(!isset($sort[$array[$i]]))$sort[$array[$i]] = 0;
        $sort[$array[$i]]++; // PHP里面关联数组可以是有序的，因此可以直接对值排序来输出键
        //但本例中用一个更通用的方式来做，假设是一个无序的哈希表
    }
    $values =array_values($sort);
    $keys =array_keys($sort);
    // 思路是对values进行降序排序，同时对key进行同样的交换
    // 因此简单实现一个自己的排序
    // 下面采用冒泡
    $exchange = true;
    $count = 0; // 已排序大小
    while($exchange){
        $exchange = false;
        for($i = 0; $i < count($values) - $count - 1 ; $i++){
            $a = $values[$i];
            $b = $values[$i+1];
            $a1 = $keys[$i];
            $b1 = $keys[$i+1];
            if($a < $b){
                list($values[$i+1],$values[$i]) = [$a,$b];
                list($keys[$i+1],$keys[$i]) = [$a1,$b1];
                $exchange = true;
            }
        }
        if(!$exchange){
            break;//本轮无交换，停止排序
        }
    }
    $str = "";
    for($i = 0 ; $i < count($keys); $i++){
        $str .= str_repeat($keys[$i],$values[$i]);
    }
    return $str;
}
