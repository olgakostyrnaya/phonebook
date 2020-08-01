package com.testapp.db.service;

import com.testapp.db.dao.PhoneCodeDao;
import com.testapp.db.model.PhoneCode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    private PhoneCodeDao phoneСodeRepository;

    private PhoneCodeServiceImpl(PhoneCodeDao phoneСodeRepository) {
        this.phoneСodeRepository = phoneСodeRepository;
    }

    @PostConstruct
    public void initData() {
        phoneСodeRepository.saveAll(Stream.of(new PhoneCode(101L, "+57857xxxx", "направление 1"),
                new PhoneCode(102L, "48845xxxx", "направление 2")).collect(Collectors.toList()));
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
