package com.student.base;


import com.student.model.MyResponse;
import org.springframework.http.ResponseEntity;

public class BaseResponse {
    protected ResponseEntity<?> getResponseEntity(Object data) {
        return ResponseEntity.ok(getResponse(data));

    }

    private MyResponse getResponse(Object data) {
        MyResponse myResponse = new MyResponse();
        myResponse.setData(data);
        myResponse.setStatus(200);
        myResponse.setMessage("success");
        return myResponse;
    }

}
