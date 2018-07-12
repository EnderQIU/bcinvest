/*
 * This file is generated by jOOQ.
*/
package com.generator;


import com.generator.tables.Accesstoken;
import com.generator.tables.Authorization;
import com.generator.tables.Company;
import com.generator.tables.Companyaddress;
import com.generator.tables.Credit;
import com.generator.tables.Fundamentalcertificate;
import com.generator.tables.Guaranty;
import com.generator.tables.House;
import com.generator.tables.Land;
import com.generator.tables.Machine;
import com.generator.tables.Protocol;
import com.generator.tables.Report;
import com.generator.tables.Securitiesinformation;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>bcinvest</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCESSTOKEN_ACCOUNTNUM = Indexes0.ACCESSTOKEN_ACCOUNTNUM;
    public static final Index AUTHORIZATION_PRIMARY = Indexes0.AUTHORIZATION_PRIMARY;
    public static final Index AUTHORIZATION_TOKEN = Indexes0.AUTHORIZATION_TOKEN;
    public static final Index COMPANY_EMAILADDRESS = Indexes0.COMPANY_EMAILADDRESS;
    public static final Index COMPANY_PRIMARY = Indexes0.COMPANY_PRIMARY;
    public static final Index COMPANY_TOKEN = Indexes0.COMPANY_TOKEN;
    public static final Index COMPANYADDRESS_PRIMARY = Indexes0.COMPANYADDRESS_PRIMARY;
    public static final Index CREDIT_CREDIT_FK_GUARANTY = Indexes0.CREDIT_CREDIT_FK_GUARANTY;
    public static final Index CREDIT_PRIMARY = Indexes0.CREDIT_PRIMARY;
    public static final Index FUNDAMENTALCERTIFICATE_PRIMARY = Indexes0.FUNDAMENTALCERTIFICATE_PRIMARY;
    public static final Index GUARANTY_GUARANTY_FK_COMPANY = Indexes0.GUARANTY_GUARANTY_FK_COMPANY;
    public static final Index GUARANTY_GUARANTY_FK_REPORT = Indexes0.GUARANTY_GUARANTY_FK_REPORT;
    public static final Index GUARANTY_PRIMARY = Indexes0.GUARANTY_PRIMARY;
    public static final Index HOUSE_PRIMARY = Indexes0.HOUSE_PRIMARY;
    public static final Index LAND_PRIMARY = Indexes0.LAND_PRIMARY;
    public static final Index MACHINE_PRIMARY = Indexes0.MACHINE_PRIMARY;
    public static final Index PROTOCOL_FK_PROTOCOL_TO_GURANTY = Indexes0.PROTOCOL_FK_PROTOCOL_TO_GURANTY;
    public static final Index PROTOCOL_PRIMARY = Indexes0.PROTOCOL_PRIMARY;
    public static final Index REPORT_AUTHNAME = Indexes0.REPORT_AUTHNAME;
    public static final Index REPORT_PRIMARY = Indexes0.REPORT_PRIMARY;
    public static final Index SECURITIESINFORMATION_PRIMARY = Indexes0.SECURITIESINFORMATION_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ACCESSTOKEN_ACCOUNTNUM = Internal.createIndex("AccountNum", Accesstoken.ACCESSTOKEN, new OrderField[] { Accesstoken.ACCESSTOKEN.ACCOUNTNUM }, false);
        public static Index AUTHORIZATION_PRIMARY = Internal.createIndex("PRIMARY", Authorization.AUTHORIZATION, new OrderField[] { Authorization.AUTHORIZATION.ACCOUNTNUM }, true);
        public static Index AUTHORIZATION_TOKEN = Internal.createIndex("Token", Authorization.AUTHORIZATION, new OrderField[] { Authorization.AUTHORIZATION.TOKEN }, true);
        public static Index COMPANY_EMAILADDRESS = Internal.createIndex("EmailAddress", Company.COMPANY, new OrderField[] { Company.COMPANY.EMAILADDRESS }, true);
        public static Index COMPANY_PRIMARY = Internal.createIndex("PRIMARY", Company.COMPANY, new OrderField[] { Company.COMPANY.ACCOUNTNUM }, true);
        public static Index COMPANY_TOKEN = Internal.createIndex("Token", Company.COMPANY, new OrderField[] { Company.COMPANY.TOKEN }, true);
        public static Index COMPANYADDRESS_PRIMARY = Internal.createIndex("PRIMARY", Companyaddress.COMPANYADDRESS, new OrderField[] { Companyaddress.COMPANYADDRESS.ACCOUNTNUM }, true);
        public static Index CREDIT_CREDIT_FK_GUARANTY = Internal.createIndex("credit_fk_guaranty", Credit.CREDIT, new OrderField[] { Credit.CREDIT.GUARANTYID }, false);
        public static Index CREDIT_PRIMARY = Internal.createIndex("PRIMARY", Credit.CREDIT, new OrderField[] { Credit.CREDIT.ACCOUNTNUM, Credit.CREDIT.GUARANTYID, Credit.CREDIT.REPORTID }, true);
        public static Index FUNDAMENTALCERTIFICATE_PRIMARY = Internal.createIndex("PRIMARY", Fundamentalcertificate.FUNDAMENTALCERTIFICATE, new OrderField[] { Fundamentalcertificate.FUNDAMENTALCERTIFICATE.ACCOUNTNUM }, true);
        public static Index GUARANTY_GUARANTY_FK_COMPANY = Internal.createIndex("guaranty_fk_company", Guaranty.GUARANTY, new OrderField[] { Guaranty.GUARANTY.ACCOUNTNUM }, false);
        public static Index GUARANTY_GUARANTY_FK_REPORT = Internal.createIndex("guaranty_fk_report", Guaranty.GUARANTY, new OrderField[] { Guaranty.GUARANTY.REPORTID }, false);
        public static Index GUARANTY_PRIMARY = Internal.createIndex("PRIMARY", Guaranty.GUARANTY, new OrderField[] { Guaranty.GUARANTY.GUARANTYID }, true);
        public static Index HOUSE_PRIMARY = Internal.createIndex("PRIMARY", House.HOUSE, new OrderField[] { House.HOUSE.GUARANTYID }, true);
        public static Index LAND_PRIMARY = Internal.createIndex("PRIMARY", Land.LAND, new OrderField[] { Land.LAND.GUARANTYID }, true);
        public static Index MACHINE_PRIMARY = Internal.createIndex("PRIMARY", Machine.MACHINE, new OrderField[] { Machine.MACHINE.GUARANTYID }, true);
        public static Index PROTOCOL_FK_PROTOCOL_TO_GURANTY = Internal.createIndex("fk_protocol_to_guranty", Protocol.PROTOCOL, new OrderField[] { Protocol.PROTOCOL.GURANTYID }, false);
        public static Index PROTOCOL_PRIMARY = Internal.createIndex("PRIMARY", Protocol.PROTOCOL, new OrderField[] { Protocol.PROTOCOL.PROTOCOLID }, true);
        public static Index REPORT_AUTHNAME = Internal.createIndex("AuthName", Report.REPORT, new OrderField[] { Report.REPORT.AUTHNAME }, false);
        public static Index REPORT_PRIMARY = Internal.createIndex("PRIMARY", Report.REPORT, new OrderField[] { Report.REPORT.REPORTID }, true);
        public static Index SECURITIESINFORMATION_PRIMARY = Internal.createIndex("PRIMARY", Securitiesinformation.SECURITIESINFORMATION, new OrderField[] { Securitiesinformation.SECURITIESINFORMATION.ACCOUNTNUM }, true);
    }
}
