package com.tang2988.gold.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * Bean工具
 * 
 * @version 2016-4-29上午9:32:50
 * @author xiaoyun.zeng
 */
public class BeanUtil {
    
    /**
     * 简单Bean属性拷贝
     * 
     * @version 2016-4-29上午11:03:36
     * @author xiaoyun.zeng
     * @param source
     * @param target
     */
    public static void copy(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }
    
    /**
     * 简单Bean属性拷贝，返回目标对象实例
     * 
     * @version 2016-4-29上午10:39:32
     * @author xiaoyun.zeng
     * @param source
     * @param targetClass
     * @return
     */
    public static <T> T copy(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * List对象拷贝
     * 
     * @version 2016-4-29上午10:44:52
     * @author xiaoyun.zeng
     * @param sourceList
     * @param targetClass
     * @return
     */
    public static <T> List<T> copy(List<? extends Object> sourceList, Class<T> targetClass) {
        try {
            List<T> targetList = new ArrayList<T>();
            for (Object source : sourceList) {
                T target = targetClass.newInstance();
                BeanUtils.copyProperties(source, target);
                targetList.add(target);
            }
            return targetList;
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
}
