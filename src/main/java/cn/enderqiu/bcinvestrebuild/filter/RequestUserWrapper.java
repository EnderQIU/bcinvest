package cn.enderqiu.bcinvestrebuild.filter;

import com.generator.tables.records.AuthorityRecord;
import com.generator.tables.records.BankoperatorRecord;
import com.generator.tables.records.CompanyRecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * com.hw.myp2c.common.filter
 * Administrator
 * 2017/10/18
 **/
public class RequestUserWrapper<T> extends HttpServletRequestWrapper {

    private T userRecord;

    public RequestUserWrapper(HttpServletRequest request) {
        super(request);
    }

    public T getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(T userRecord) {
        this.userRecord = userRecord;
    }
}