package com.example.CourseWork4.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "warehouse2")
public class Warehouse2
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
    private Goods goodFromWHSecondId;

    public Warehouse2()
    {
    }

    public Warehouse2(Integer goodID, Integer goodCount)
    {
        this.goodID = goodID;
        this.goodCount = goodCount;
        this.goodFromWHSecondId = goodFromWHSecondId;
    }

    @Override
    public String toString()
    {
        return "Warehouse2{" +
                "id=" + id +
                ", goodID=" + goodID +
                ", goodCount=" + goodCount +
                '}';
    }
}
