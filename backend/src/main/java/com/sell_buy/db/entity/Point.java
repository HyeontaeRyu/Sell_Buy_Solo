package com.sell_buy.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Point {
    @Id
    @Column(name = "mem_id")
    private Long memId;
    @JoinColumn(name = "mem_id", referencedColumnName = "mem_id", insertable = false, updatable = false)
    private Member member;
    private Integer balance;
}
