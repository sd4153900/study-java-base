package com.study.java.base.algorithm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author caad
 * @date Create in 14:09 2019/4/11
 */
@Slf4j
public class Sort {

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param nums
     */
    public void bubble(int[] nums){
        for(int i = 0 ;i < nums.length ;i++){
            for(int j = 0;j < nums.length - 1;j++){
                int a = nums[j];
                int b = nums[j + 1];
                if(a > b){
                    a = a^b;
                    b = a^b;
                    nums[j] = a^b;
                    nums[j + 1] = b;
                    log.info("排序中：{}",JSON.toJSONString(nums));
                }
            }
        }
    }

    /**
     * 选择排序
     * 把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；
     * 交换了以后再和小的那端比，比它小不交换，比他大交换。这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，
     * 然后再用分治法，分别对这两个独立的数组进行排序。
     * @param nums
     * @param begin
     * @param end
     */
    public void quick(int[] nums,int begin,int end){
        int low = begin;
        int high = end;
        if(begin >= end){
            return;
        }
        int temp = nums[begin];
       while (begin < end){
            while (begin < end && nums[end] >= temp){
                end--;
            }
           nums[begin] = nums[end];
//           begin++;
           while (begin < end && nums[begin] <= temp){
               begin++;
           }
           nums[end] = nums[begin];
//           end--;
       }
        nums[begin] = temp;
        log.info("排序中：{}",JSON.toJSONString(nums));
       quick(nums,low,begin -1);
       quick(nums,begin + 1,high);
    }
}
