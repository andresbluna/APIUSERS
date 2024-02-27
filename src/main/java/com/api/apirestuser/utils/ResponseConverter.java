package com.api.apirestuser.utils;

import com.api.apirestuser.dto.ResponseModel;
import com.api.apirestuser.model.UserModel;

public interface ResponseConverter {
    ResponseModel convert(UserModel userModel);
}
