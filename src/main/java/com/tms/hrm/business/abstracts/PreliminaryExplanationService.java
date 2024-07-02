package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.PreliminaryExplanation;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface PreliminaryExplanationService {

    DataResult<List<PreliminaryExplanation>> getAllByCvId(int cvId);

    DataResult<List<PreliminaryExplanation>> getAll();

    Result add(PreliminaryExplanation preliminaryExplanation);

    Result update(PreliminaryExplanation preliminaryExplanation);

    Result delete(PreliminaryExplanation preliminaryExplanation);
}
