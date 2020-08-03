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

    @Override
    @Transactional(readOnly = true)
    public List<PhoneCode> findByCodeContains(String mask) {
        return phoneCodeRepository.findByCodeContains(mask);
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
