package br.com.petz.api.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorResponse {
    private Integer code;
    private String message;
}
