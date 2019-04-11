package com.study.java.base.algorithm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author caad
 * @date Create in 14:46 2019/4/11
 */
@Slf4j
public class SortTest {

    private Sort sort = new Sort();
    private int[] nums = new int[]{3,6,4,2,6,8,1,9,7};
    private long beginTime;
    @Before
    public void before(){
        beginTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        log.info("原数据：{}",JSON.toJSONString(nums));
    }

    @After
    public void after(){
        long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        log.info("新数据：{}",JSON.toJSONString(nums));
        log.info("耗时：{}",endTime - beginTime);
    }


    @Test
    public void bubble(){
        sort.bubble(nums);
    }

    @Test
    public void quick(){
        sort.quick(nums,0,nums.length - 1);
    }
}
