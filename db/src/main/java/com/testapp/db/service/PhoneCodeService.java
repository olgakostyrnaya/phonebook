package com.testapp.db.service;

import com.testapp.db.model.PhoneCode;

import java.util.List;

public interface PhoneCodeService {

    List<PhoneCode> getPhoneCodes();

    void add(PhoneCode phoneCode);

    void delete(String phoneCode);




    // TODO: 01.08.2020:
    //  - Создание записи в справочнике телефонных кодов
    //  Удаление записи из справочника
    //  Контроль уникальности по тел.коду, по наименованию
    //  Поиск всех тел.кодов, удовлетворяющих введенной маске.

}
