/*
 * This file is generated by jOOQ.
*/
package com.generator;


import com.generator.tables.Addresslist;
import com.generator.tables.Authorization;
import com.generator.tables.Company;
import com.generator.tables.Companyaddress;
import com.generator.tables.Credit;
import com.generator.tables.CreditChain;
import com.generator.tables.CreditData;
import com.generator.tables.Creditupdatetask;
import com.generator.tables.Fundamentalcertificate;
import com.generator.tables.Guaranty;
import com.generator.tables.GuarantyChain;
import com.generator.tables.GuarantyData;
import com.generator.tables.Guarantystateupdatetask;
import com.generator.tables.House;
import com.generator.tables.Land;
import com.generator.tables.Machine;
import com.generator.tables.Message;
import com.generator.tables.Protocol;
import com.generator.tables.Report;
import com.generator.tables.Securitiesinformation;
import com.generator.tables.records.AddresslistRecord;
import com.generator.tables.records.AuthorizationRecord;
import com.generator.tables.records.CompanyRecord;
import com.generator.tables.records.CompanyaddressRecord;
import com.generator.tables.records.CreditChainRecord;
import com.generator.tables.records.CreditDataRecord;
import com.generator.tables.records.CreditRecord;
import com.generator.tables.records.CreditupdatetaskRecord;
import com.generator.tables.records.FundamentalcertificateRecord;
import com.generator.tables.records.GuarantyChainRecord;
import com.generator.tables.records.GuarantyDataRecord;
import com.generator.tables.records.GuarantyRecord;
import com.generator.tables.records.GuarantystateupdatetaskRecord;
import com.generator.tables.records.HouseRecord;
import com.generator.tables.records.LandRecord;
import com.generator.tables.records.MachineRecord;
import com.generator.tables.records.MessageRecord;
import com.generator.tables.records.ProtocolRecord;
import com.generator.tables.records.ReportRecord;
import com.generator.tables.records.SecuritiesinformationRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>bcinvest</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CreditupdatetaskRecord, Integer> IDENTITY_CREDITUPDATETASK = Identities0.IDENTITY_CREDITUPDATETASK;
    public static final Identity<GuarantystateupdatetaskRecord, Integer> IDENTITY_GUARANTYSTATEUPDATETASK = Identities0.IDENTITY_GUARANTYSTATEUPDATETASK;
    public static final Identity<MessageRecord, Integer> IDENTITY_MESSAGE = Identities0.IDENTITY_MESSAGE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddresslistRecord> KEY_ADDRESSLIST_PRIMARY = UniqueKeys0.KEY_ADDRESSLIST_PRIMARY;
    public static final UniqueKey<AuthorizationRecord> KEY_AUTHORIZATION_PRIMARY = UniqueKeys0.KEY_AUTHORIZATION_PRIMARY;
    public static final UniqueKey<AuthorizationRecord> KEY_AUTHORIZATION_TOKEN = UniqueKeys0.KEY_AUTHORIZATION_TOKEN;
    public static final UniqueKey<CompanyRecord> KEY_COMPANY_PRIMARY = UniqueKeys0.KEY_COMPANY_PRIMARY;
    public static final UniqueKey<CompanyRecord> KEY_COMPANY_EMAILADDRESS = UniqueKeys0.KEY_COMPANY_EMAILADDRESS;
    public static final UniqueKey<CompanyRecord> KEY_COMPANY_TOKEN = UniqueKeys0.KEY_COMPANY_TOKEN;
    public static final UniqueKey<CompanyaddressRecord> KEY_COMPANYADDRESS_PRIMARY = UniqueKeys0.KEY_COMPANYADDRESS_PRIMARY;
    public static final UniqueKey<CreditRecord> KEY_CREDIT_PRIMARY = UniqueKeys0.KEY_CREDIT_PRIMARY;
    public static final UniqueKey<CreditChainRecord> KEY_CREDIT_CHAIN_PRIMARY = UniqueKeys0.KEY_CREDIT_CHAIN_PRIMARY;
    public static final UniqueKey<CreditDataRecord> KEY_CREDIT_DATA_PRIMARY = UniqueKeys0.KEY_CREDIT_DATA_PRIMARY;
    public static final UniqueKey<CreditupdatetaskRecord> KEY_CREDITUPDATETASK_PRIMARY = UniqueKeys0.KEY_CREDITUPDATETASK_PRIMARY;
    public static final UniqueKey<FundamentalcertificateRecord> KEY_FUNDAMENTALCERTIFICATE_PRIMARY = UniqueKeys0.KEY_FUNDAMENTALCERTIFICATE_PRIMARY;
    public static final UniqueKey<GuarantyRecord> KEY_GUARANTY_PRIMARY = UniqueKeys0.KEY_GUARANTY_PRIMARY;
    public static final UniqueKey<GuarantyChainRecord> KEY_GUARANTY_CHAIN_PRIMARY = UniqueKeys0.KEY_GUARANTY_CHAIN_PRIMARY;
    public static final UniqueKey<GuarantyDataRecord> KEY_GUARANTY_DATA_PRIMARY = UniqueKeys0.KEY_GUARANTY_DATA_PRIMARY;
    public static final UniqueKey<GuarantystateupdatetaskRecord> KEY_GUARANTYSTATEUPDATETASK_PRIMARY = UniqueKeys0.KEY_GUARANTYSTATEUPDATETASK_PRIMARY;
    public static final UniqueKey<HouseRecord> KEY_HOUSE_PRIMARY = UniqueKeys0.KEY_HOUSE_PRIMARY;
    public static final UniqueKey<LandRecord> KEY_LAND_PRIMARY = UniqueKeys0.KEY_LAND_PRIMARY;
    public static final UniqueKey<MachineRecord> KEY_MACHINE_PRIMARY = UniqueKeys0.KEY_MACHINE_PRIMARY;
    public static final UniqueKey<MessageRecord> KEY_MESSAGE_PRIMARY = UniqueKeys0.KEY_MESSAGE_PRIMARY;
    public static final UniqueKey<ProtocolRecord> KEY_PROTOCOL_PRIMARY = UniqueKeys0.KEY_PROTOCOL_PRIMARY;
    public static final UniqueKey<ReportRecord> KEY_REPORT_PRIMARY = UniqueKeys0.KEY_REPORT_PRIMARY;
    public static final UniqueKey<SecuritiesinformationRecord> KEY_SECURITIESINFORMATION_PRIMARY = UniqueKeys0.KEY_SECURITIESINFORMATION_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CreditRecord, GuarantyRecord> CREDIT_FK_GUARANTY = ForeignKeys0.CREDIT_FK_GUARANTY;
    public static final ForeignKey<CreditChainRecord, AddresslistRecord> CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK = ForeignKeys0.CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK;
    public static final ForeignKey<CreditDataRecord, CreditChainRecord> CREDIT_DATA_CHAIN_THIS_HASH_FK = ForeignKeys0.CREDIT_DATA_CHAIN_THIS_HASH_FK;
    public static final ForeignKey<FundamentalcertificateRecord, CompanyRecord> FUNDAMENTALCERTIFICATE_IBFK_1 = ForeignKeys0.FUNDAMENTALCERTIFICATE_IBFK_1;
    public static final ForeignKey<GuarantyChainRecord, AddresslistRecord> GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK = ForeignKeys0.GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK;
    public static final ForeignKey<GuarantyDataRecord, GuarantyChainRecord> GUARANTY_DATA_CHAIN_THIS_HASH_FK = ForeignKeys0.GUARANTY_DATA_CHAIN_THIS_HASH_FK;
    public static final ForeignKey<HouseRecord, GuarantyRecord> HOUSE_FK_GUARANTY = ForeignKeys0.HOUSE_FK_GUARANTY;
    public static final ForeignKey<LandRecord, GuarantyRecord> LAND_FK_GUARANTY = ForeignKeys0.LAND_FK_GUARANTY;
    public static final ForeignKey<MachineRecord, GuarantyRecord> MACHINE_FK_GUARANTY = ForeignKeys0.MACHINE_FK_GUARANTY;
    public static final ForeignKey<ProtocolRecord, GuarantyRecord> FK_PROTOCOL_TO_GURANTY = ForeignKeys0.FK_PROTOCOL_TO_GURANTY;
    public static final ForeignKey<SecuritiesinformationRecord, CompanyRecord> SECURITIESINFORMATION_IBFK_1 = ForeignKeys0.SECURITIESINFORMATION_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<CreditupdatetaskRecord, Integer> IDENTITY_CREDITUPDATETASK = Internal.createIdentity(Creditupdatetask.CREDITUPDATETASK, Creditupdatetask.CREDITUPDATETASK.ID);
        public static Identity<GuarantystateupdatetaskRecord, Integer> IDENTITY_GUARANTYSTATEUPDATETASK = Internal.createIdentity(Guarantystateupdatetask.GUARANTYSTATEUPDATETASK, Guarantystateupdatetask.GUARANTYSTATEUPDATETASK.TASKID);
        public static Identity<MessageRecord, Integer> IDENTITY_MESSAGE = Internal.createIdentity(Message.MESSAGE, Message.MESSAGE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AddresslistRecord> KEY_ADDRESSLIST_PRIMARY = Internal.createUniqueKey(Addresslist.ADDRESSLIST, "KEY_addresslist_PRIMARY", Addresslist.ADDRESSLIST.ADDRESS);
        public static final UniqueKey<AuthorizationRecord> KEY_AUTHORIZATION_PRIMARY = Internal.createUniqueKey(Authorization.AUTHORIZATION, "KEY_authorization_PRIMARY", Authorization.AUTHORIZATION.ACCOUNTNUM);
        public static final UniqueKey<AuthorizationRecord> KEY_AUTHORIZATION_TOKEN = Internal.createUniqueKey(Authorization.AUTHORIZATION, "KEY_authorization_Token", Authorization.AUTHORIZATION.TOKEN);
        public static final UniqueKey<CompanyRecord> KEY_COMPANY_PRIMARY = Internal.createUniqueKey(Company.COMPANY, "KEY_company_PRIMARY", Company.COMPANY.ACCOUNTNUM);
        public static final UniqueKey<CompanyRecord> KEY_COMPANY_EMAILADDRESS = Internal.createUniqueKey(Company.COMPANY, "KEY_company_EmailAddress", Company.COMPANY.EMAILADDRESS);
        public static final UniqueKey<CompanyRecord> KEY_COMPANY_TOKEN = Internal.createUniqueKey(Company.COMPANY, "KEY_company_Token", Company.COMPANY.TOKEN);
        public static final UniqueKey<CompanyaddressRecord> KEY_COMPANYADDRESS_PRIMARY = Internal.createUniqueKey(Companyaddress.COMPANYADDRESS, "KEY_companyaddress_PRIMARY", Companyaddress.COMPANYADDRESS.ACCOUNTNUM);
        public static final UniqueKey<CreditRecord> KEY_CREDIT_PRIMARY = Internal.createUniqueKey(Credit.CREDIT, "KEY_credit_PRIMARY", Credit.CREDIT.ACCOUNTNUM, Credit.CREDIT.GUARANTYID, Credit.CREDIT.REPORTID);
        public static final UniqueKey<CreditChainRecord> KEY_CREDIT_CHAIN_PRIMARY = Internal.createUniqueKey(CreditChain.CREDIT_CHAIN, "KEY_credit_chain_PRIMARY", CreditChain.CREDIT_CHAIN.THIS_HASH);
        public static final UniqueKey<CreditDataRecord> KEY_CREDIT_DATA_PRIMARY = Internal.createUniqueKey(CreditData.CREDIT_DATA, "KEY_credit_data_PRIMARY", CreditData.CREDIT_DATA.BLOCK_HASH, CreditData.CREDIT_DATA.ID);
        public static final UniqueKey<CreditupdatetaskRecord> KEY_CREDITUPDATETASK_PRIMARY = Internal.createUniqueKey(Creditupdatetask.CREDITUPDATETASK, "KEY_creditupdatetask_PRIMARY", Creditupdatetask.CREDITUPDATETASK.ID);
        public static final UniqueKey<FundamentalcertificateRecord> KEY_FUNDAMENTALCERTIFICATE_PRIMARY = Internal.createUniqueKey(Fundamentalcertificate.FUNDAMENTALCERTIFICATE, "KEY_fundamentalcertificate_PRIMARY", Fundamentalcertificate.FUNDAMENTALCERTIFICATE.ACCOUNTNUM);
        public static final UniqueKey<GuarantyRecord> KEY_GUARANTY_PRIMARY = Internal.createUniqueKey(Guaranty.GUARANTY, "KEY_guaranty_PRIMARY", Guaranty.GUARANTY.GUARANTYID);
        public static final UniqueKey<GuarantyChainRecord> KEY_GUARANTY_CHAIN_PRIMARY = Internal.createUniqueKey(GuarantyChain.GUARANTY_CHAIN, "KEY_guaranty_chain_PRIMARY", GuarantyChain.GUARANTY_CHAIN.THIS_HASH);
        public static final UniqueKey<GuarantyDataRecord> KEY_GUARANTY_DATA_PRIMARY = Internal.createUniqueKey(GuarantyData.GUARANTY_DATA, "KEY_guaranty_data_PRIMARY", GuarantyData.GUARANTY_DATA.BLOCK_HASH, GuarantyData.GUARANTY_DATA.ID);
        public static final UniqueKey<GuarantystateupdatetaskRecord> KEY_GUARANTYSTATEUPDATETASK_PRIMARY = Internal.createUniqueKey(Guarantystateupdatetask.GUARANTYSTATEUPDATETASK, "KEY_guarantystateupdatetask_PRIMARY", Guarantystateupdatetask.GUARANTYSTATEUPDATETASK.TASKID);
        public static final UniqueKey<HouseRecord> KEY_HOUSE_PRIMARY = Internal.createUniqueKey(House.HOUSE, "KEY_house_PRIMARY", House.HOUSE.GUARANTYID);
        public static final UniqueKey<LandRecord> KEY_LAND_PRIMARY = Internal.createUniqueKey(Land.LAND, "KEY_land_PRIMARY", Land.LAND.GUARANTYID);
        public static final UniqueKey<MachineRecord> KEY_MACHINE_PRIMARY = Internal.createUniqueKey(Machine.MACHINE, "KEY_machine_PRIMARY", Machine.MACHINE.GUARANTYID);
        public static final UniqueKey<MessageRecord> KEY_MESSAGE_PRIMARY = Internal.createUniqueKey(Message.MESSAGE, "KEY_message_PRIMARY", Message.MESSAGE.ID);
        public static final UniqueKey<ProtocolRecord> KEY_PROTOCOL_PRIMARY = Internal.createUniqueKey(Protocol.PROTOCOL, "KEY_protocol_PRIMARY", Protocol.PROTOCOL.PROTOCOLID);
        public static final UniqueKey<ReportRecord> KEY_REPORT_PRIMARY = Internal.createUniqueKey(Report.REPORT, "KEY_report_PRIMARY", Report.REPORT.REPORTID);
        public static final UniqueKey<SecuritiesinformationRecord> KEY_SECURITIESINFORMATION_PRIMARY = Internal.createUniqueKey(Securitiesinformation.SECURITIESINFORMATION, "KEY_securitiesinformation_PRIMARY", Securitiesinformation.SECURITIESINFORMATION.ACCOUNTNUM);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CreditRecord, GuarantyRecord> CREDIT_FK_GUARANTY = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_PRIMARY, Credit.CREDIT, "credit_fk_guaranty", Credit.CREDIT.GUARANTYID);
        public static final ForeignKey<CreditChainRecord, AddresslistRecord> CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK = Internal.createForeignKey(com.generator.Keys.KEY_ADDRESSLIST_PRIMARY, CreditChain.CREDIT_CHAIN, "credit_chain_addresslist_address_fk", CreditChain.CREDIT_CHAIN.ADDRESS);
        public static final ForeignKey<CreditDataRecord, CreditChainRecord> CREDIT_DATA_CHAIN_THIS_HASH_FK = Internal.createForeignKey(com.generator.Keys.KEY_CREDIT_CHAIN_PRIMARY, CreditData.CREDIT_DATA, "credit_data_chain_this_hash_fk", CreditData.CREDIT_DATA.BLOCK_HASH);
        public static final ForeignKey<FundamentalcertificateRecord, CompanyRecord> FUNDAMENTALCERTIFICATE_IBFK_1 = Internal.createForeignKey(com.generator.Keys.KEY_COMPANY_PRIMARY, Fundamentalcertificate.FUNDAMENTALCERTIFICATE, "fundamentalcertificate_ibfk_1", Fundamentalcertificate.FUNDAMENTALCERTIFICATE.ACCOUNTNUM);
        public static final ForeignKey<GuarantyChainRecord, AddresslistRecord> GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK = Internal.createForeignKey(com.generator.Keys.KEY_ADDRESSLIST_PRIMARY, GuarantyChain.GUARANTY_CHAIN, "guaranty_chain_addresslist_address_fk", GuarantyChain.GUARANTY_CHAIN.ADDRESS);
        public static final ForeignKey<GuarantyDataRecord, GuarantyChainRecord> GUARANTY_DATA_CHAIN_THIS_HASH_FK = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_CHAIN_PRIMARY, GuarantyData.GUARANTY_DATA, "guaranty_data_chain_this_hash_fk", GuarantyData.GUARANTY_DATA.BLOCK_HASH);
        public static final ForeignKey<HouseRecord, GuarantyRecord> HOUSE_FK_GUARANTY = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_PRIMARY, House.HOUSE, "house_fk_guaranty", House.HOUSE.GUARANTYID);
        public static final ForeignKey<LandRecord, GuarantyRecord> LAND_FK_GUARANTY = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_PRIMARY, Land.LAND, "land_fk_guaranty", Land.LAND.GUARANTYID);
        public static final ForeignKey<MachineRecord, GuarantyRecord> MACHINE_FK_GUARANTY = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_PRIMARY, Machine.MACHINE, "machine_fk_guaranty", Machine.MACHINE.GUARANTYID);
        public static final ForeignKey<ProtocolRecord, GuarantyRecord> FK_PROTOCOL_TO_GURANTY = Internal.createForeignKey(com.generator.Keys.KEY_GUARANTY_PRIMARY, Protocol.PROTOCOL, "fk_protocol_to_guranty", Protocol.PROTOCOL.GURANTYID);
        public static final ForeignKey<SecuritiesinformationRecord, CompanyRecord> SECURITIESINFORMATION_IBFK_1 = Internal.createForeignKey(com.generator.Keys.KEY_COMPANY_PRIMARY, Securitiesinformation.SECURITIESINFORMATION, "securitiesinformation_ibfk_1", Securitiesinformation.SECURITIESINFORMATION.ACCOUNTNUM);
    }
}
