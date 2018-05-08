package com.chenqi.upms.common.constant;

import com.chenqi.common.base.BaseResult;

/**
 * upms系统常量枚举值
 * Created by chenqi on 2018/5/8
 */
public class UpmsResult extends BaseResult{
    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data){
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }
}
