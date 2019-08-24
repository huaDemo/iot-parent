package constant;

public enum ErrorEnum {

    ERROR_99999(99999, "抛出预定义异常，但是未定义异常信息！"),
    ERROR_10101(10101, "入参不可为空"),


    ERROR_50101(50101, "添加设备失败！"),
    ERROR_50102(50102, "删除设备失败！"),
    ERROR_50103(50103, "修改设备失败！"),

    ERROR_10001(10001, "参数为空或格式不正确"),
    ERROR_10002(10002, "accessToken异常或过期"),
    ERROR_10005(10005, "appKey异常"),
    ERROR_20002(20002, "设备不存在"),
    ERROR_20006(20006, "网络异常"),
    ERROR_20007(20007, "设备不在线"),
    ERROR_20008(20008, "设备响应超时"),
    ERROR_20010(20010, "设备验证码错误"),
    ERROR_20018(20018, "该用户不拥有该设备"),
    ERROR_49999(49999, "数据异常"),
    ERROR_60016(60016, "加密未开启,无需关闭")


    ;


    // 错误码
    private int code;
    // 错误信息
    private String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
