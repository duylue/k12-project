package com.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyResponse {
    private int status;
    private String message;
    private Object data;
}
