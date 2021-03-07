/*
 * This file is generated by jOOQ.
 */
package brs.schema.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import brs.schema.Db;
import brs.schema.Indexes;
import brs.schema.Keys;
import brs.schema.tables.records.TransactionRecord;


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
public class Transaction extends TableImpl<TransactionRecord> {

    private static final long serialVersionUID = 1025296232;

    /**
     * The reference instance of <code>DB.transaction</code>
     */
    public static final Transaction TRANSACTION = new Transaction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionRecord> getRecordType() {
        return TransactionRecord.class;
    }

    /**
     * The column <code>DB.transaction.db_id</code>.
     */
    public final TableField<TransactionRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.transaction.id</code>.
     */
    public final TableField<TransactionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.deadline</code>.
     */
    public final TableField<TransactionRecord, Short> DEADLINE = createField("deadline", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.sender_public_key</code>.
     */
    public final TableField<TransactionRecord, byte[]> SENDER_PUBLIC_KEY = createField("sender_public_key", org.jooq.impl.SQLDataType.VARBINARY(32).nullable(false), this, "");

    /**
     * The column <code>DB.transaction.recipient_id</code>.
     */
    public final TableField<TransactionRecord, Long> RECIPIENT_ID = createField("recipient_id", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>DB.transaction.amount</code>.
     */
    public final TableField<TransactionRecord, Long> AMOUNT = createField("amount", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.fee</code>.
     */
    public final TableField<TransactionRecord, Long> FEE = createField("fee", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.height</code>.
     */
    public final TableField<TransactionRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.block_id</code>.
     */
    public final TableField<TransactionRecord, Long> BLOCK_ID = createField("block_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.signature</code>.
     */
    public final TableField<TransactionRecord, byte[]> SIGNATURE = createField("signature", org.jooq.impl.SQLDataType.VARBINARY(64).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARBINARY)), this, "");

    /**
     * The column <code>DB.transaction.timestamp</code>.
     */
    public final TableField<TransactionRecord, Integer> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.type</code>.
     */
    public final TableField<TransactionRecord, Byte> TYPE = createField("type", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.subtype</code>.
     */
    public final TableField<TransactionRecord, Byte> SUBTYPE = createField("subtype", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.sender_id</code>.
     */
    public final TableField<TransactionRecord, Long> SENDER_ID = createField("sender_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.block_timestamp</code>.
     */
    public final TableField<TransactionRecord, Integer> BLOCK_TIMESTAMP = createField("block_timestamp", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.full_hash</code>.
     */
    public final TableField<TransactionRecord, byte[]> FULL_HASH = createField("full_hash", org.jooq.impl.SQLDataType.VARBINARY(32).nullable(false), this, "");

    /**
     * The column <code>DB.transaction.referenced_transaction_fullhash</code>.
     */
    public final TableField<TransactionRecord, byte[]> REFERENCED_TRANSACTION_FULLHASH = createField("referenced_transaction_fullhash", org.jooq.impl.SQLDataType.VARBINARY(32).defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.VARBINARY)), this, "");

    /**
     * The column <code>DB.transaction.attachment_bytes</code>.
     */
    public final TableField<TransactionRecord, byte[]> ATTACHMENT_BYTES = createField("attachment_bytes", org.jooq.impl.SQLDataType.BLOB.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BLOB)), this, "");

    /**
     * The column <code>DB.transaction.version</code>.
     */
    public final TableField<TransactionRecord, Byte> VERSION = createField("version", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>DB.transaction.has_message</code>.
     */
    public final TableField<TransactionRecord, Boolean> HAS_MESSAGE = createField("has_message", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>DB.transaction.has_encrypted_message</code>.
     */
    public final TableField<TransactionRecord, Boolean> HAS_ENCRYPTED_MESSAGE = createField("has_encrypted_message", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>DB.transaction.has_public_key_announcement</code>.
     */
    public final TableField<TransactionRecord, Boolean> HAS_PUBLIC_KEY_ANNOUNCEMENT = createField("has_public_key_announcement", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>DB.transaction.ec_block_height</code>.
     */
    public final TableField<TransactionRecord, Integer> EC_BLOCK_HEIGHT = createField("ec_block_height", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>DB.transaction.ec_block_id</code>.
     */
    public final TableField<TransactionRecord, Long> EC_BLOCK_ID = createField("ec_block_id", org.jooq.impl.SQLDataType.BIGINT.defaultValue(org.jooq.impl.DSL.field("NULL", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>DB.transaction.has_encrypttoself_message</code>.
     */
    public final TableField<TransactionRecord, Boolean> HAS_ENCRYPTTOSELF_MESSAGE = createField("has_encrypttoself_message", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.transaction</code> table reference
     */
    public Transaction() {
        this(DSL.name("transaction"), null);
    }

    /**
     * Create an aliased <code>DB.transaction</code> table reference
     */
    public Transaction(String alias) {
        this(DSL.name(alias), TRANSACTION);
    }

    /**
     * Create an aliased <code>DB.transaction</code> table reference
     */
    public Transaction(Name alias) {
        this(alias, TRANSACTION);
    }

    private Transaction(Name alias, Table<TransactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transaction(Name alias, Table<TransactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Transaction(Table<O> child, ForeignKey<O, TransactionRecord> key) {
        super(child, key, TRANSACTION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TRANSACTION_CONSTRAINT_FF, Indexes.TRANSACTION_PRIMARY, Indexes.TRANSACTION_TRANSACTION_BLOCK_TIMESTAMP_IDX, Indexes.TRANSACTION_TRANSACTION_FULL_HASH_IDX, Indexes.TRANSACTION_TRANSACTION_ID_IDX, Indexes.TRANSACTION_TRANSACTION_RECIPIENT_ID_AMOUNT_HEIGHT_IDX, Indexes.TRANSACTION_TRANSACTION_RECIPIENT_ID_IDX, Indexes.TRANSACTION_TRANSACTION_SENDER_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TransactionRecord, Long> getIdentity() {
        return Keys.IDENTITY_TRANSACTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TransactionRecord> getPrimaryKey() {
        return Keys.KEY_TRANSACTION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TransactionRecord>> getKeys() {
        return Arrays.<UniqueKey<TransactionRecord>>asList(Keys.KEY_TRANSACTION_PRIMARY, Keys.KEY_TRANSACTION_TRANSACTION_ID_IDX, Keys.KEY_TRANSACTION_TRANSACTION_FULL_HASH_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TransactionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TransactionRecord, ?>>asList(Keys.CONSTRAINT_FF);
    }

    public Block block() {
        return new Block(this, Keys.CONSTRAINT_FF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaction as(String alias) {
        return new Transaction(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaction as(Name alias) {
        return new Transaction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaction rename(String name) {
        return new Transaction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaction rename(Name name) {
        return new Transaction(name, null);
    }
}
