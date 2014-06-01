package com.hqly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_country")
public class Country {

    @Id
    private Long key;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    private String capital;
    
    public Long getKey() {
        return key;
    }
    public void setKey(Long key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
}
