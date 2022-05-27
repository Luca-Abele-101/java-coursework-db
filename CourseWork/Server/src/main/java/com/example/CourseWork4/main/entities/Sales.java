package com.example.CourseWork4.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "sales")
public class Sales
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "good_id", nullable = false)
    private Integer goodID;

    @Column(name = "good_count", nullable = false)
    private Integer goodCount;

    @Column(name = "create_data", nullable = false)
    private Timestamp createData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id", insertable=false, updatable=false, nullable = false)
    private Goods goodId;

    public Sales()
    {
    }

    public Sales(Integer goodID, Integer goodCount, Timestamp createData, Goods goodId)
    {
        this.goodID = goodID;
        this.goodCount = goodCount;
        this.createData = createData;
        this.goodId = goodId;
    }

    @Override
    public String toString()
    {
        return "Sale{" +
                "id=" + id +
                ", goodID=" + goodID +
                ", goodCount=" + goodCount +
                ", createData=" + createData +
                '}';
    }
}
