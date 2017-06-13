package com.example.eureka.client.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by coco on 17/5/27.
 */
@ApiModel("http响应模型")
public class Result implements Serializable {
    private static final long serialVersionUID = -4033566587098061817L;
    @ApiModelProperty("请求处理是否成功")
    protected Boolean         success          = false;               // 执行是否成功，不成功时对应reason_code
    @ApiModelProperty("请求错误码，正常执行完扫描时为空")
    protected String          reason_code;                            // 错误码及原因描述，正常执行完扫描时为空
    @ApiModelProperty("额外的业务数据")
    protected Object          attribute;                              // 可以放额外的数据

    public Result() {
    }

    public Result(Object attribute) {
        new Result(true,attribute);
    }

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, Object attribute) {
        this.success = success;
        this.attribute = attribute;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public Object getAttribute() {
        return attribute;
    }

    public void setAttribute(Object attribute) {
        this.attribute = attribute;
    }
}
