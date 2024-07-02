package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Language;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface LanguageService {

    DataResult<List<Language>> getAllByCvId(int cvId);

    DataResult<List<Language>> getAll();


    Result add(Language language);

    Result update(Language language);

    Result delete(Language language);
}
