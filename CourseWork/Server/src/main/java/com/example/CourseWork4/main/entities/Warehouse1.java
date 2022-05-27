package com.example.CourseWork4.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "warehouse1")
public class Warehouse1
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "good_id")
    private Integer goodID;

    @Column(name = "good_count")
    private Integer goodCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id", insertable=false, updatable=false)
    private Goods goodFromWHFirstId;

    public Warehouse1()
    {
    }

    public Warehouse1(Integer goodID, Integer goodCount, Goods goodFromWH1Id)
    {
        this.goodID = goodID;
        this.goodCount = goodCount;
        this.goodFromWHFirstId = goodFromWH1Id;
    }

    @Override
    public String toString()
    {
        return "Warehouse1{" +
                "id=" + id +
                ", goodID=" + goodID +
                ", goodCount=" + goodCount +
                '}';
    }
}
