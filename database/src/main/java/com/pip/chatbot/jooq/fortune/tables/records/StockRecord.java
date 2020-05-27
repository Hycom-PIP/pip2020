/*
 * This file is generated by jOOQ.
 */
package com.pip.chatbot.jooq.fortune.tables.records;


import com.pip.chatbot.jooq.fortune.tables.Stock;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StockRecord extends UpdatableRecordImpl<StockRecord> implements Record5<Long, String, Float, LocalDateTime, Boolean> {

    private static final long serialVersionUID = 1144160775;

    /**
     * Setter for <code>fortune.stock.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>fortune.stock.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>fortune.stock.symbol</code>.
     */
    public void setSymbol(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>fortune.stock.symbol</code>.
     */
    public String getSymbol() {
        return (String) get(1);
    }

    /**
     * Setter for <code>fortune.stock.value</code>.
     */
    public void setValue(Float value) {
        set(2, value);
    }

    /**
     * Getter for <code>fortune.stock.value</code>.
     */
    public Float getValue() {
        return (Float) get(2);
    }

    /**
     * Setter for <code>fortune.stock.date</code>.
     */
    public void setDate(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>fortune.stock.date</code>.
     */
    public LocalDateTime getDate() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>fortune.stock.is_historical</code>.
     */
    public void setIsHistorical(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>fortune.stock.is_historical</code>.
     */
    public Boolean getIsHistorical() {
        return (Boolean) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, Float, LocalDateTime, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, String, Float, LocalDateTime, Boolean> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Stock.STOCK.ID;
    }

    @Override
    public Field<String> field2() {
        return Stock.STOCK.SYMBOL;
    }

    @Override
    public Field<Float> field3() {
        return Stock.STOCK.VALUE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Stock.STOCK.DATE;
    }

    @Override
    public Field<Boolean> field5() {
        return Stock.STOCK.IS_HISTORICAL;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getSymbol();
    }

    @Override
    public Float component3() {
        return getValue();
    }

    @Override
    public LocalDateTime component4() {
        return getDate();
    }

    @Override
    public Boolean component5() {
        return getIsHistorical();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getSymbol();
    }

    @Override
    public Float value3() {
        return getValue();
    }

    @Override
    public LocalDateTime value4() {
        return getDate();
    }

    @Override
    public Boolean value5() {
        return getIsHistorical();
    }

    @Override
    public StockRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public StockRecord value2(String value) {
        setSymbol(value);
        return this;
    }

    @Override
    public StockRecord value3(Float value) {
        setValue(value);
        return this;
    }

    @Override
    public StockRecord value4(LocalDateTime value) {
        setDate(value);
        return this;
    }

    @Override
    public StockRecord value5(Boolean value) {
        setIsHistorical(value);
        return this;
    }

    @Override
    public StockRecord values(Long value1, String value2, Float value3, LocalDateTime value4, Boolean value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StockRecord
     */
    public StockRecord() {
        super(Stock.STOCK);
    }

    /**
     * Create a detached, initialised StockRecord
     */
    public StockRecord(Long id, String symbol, Float value, LocalDateTime date, Boolean isHistorical) {
        super(Stock.STOCK);

        set(0, id);
        set(1, symbol);
        set(2, value);
        set(3, date);
        set(4, isHistorical);
    }
}
