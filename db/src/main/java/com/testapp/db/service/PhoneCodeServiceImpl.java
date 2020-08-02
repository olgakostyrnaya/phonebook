package com.testapp.db.service;

import com.testapp.db.dao.PhoneCodeDao;
import com.testapp.db.model.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
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
    @Transactional
    public void initData() {
        this.addAll(Stream.of(new PhoneCode("446970", "Название направления 1"),
                new PhoneCode("375099661", "Название направления 2"),
                new PhoneCode("21116321", "Название направления 3"),
                new PhoneCode("7612816", "Название направления 4"),
                new PhoneCode("47830", "Название направления 5"),
                new PhoneCode("5799", "Название направления 6"),
                new PhoneCode("2944701", "Название направления 7"),
                new PhoneCode("71192", "Название направления 8"),
                new PhoneCode("47079", "Название направления 9"))
                .collect(Collectors.toList()));
    }

    @Override
    public List<PhoneCode> fullTextSearchByMask(String mask) {
        //todo fullTextSearch
        return null;
    }

    @Override
    @Transactional
    public List<PhoneCode> findByCodeContains(String part) {
        return phoneCodeRepository.findByCodeContains(part);
    }

    @Override
    @Transactional
    public List<PhoneCode> findByNameContains(String part) {
        return phoneCodeRepository.findByNameContains(part);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PhoneCode> findAll() {
        return phoneCodeRepository.findAll();
    }

    @Override
    @Transactional
    public void add(PhoneCode phoneCode) {
        if (phoneCode == null) {
            return;
        }

        phoneCode.addReplaceSymbolIfNeeded();
        phoneCodeRepository.save(phoneCode);
    }

    @Override
    @Transactional
    public void addAll(List<PhoneCode> phoneCodes) {
        if (phoneCodes == null) {
            return;
        }

        for (PhoneCode phoneCode : phoneCodes) {
            this.add(phoneCode);
        }
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return phoneCodeRepository.deleteByCode(PhoneCode.addReplaceSymbolIfNeeded(code));
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        return phoneCodeRepository.deleteByName(name);
    }
}
