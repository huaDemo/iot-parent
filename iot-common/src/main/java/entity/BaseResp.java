package entity;

import java.io.Serializable;

/**
 * @param <T>
 */
public class BaseResp<T> implements Serializable {
    /**
     * 返回码
     */
    private int code = 10000;

    /**
     * 返回信息描述
     */
    private String message = "Success";

    /**
     * 微服务码
     */
    private int serverCode = 0;

    /**
     * 返回数据
     */
    private T result;

    /**
     * 系统当前时间
     */
    private long currentTime = System.currentTimeMillis();

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public BaseResp() {
    }




}