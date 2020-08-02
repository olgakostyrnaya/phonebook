package com.testapp.db.service;

import com.testapp.db.dao.PhoneCodeDao;
import com.testapp.db.model.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    private PhoneCodeDao phoneCodeRepository;

    @Autowired
    public PhoneCodeServiceImpl(PhoneCodeDao phoneCodeDao){
        this.phoneCodeRepository = phoneCodeDao;
    }

    /**
     * Заполнение БД
     */
    @PostConstruct
    public void initData() {
        this.addAll(Stream.of(new PhoneCode(100L, "446970", "Название направления 1"),
                new PhoneCode(101L, "375099661", "Название направления 2"),
                new PhoneCode(102L, "21116321", "Название направления 3"),
                new PhoneCode(103L, "7612816", "Название направления 4"),
                new PhoneCode(104L, "47830", "Название направления 5"),
                new PhoneCode(105L, "5799", "Название направления 6"),
                new PhoneCode(106L, "2944701", "Название направления 7"),
                new PhoneCode(107L, "71192", "Название направления 8"),
                new PhoneCode(108L, "47079", "Название направления 9"))
                .collect(Collectors.toList()));
    }

    @Override
    public List<PhoneCode> findByRegExp(Pattern pattern) {
        return null;
    }

    @Override
    public List<PhoneCode> findAll() {
        return phoneCodeRepository.findAll();
    }

    @Override
    public void add(PhoneCode phoneCode) {
        if (phoneCode == null) {
            return;
        }

        StringBuilder code = new StringBuilder(phoneCode.getCode());
        while (code.length() < PhoneCode.CODE_LENGTH) {
            code.append(PhoneCode.CODE_NUMBER_REPLACE_SYMBOL);
        }
        phoneCode.setCode(code.toString());
        phoneCodeRepository.save(phoneCode);
    }

    @Override
    public void addAll(List<PhoneCode> phoneCodes) {
        if (phoneCodes == null) {
            return;
        }

        for (PhoneCode phoneCode : phoneCodes) {
            this.add(phoneCode);
        }
    }

    @Override
    public void delete(String code) {

    }
}
