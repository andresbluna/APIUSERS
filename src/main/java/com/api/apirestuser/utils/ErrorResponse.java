package com.api.apirestuser.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;

    public Map<String, String> toMap() {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(this.errorCode, this.errorMessage);
        return errorMap;
    }

}
