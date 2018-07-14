package cn.enderqiu.bcinvestrebuild.filter;

import com.generator.tables.Authority;
import com.generator.tables.Bankoperator;
import com.generator.tables.Company;
import com.generator.tables.records.AuthorityRecord;
import com.generator.tables.records.BankoperatorRecord;
import com.generator.tables.records.CompanyRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class RequestFilter implements Filter {

    @Autowired
    private DSLContext dsl;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("Authorization");

        CompanyRecord companyRecord = dsl
                .fetchOne(Company.COMPANY, Company.COMPANY.TOKEN.eq(token));
        BankoperatorRecord bankoperatorRecord = dsl
                .fetchOne(Bankoperator.BANKOPERATOR, Bankoperator.BANKOPERATOR.TOKEN.eq(token));
        AuthorityRecord authorityRecord = dsl
                .fetchOne(Authority.AUTHORITY, Authority.AUTHORITY.TOKEN.eq(token));

        RequestUserWrapper requestUserWrapper = new RequestUserWrapper(request);
        if (companyRecord != null){
            requestUserWrapper.setUserRecord(companyRecord);
        }else if(bankoperatorRecord != null){
            requestUserWrapper.setUserRecord(bankoperatorRecord);
        }else if (authorityRecord !=  null){
            requestUserWrapper.setUserRecord(authorityRecord);
        }
        filterChain.doFilter(requestUserWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
