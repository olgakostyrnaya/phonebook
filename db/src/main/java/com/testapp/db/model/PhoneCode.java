package com.testapp.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PhoneCode {

    /**
     * Уникальный идентификатор
     */
    @Id
    private Long id;

    /**
     * Телефонный код
     */
    private String phoneCode;

    /**
     * Название направления
     */
    private String name;
}
