package com.zjgyjd.po;

import java.sql.Timestamp;

public class ItemsEx extends Items{
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        timestamp = new Timestamp(getCreatetime().getTime());
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
