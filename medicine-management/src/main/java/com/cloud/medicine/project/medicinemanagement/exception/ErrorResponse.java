package com.cloud.medicine.project.medicinemanagement.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private String message;
    private List<String> detail = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetail() {
        return detail;
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }
}
