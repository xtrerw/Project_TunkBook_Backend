package com.tunkbook.pojo;

import lombok.Data;

@Data
//Clase Result para devolver los resultados de conecta
public class Result {

    private Integer code;//codigo: 1:success, 0:error
    private String msg;//informacion del resultado
    private Object data;//datos del resultado

    public static Result success(){
        Result result = new Result();
        result.code=1;
        result.msg="success";
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.code=1;
        result.msg="success";
        result.data=data;
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.code=code;
        result.msg=msg;
        return result;
    }

}
