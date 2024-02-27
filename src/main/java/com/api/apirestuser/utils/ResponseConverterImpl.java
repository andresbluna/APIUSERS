package com.api.apirestuser.utils;

import com.api.apirestuser.dto.ResponseModel;
import com.api.apirestuser.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class ResponseConverterImpl implements ResponseConverter {

    @Override
    public ResponseModel convert(UserModel userModel) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setId(userModel.getId());
        responseModel.setName(userModel.getName());
        responseModel.setEmail(userModel.getEmail());
        responseModel.setPassword(userModel.getPassword());
        responseModel.setPhones(userModel.getPhones());
        responseModel.setCreated(userModel.getCreated());
        responseModel.setModified(userModel.getModified());
        responseModel.setToken(userModel.getToken());
        responseModel.setLast_login(userModel.getLast_login());
        responseModel.setIsactive(userModel.getIsactive());

        return responseModel;
    }

}
