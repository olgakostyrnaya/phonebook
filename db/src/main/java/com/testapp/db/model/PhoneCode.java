package com.testapp.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Справочник телефонных кодов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"code"}), @UniqueConstraint(columnNames = "name")})
public class PhoneCode {

    public static final Integer CODE_LENGTH = 10;
    public static final String CODE_NUMBER_REPLACE_SYMBOL = "x";

    public PhoneCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Телефонный код
     */
    @NotBlank
    private String code;

    /**
     * Название направления
     */
    @NotBlank
    private String name;
}
