package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Film {
    private int id;
    private String name;
    private int year;
    protected String slogan;
    protected String genres;
}
