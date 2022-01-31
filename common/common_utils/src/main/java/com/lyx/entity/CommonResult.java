package com.lyx.entity;

import com.lyx.utils.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.HashMap;

/**
 * @author liao 2021/10/10
 */
@Data
public class CommonResult<K,V> {
    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回的信息")
    private String message;

    @ApiModelProperty("返回的数据")
    private HashMap<K,V> data = new HashMap<>();

    private CommonResult(){}

    public static CommonResult ok(){
        CommonResult<Object, Object> common = new CommonResult<>();
        common.setCode(ResultCode.SUCCESS);
        common.setSuccess(true);
        common.setMessage("操作成功");
        return common;
    }

    public static CommonResult error(){
        CommonResult<Object, Object> common = new CommonResult<>();
        common.setCode(ResultCode.ERROR);
        common.setSuccess(false);
        common.setMessage("操作失败");
        return common;
    }

    public CommonResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public CommonResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }

    public CommonResult data(K k,V v){
        this.data.put(k,v);
        return this;
    }

}
