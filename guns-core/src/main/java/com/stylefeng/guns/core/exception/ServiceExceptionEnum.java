package com.stylefeng.guns.core.exception;

/**
 * 抽象接口
 *
 * @author maguohao
 * @date 2018-12-28-下午10:27
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
