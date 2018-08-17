package com.stylefeng.guns.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author maguohao
 * @date 2018-12-02 20:57
 */
public class CallExternalSystemDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Calling the external system for employee "
                + delegateExecution.getVariable("employee"));
    }
}
