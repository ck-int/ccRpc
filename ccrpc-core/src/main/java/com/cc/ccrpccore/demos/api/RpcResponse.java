package com.cc.ccrpccore.demos.api;

import lombok.Data;

@Data
public class RpcResponse<T> {

    private String status;

    private T data;

}
