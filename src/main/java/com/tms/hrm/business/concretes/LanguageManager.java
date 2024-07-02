package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.LanguageService;
import com.tms.hrm.dataaccess.abstracts.LanguageDao;
import com.tms.hrm.entities.concretes.Language;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        super();
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Language>>(
                this.languageDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(
                this.languageDao.findAll()
        );
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language added... ");
    }

    @Override
    public Result update(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language updated... ");
    }

    @Override
    public Result delete(Language language) {
        this.languageDao.delete(language);
        return new SuccessResult("Language deleted... ");
    }
}
