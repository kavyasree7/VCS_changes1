/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbinvoice.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class PartnerCountResponse implements Serializable {


    @ColumnAlias("COUNT(name)")
    private Long count_name_;

    public Long getCount_name_() {
        return this.count_name_;
    }

    public void setCount_name_(Long count_name_) {
        this.count_name_ = count_name_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartnerCountResponse)) return false;
        final PartnerCountResponse partnerCountResponse = (PartnerCountResponse) o;
        return Objects.equals(getCount_name_(), partnerCountResponse.getCount_name_());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount_name_());
    }
}