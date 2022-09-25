package ru.practicum.later.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="entityd")
@Getter
@Setter
@AllArgsConstructor
public class GenericEntity {


    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "value")
    String value;

    public GenericEntity() {

    }
}
