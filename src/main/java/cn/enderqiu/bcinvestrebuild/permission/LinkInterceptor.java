//package cn.enderqiu.bcinvestrebuild.permission;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LinkInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object
//            handler) throws Exception {
//        String realAddress = request.getHeader("x-forwarded-for");
//        String jsonObject = request.getParameter("body");
//        JSONObject json = JSONObject.parseObject(jsonObject);
//        if (json.getString("address").equals(realAddress))
//            return true;
//        response.sendError(HttpStatus.FORBIDDEN.value(), "address must equals to sender address");
//        return false;
//    }
//}
