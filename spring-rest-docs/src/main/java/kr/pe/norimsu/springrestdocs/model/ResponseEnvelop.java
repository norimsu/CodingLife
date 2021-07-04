package kr.pe.norimsu.springrestdocs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEnvelop<T> {

    private String resultCode;
    private T data;

    // OK
    public static <T> ResponseEnvelop<T> OK() {
        return ResponseEnvelop.<T>builder().resultCode("OK").build();
    }

    // DATA OK
    public static <T> ResponseEnvelop<T> OK(T data) {
        return ResponseEnvelop.<T>builder().resultCode("OK").data(data).build();
    }

    // ERROR
    public static <T> ResponseEnvelop<T> ERROR() {
        return ResponseEnvelop.<T>builder().resultCode("ERROR").build();
    }
}
