package com.testapp.db.service;

import com.testapp.db.dao.PhoneCodeDao;
import com.testapp.db.model.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    @Autowired
    private PhoneCodeDao phoneСodeRepository;

    @PostConstruct
    public void initData() {
        phoneСodeRepository.saveAll(Stream.of(new PhoneCode(101L, "57857xxxxx", "направление 1"),
                new PhoneCode(102L, "4884xxxxx", "направление 2")).collect(Collectors.toList()));
    }


    @Override
    public List<PhoneCode> getPhoneCodes() {
        return phoneСodeRepository.findAll();
    }

    @Override
    public void add(PhoneCode phoneCode) {
        phoneСodeRepository.save(phoneCode);
    }

    @Override
    public void delete(String phoneCode) {

    }


}
