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
import brs.schema.tables.records.AtStateRecord;


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
public class AtState extends TableImpl<AtStateRecord> {

    private static final long serialVersionUID = 1109321253;

    /**
     * The reference instance of <code>DB.at_state</code>
     */
    public static final AtState AT_STATE = new AtState();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AtStateRecord> getRecordType() {
        return AtStateRecord.class;
    }

    /**
     * The column <code>DB.at_state.db_id</code>.
     */
    public final TableField<AtStateRecord, Long> DB_ID = createField("db_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>DB.at_state.at_id</code>.
     */
    public final TableField<AtStateRecord, Long> AT_ID = createField("at_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.state</code>.
     */
    public final TableField<AtStateRecord, byte[]> STATE = createField("state", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.prev_height</code>.
     */
    public final TableField<AtStateRecord, Integer> PREV_HEIGHT = createField("prev_height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.next_height</code>.
     */
    public final TableField<AtStateRecord, Integer> NEXT_HEIGHT = createField("next_height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.sleep_between</code>.
     */
    public final TableField<AtStateRecord, Integer> SLEEP_BETWEEN = createField("sleep_between", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.prev_balance</code>.
     */
    public final TableField<AtStateRecord, Long> PREV_BALANCE = createField("prev_balance", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.freeze_when_same_balance</code>.
     */
    public final TableField<AtStateRecord, Boolean> FREEZE_WHEN_SAME_BALANCE = createField("freeze_when_same_balance", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.min_activate_amount</code>.
     */
    public final TableField<AtStateRecord, Long> MIN_ACTIVATE_AMOUNT = createField("min_activate_amount", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.height</code>.
     */
    public final TableField<AtStateRecord, Integer> HEIGHT = createField("height", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB.at_state.latest</code>.
     */
    public final TableField<AtStateRecord, Boolean> LATEST = createField("latest", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>DB.at_state</code> table reference
     */
    public AtState() {
        this(DSL.name("at_state"), null);
    }

    /**
     * Create an aliased <code>DB.at_state</code> table reference
     */
    public AtState(String alias) {
        this(DSL.name(alias), AT_STATE);
    }

    /**
     * Create an aliased <code>DB.at_state</code> table reference
     */
    public AtState(Name alias) {
        this(alias, AT_STATE);
    }

    private AtState(Name alias, Table<AtStateRecord> aliased) {
        this(alias, aliased, null);
    }

    private AtState(Name alias, Table<AtStateRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AtState(Table<O> child, ForeignKey<O, AtStateRecord> key) {
        super(child, key, AT_STATE);
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
        return Arrays.<Index>asList(Indexes.AT_STATE_AT_STATE_AT_ID_HEIGHT_IDX, Indexes.AT_STATE_AT_STATE_ID_NEXT_HEIGHT_HEIGHT_IDX, Indexes.AT_STATE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AtStateRecord, Long> getIdentity() {
        return Keys.IDENTITY_AT_STATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AtStateRecord> getPrimaryKey() {
        return Keys.KEY_AT_STATE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AtStateRecord>> getKeys() {
        return Arrays.<UniqueKey<AtStateRecord>>asList(Keys.KEY_AT_STATE_PRIMARY, Keys.KEY_AT_STATE_AT_STATE_AT_ID_HEIGHT_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AtState as(String alias) {
        return new AtState(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AtState as(Name alias) {
        return new AtState(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AtState rename(String name) {
        return new AtState(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AtState rename(Name name) {
        return new AtState(name, null);
    }
}
