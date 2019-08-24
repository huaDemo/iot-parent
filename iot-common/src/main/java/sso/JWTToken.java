package sso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Token
 * @Description TODO
 * @Auther hua
 * @Date 2019/7/15 18:01
 * @Version 1.0
 */
public class JWTToken {

    private static final long serialVersionUID = 1282057025599826155L;

    private String token;

    private String exipreAt;

    public JWTToken(){}

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExipreAt() {
        return exipreAt;
    }

    public void setExipreAt(String exipreAt) {
        this.exipreAt = exipreAt;
    }

    public static String dateToString(Date date,String format) {
        DateFormat dft = new SimpleDateFormat(format);
        if (date != null) {
            String ss = dft.format(date);
            return ss;
        } else {
            return "";
        }
    }

}
