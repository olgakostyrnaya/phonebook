package com.testapp.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "^\\b[0-9]{4,10}[Xx]{0,6}$")
    @Length(min = 10, max = 10)
    private String phoneCode;

    /**
     * Название направления
     */
    private String name;
}
