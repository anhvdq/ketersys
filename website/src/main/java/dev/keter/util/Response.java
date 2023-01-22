package dev.keter.util;

public class Response<T> {
    private T data;

    private Object error;

    private Response() {
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>().setData(data).setError(null);
    }

    public static <T> Response<T> error(Object error) {
        return new Response<T>().setData(null).setError(error);
    }

    public Object getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    private Response<T> setError(Object error) {
        this.error = error;
        return this;
    }

    private Response<T> setData(T data) {
        this.data = data;
        return this;
    }
}
