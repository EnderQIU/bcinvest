/*
 * This file is generated by jOOQ.
*/
package com.bcgenerator;


import com.bcgenerator.tables.Addresslist;
import com.bcgenerator.tables.CreditChain;
import com.bcgenerator.tables.CreditData;
import com.bcgenerator.tables.GuarantyChain;
import com.bcgenerator.tables.GuarantyData;
import com.bcgenerator.tables.records.AddresslistRecord;
import com.bcgenerator.tables.records.CreditChainRecord;
import com.bcgenerator.tables.records.CreditDataRecord;
import com.bcgenerator.tables.records.GuarantyChainRecord;
import com.bcgenerator.tables.records.GuarantyDataRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>blockchain</code> schema.
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


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddresslistRecord> KEY_ADDRESSLIST_PRIMARY = UniqueKeys0.KEY_ADDRESSLIST_PRIMARY;
    public static final UniqueKey<CreditChainRecord> KEY_CREDIT_CHAIN_PRIMARY = UniqueKeys0.KEY_CREDIT_CHAIN_PRIMARY;
    public static final UniqueKey<CreditDataRecord> KEY_CREDIT_DATA_PRIMARY = UniqueKeys0.KEY_CREDIT_DATA_PRIMARY;
    public static final UniqueKey<GuarantyChainRecord> KEY_GUARANTY_CHAIN_PRIMARY = UniqueKeys0.KEY_GUARANTY_CHAIN_PRIMARY;
    public static final UniqueKey<GuarantyDataRecord> KEY_GUARANTY_DATA_PRIMARY = UniqueKeys0.KEY_GUARANTY_DATA_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CreditChainRecord, AddresslistRecord> CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK = ForeignKeys0.CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK;
    public static final ForeignKey<CreditDataRecord, CreditChainRecord> CREDIT_DATA_CHAIN_THIS_HASH_FK = ForeignKeys0.CREDIT_DATA_CHAIN_THIS_HASH_FK;
    public static final ForeignKey<GuarantyChainRecord, AddresslistRecord> GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK = ForeignKeys0.GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK;
    public static final ForeignKey<GuarantyDataRecord, GuarantyChainRecord> GUARANTY_DATA_CHAIN_THIS_HASH_FK = ForeignKeys0.GUARANTY_DATA_CHAIN_THIS_HASH_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AddresslistRecord> KEY_ADDRESSLIST_PRIMARY = Internal.createUniqueKey(Addresslist.ADDRESSLIST, "KEY_addresslist_PRIMARY", Addresslist.ADDRESSLIST.ADDRESS);
        public static final UniqueKey<CreditChainRecord> KEY_CREDIT_CHAIN_PRIMARY = Internal.createUniqueKey(CreditChain.CREDIT_CHAIN, "KEY_credit_chain_PRIMARY", CreditChain.CREDIT_CHAIN.THIS_HASH);
        public static final UniqueKey<CreditDataRecord> KEY_CREDIT_DATA_PRIMARY = Internal.createUniqueKey(CreditData.CREDIT_DATA, "KEY_credit_data_PRIMARY", CreditData.CREDIT_DATA.BLOCK_HASH, CreditData.CREDIT_DATA.ID);
        public static final UniqueKey<GuarantyChainRecord> KEY_GUARANTY_CHAIN_PRIMARY = Internal.createUniqueKey(GuarantyChain.GUARANTY_CHAIN, "KEY_guaranty_chain_PRIMARY", GuarantyChain.GUARANTY_CHAIN.THIS_HASH);
        public static final UniqueKey<GuarantyDataRecord> KEY_GUARANTY_DATA_PRIMARY = Internal.createUniqueKey(GuarantyData.GUARANTY_DATA, "KEY_guaranty_data_PRIMARY", GuarantyData.GUARANTY_DATA.BLOCK_HASH, GuarantyData.GUARANTY_DATA.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CreditChainRecord, AddresslistRecord> CREDIT_CHAIN_ADDRESSLIST_ADDRESS_FK = Internal.createForeignKey(com.bcgenerator.Keys.KEY_ADDRESSLIST_PRIMARY, CreditChain.CREDIT_CHAIN, "credit_chain_addresslist_address_fk", CreditChain.CREDIT_CHAIN.ADDRESS);
        public static final ForeignKey<CreditDataRecord, CreditChainRecord> CREDIT_DATA_CHAIN_THIS_HASH_FK = Internal.createForeignKey(com.bcgenerator.Keys.KEY_CREDIT_CHAIN_PRIMARY, CreditData.CREDIT_DATA, "credit_data_chain_this_hash_fk", CreditData.CREDIT_DATA.BLOCK_HASH);
        public static final ForeignKey<GuarantyChainRecord, AddresslistRecord> GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK = Internal.createForeignKey(com.bcgenerator.Keys.KEY_ADDRESSLIST_PRIMARY, GuarantyChain.GUARANTY_CHAIN, "guaranty_chain_addresslist_address_fk", GuarantyChain.GUARANTY_CHAIN.ADDRESS);
        public static final ForeignKey<GuarantyDataRecord, GuarantyChainRecord> GUARANTY_DATA_CHAIN_THIS_HASH_FK = Internal.createForeignKey(com.bcgenerator.Keys.KEY_GUARANTY_CHAIN_PRIMARY, GuarantyData.GUARANTY_DATA, "guaranty_data_chain_this_hash_fk", GuarantyData.GUARANTY_DATA.BLOCK_HASH);
    }
}
