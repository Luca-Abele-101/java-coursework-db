package com.example.CourseWork4.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "goods")
public class Goods
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "priority", nullable = true)
    private Float priority;

    @JsonIgnore
    @OneToMany(mappedBy = "goodId", cascade = CascadeType.ALL)
    private Collection<Sales> salesIds;

    @JsonIgnore
    @OneToMany(mappedBy = "goodFromWHFirstId", cascade = CascadeType.ALL)
    private Collection<Warehouse1> warehouseFirstIds;

    @JsonIgnore
    @OneToMany(mappedBy = "goodFromWHSecondId", cascade = CascadeType.ALL)
    private Collection<Warehouse2> warehouseSecondIds;

    public Goods()
    {
    }

    public Goods(String name, Float priority)
    {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString()
    {
        return "good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
