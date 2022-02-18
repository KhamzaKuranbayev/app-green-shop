package uz.webbrain.appgreenshop.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private boolean success;
    private boolean status;
    private String message;
    private Object data;
    private List<Object> dataList;
    private HttpStatus httpStatus;
    private Map<Object, Object> map = new HashMap<>();

    public Response(boolean status, String message, Object data, HttpStatus httpStatus) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public Response(boolean status, String message, HttpStatus httpStatus) {
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(boolean status, String message, Object data, List<Object> dataList) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.dataList = dataList;
    }
}
