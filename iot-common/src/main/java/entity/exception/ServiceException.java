package entity.exception;

/**
 * @ClassName ServiceException
 * @Description TODO
 * @Auther hua
 * @Date 2019/5/5 17:31
 * @Version 1.0
 */
public abstract class ServiceException extends Exception {

    private int code;

    public ServiceException() {
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(ServiceExceptionDefinition definition) {
        super(definition.getMsg());
        this.code = definition.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
