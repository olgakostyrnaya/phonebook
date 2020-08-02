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
    @Column(name = "ID")
    private Long id;

    /**
     * Телефонный код
     */
    @NotBlank
    @Column(name = "CODE")
    private String code;

    /**
     * Название направления
     */
    @NotBlank
    @Column(name = "NAME")
    private String name;

    public void addReplaceSymbolIfNeeded() {
        StringBuilder sb = new StringBuilder(this.getCode());
        while (sb.length() < PhoneCode.CODE_LENGTH) {
            sb.append(PhoneCode.CODE_NUMBER_REPLACE_SYMBOL);
        }
        this.setCode(sb.toString());
    }

    public static String addReplaceSymbolIfNeeded(String code) {
        StringBuilder sb = new StringBuilder(code);
        while (sb.length() < PhoneCode.CODE_LENGTH) {
            sb.append(PhoneCode.CODE_NUMBER_REPLACE_SYMBOL);
        }
        return sb.toString();
    }
}
