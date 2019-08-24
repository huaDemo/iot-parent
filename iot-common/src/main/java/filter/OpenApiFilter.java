package filter;

import com.alibaba.fastjson.JSON;
import constant.ErrorEnum;
import entity.BaseResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import sso.JWTUtil;
import sso.PubTools;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName OpenApiFilter
 * @Description TODO
 * @Auther hua
 * @Date 2019/7/15 18:55
 * @Version 1.0
 */
@WebFilter(filterName = "OpenApiFilter", urlPatterns = {"/api/*"})
public class OpenApiFilter implements Filter {

    @Autowired
    private PubTools pubTools;

    //放行的页面路径
    private String page1 = "/api/register/acount";

    private String page2 = "/api/forgetPassword";

    private String page3 = "/api/park/insertCarnumRecord";

    private String page4 = "/api/richers/synBaseInfo";

    private String page5 = "/api/richers/synHouse";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        BaseResp<String> restResponse = new BaseResp<String>();
        //HttpSession session = request.getSession();
        if (request.getServletPath().equals(page1) || request.getServletPath().equals(page2)
                || request.getServletPath().equals(page3) || request.getServletPath().equals(page4)
                || request.getServletPath().equals(page5)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("token");
        String username = JWTUtil.getUsername(token);
        if (StringUtils.isBlank(username)) {
            restResponse.setCode(ErrorEnum.ERROR_10002.getCode());
            restResponse.setMessage(ErrorEnum.ERROR_10002.getMessage());
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().print(JSON.toJSONString(restResponse));
            response.getWriter().flush();
            return;
        }
        // 获取用户
        Map<String, String> map = pubTools.getTokenAndPwd(username);
        if (map != null) {
            String serverToken = map.get("token");
            String pwd = map.get("pwd");
            String deviceid = map.get("deviceid");
            // 校验 token是否正确
            if (!JWTUtil.verify(token, username, deviceid, pwd)) {
                restResponse.setCode(ErrorEnum.ERROR_10002.getCode());
                restResponse.setMessage(ErrorEnum.ERROR_10002.getMessage());
                response.setHeader("Content-Type", "application/json;charset=UTF-8");
                response.getWriter().print(JSON.toJSONString(restResponse));
                response.getWriter().flush();
                return;
            }
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }


}
