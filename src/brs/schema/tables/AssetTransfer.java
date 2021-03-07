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
import brs.schema.tables.records.AssetTransferRecord;


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
public class AssetTransfer extends TableImpl<AssetTransferRecord> {

    private static final long serialVersionUID = -1124591222;

    /**
     * The reference instance of <code>DB.asset_transfer</code>
     */
    public static final AssetTransfer ASSET_TRANSFER = new AssetTransfer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AssetTransferRecord> getRecordType() {
        return AssetTransferRecord.class;
    }

    /**
     * The column <code>DB.asset_transfer.db_id</code>.
     */
    public final TableField<AssetTransferRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.asset_transfer.id</code>.
     */
    public final TableField<AssetTransferRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.asset_id</code>.
     */
    public final TableField<AssetTransferRecord, Long> ASSET_ID = createField("asset_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.sender_id</code>.
     */
    public final TableField<AssetTransferRecord, Long> SENDER_ID = createField("sender_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.recipient_id</code>.
     */
    public final TableField<AssetTransferRecord, Long> RECIPIENT_ID = createField("recipient_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.quantity</code>.
     */
    public final TableField<AssetTransferRecord, Long> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.timestamp</code>.
     */
    public final TableField<AssetTransferRecord, Integer> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.asset_transfer.height</code>.
     */
    public final TableField<AssetTransferRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>DB.asset_transfer</code> table reference
     */
    public AssetTransfer() {
        this(DSL.name("asset_transfer"), null);
    }

    /**
     * Create an aliased <code>DB.asset_transfer</code> table reference
     */
    public AssetTransfer(String alias) {
        this(DSL.name(alias), ASSET_TRANSFER);
    }

    /**
     * Create an aliased <code>DB.asset_transfer</code> table reference
     */
    public AssetTransfer(Name alias) {
        this(alias, ASSET_TRANSFER);
    }

    private AssetTransfer(Name alias, Table<AssetTransferRecord> aliased) {
        this(alias, aliased, null);
    }

    private AssetTransfer(Name alias, Table<AssetTransferRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AssetTransfer(Table<O> child, ForeignKey<O, AssetTransferRecord> key) {
        super(child, key, ASSET_TRANSFER);
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
        return Arrays.<Index>asList(Indexes.ASSET_TRANSFER_ASSET_TRANSFER_ASSET_ID_IDX, Indexes.ASSET_TRANSFER_ASSET_TRANSFER_ID_IDX, Indexes.ASSET_TRANSFER_ASSET_TRANSFER_RECIPIENT_ID_IDX, Indexes.ASSET_TRANSFER_ASSET_TRANSFER_SENDER_ID_IDX, Indexes.ASSET_TRANSFER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AssetTransferRecord, Long> getIdentity() {
        return Keys.IDENTITY_ASSET_TRANSFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AssetTransferRecord> getPrimaryKey() {
        return Keys.KEY_ASSET_TRANSFER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AssetTransferRecord>> getKeys() {
        return Arrays.<UniqueKey<AssetTransferRecord>>asList(Keys.KEY_ASSET_TRANSFER_PRIMARY, Keys.KEY_ASSET_TRANSFER_ASSET_TRANSFER_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetTransfer as(String alias) {
        return new AssetTransfer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetTransfer as(Name alias) {
        return new AssetTransfer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetTransfer rename(String name) {
        return new AssetTransfer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetTransfer rename(Name name) {
        return new AssetTransfer(name, null);
    }
}
