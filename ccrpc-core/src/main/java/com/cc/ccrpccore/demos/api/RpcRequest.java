package com.cc.ccrpccore.demos.api;

import lombok.Data;

/**
 * RPC 请求参数
 */
@Data
public class RpcRequest {
    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    private Object[] args;


}
