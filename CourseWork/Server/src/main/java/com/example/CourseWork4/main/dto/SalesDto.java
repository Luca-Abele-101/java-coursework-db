package com.example.CourseWork4.main.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesDto
{
    private Integer goodID;
    private Integer goodCount;
    private Timestamp createData;
    private Integer goodId;
}
