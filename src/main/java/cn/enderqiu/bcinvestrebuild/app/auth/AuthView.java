package cn.enderqiu.bcinvestrebuild.app.auth;

import cn.enderqiu.bcinvestrebuild.app.auth.response.TokenResponse;
import cn.enderqiu.bcinvestrebuild.app.auth.serializer.BasicAuthSerializer;
import cn.enderqiu.bcinvestrebuild.app.auth.serializer.CodeSerializer;
import cn.enderqiu.bcinvestrebuild.framework.View;
import org.springframework.stereotype.Service;

@Service
public class AuthView extends View {
    public TokenResponse retriveToken(CodeSerializer codeSerializer) {
        return null;
    }

    public TokenResponse retriveToken(BasicAuthSerializer serializer) {
        return null;
    }
}
