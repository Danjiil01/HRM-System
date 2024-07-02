package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Skill;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface SkillService {

    DataResult<List<Skill>> getAllByCvId(int cvId);

    DataResult<List<Skill>> getAll();

    Result add(Skill skill);

    Result update(Skill skill);

    Result delete(Skill skill);
}
