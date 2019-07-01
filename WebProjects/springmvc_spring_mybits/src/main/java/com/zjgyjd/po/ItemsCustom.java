package com.zjgyjd.po;

import java.util.Objects;

public class ItemsCustom extends Items {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemsCustom)) return false;
        ItemsCustom that = (ItemsCustom) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCreatetime(), that.getCreatetime()) &&
                Objects.equals(getDetail(), that.getDetail()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getName(),getPic(),getPrice(),getDetail(),getCreatetime());
    }
}
