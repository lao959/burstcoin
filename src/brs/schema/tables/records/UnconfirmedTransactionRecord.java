/*
 * This file is generated by jOOQ.
 */
package brs.schema.tables.records;


import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import brs.schema.tables.UnconfirmedTransaction;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UnconfirmedTransactionRecord extends UpdatableRecordImpl<UnconfirmedTransactionRecord> implements Record8<Long, Long, Integer, Integer, Long, Integer, byte[], Integer> {

    private static final long serialVersionUID = 1304608377;

    /**
     * Setter for <code>DB.unconfirmed_transaction.db_id</code>.
     */
    public void setDbId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.db_id</code>.
     */
    public Long getDbId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.id</code>.
     */
    public void setId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.id</code>.
     */
    public Long getId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.expiration</code>.
     */
    public void setExpiration(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.expiration</code>.
     */
    public Integer getExpiration() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.transaction_height</code>.
     */
    public void setTransactionHeight(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.transaction_height</code>.
     */
    public Integer getTransactionHeight() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.fee_per_byte</code>.
     */
    public void setFeePerByte(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.fee_per_byte</code>.
     */
    public Long getFeePerByte() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.timestamp</code>.
     */
    public void setTimestamp(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.timestamp</code>.
     */
    public Integer getTimestamp() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.transaction_bytes</code>.
     */
    public void setTransactionBytes(byte... value) {
        set(6, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.transaction_bytes</code>.
     */
    public byte[] getTransactionBytes() {
        return (byte[]) get(6);
    }

    /**
     * Setter for <code>DB.unconfirmed_transaction.height</code>.
     */
    public void setHeight(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>DB.unconfirmed_transaction.height</code>.
     */
    public Integer getHeight() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Integer, Integer, Long, Integer, byte[], Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Integer, Integer, Long, Integer, byte[], Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.DB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.EXPIRATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.TRANSACTION_HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.FEE_PER_BYTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.TIMESTAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field7() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.TRANSACTION_BYTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return UnconfirmedTransaction.UNCONFIRMED_TRANSACTION.HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getExpiration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getTransactionHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getFeePerByte();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component7() {
        return getTransactionBytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getDbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getExpiration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getTransactionHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getFeePerByte();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getTimestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value7() {
        return getTransactionBytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value1(Long value) {
        setDbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value2(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value3(Integer value) {
        setExpiration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value4(Integer value) {
        setTransactionHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value5(Long value) {
        setFeePerByte(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value6(Integer value) {
        setTimestamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value7(byte... value) {
        setTransactionBytes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord value8(Integer value) {
        setHeight(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnconfirmedTransactionRecord values(Long value1, Long value2, Integer value3, Integer value4, Long value5, Integer value6, byte[] value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UnconfirmedTransactionRecord
     */
    public UnconfirmedTransactionRecord() {
        super(UnconfirmedTransaction.UNCONFIRMED_TRANSACTION);
    }

    /**
     * Create a detached, initialised UnconfirmedTransactionRecord
     */
    public UnconfirmedTransactionRecord(Long dbId, Long id, Integer expiration, Integer transactionHeight, Long feePerByte, Integer timestamp, byte[] transactionBytes, Integer height) {
        super(UnconfirmedTransaction.UNCONFIRMED_TRANSACTION);

        set(0, dbId);
        set(1, id);
        set(2, expiration);
        set(3, transactionHeight);
        set(4, feePerByte);
        set(5, timestamp);
        set(6, transactionBytes);
        set(7, height);
    }
}
