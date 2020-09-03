package com.ausy_technologies_proiectfinal.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse {

    Boolean success;
    String successMessage;

    public BaseResponse(Boolean success, String successMessage) {
        this.success = success;
        this.successMessage = successMessage;
    }
}
