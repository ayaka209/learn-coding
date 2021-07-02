<?php
https://leetcode-cn.com/problems/sum-lists-lcci/
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2) {
        if(empty($l1)) return $l2;
        if(empty($l2)) return $l1;
        $nums1 = [];
        $nums2 = [];
        while($l1){
            $nums1[] = $l1->val;
            $l1 = $l1->next;
        }
        while($l2){
            $nums2[] = $l2->val;
            $l2 = $l2->next;
        }
        $max = max(count($nums1),count($nums2));
        $nums3=[];
        $add = false;
        for($i = 0; $i < $max; $i++){
            $n1 = isset($nums1[$i]) ? $nums1[$i] : 0;
            $n2 = isset($nums2[$i]) ? $nums2[$i] : 0;
            $n3 = $n1 + $n2 + ($add ? 1 : 0);
            if($n3 >= 10){
                $n3 -= 10;
                $add = true;
            }else{
                $add = false;
            }
            array_push($nums3,$n3);
        }
        if($add){ // 最后进位了
            array_push($nums3,1);
        }
        print_r($nums3);
        $l3 = new ListNode(0);
        $head = $l3;
        for($i = 0; $i<count($nums3); $i++){
            $l3->val = $nums3[$i];
            if($i !== count($nums3) - 1){
                $l3->next = new ListNode(0);
                $l3 = $l3->next;
            }

        }
        return $head;
    }
}
