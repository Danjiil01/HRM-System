package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.SkillService;
import com.tms.hrm.dataaccess.abstracts.SkillDao;
import com.tms.hrm.entities.concretes.Skill;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        super();
        this.skillDao = skillDao;
    }

    @Override
    public DataResult<List<Skill>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill added... ");
    }

    @Override
    public Result update(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill updated... ");
    }

    @Override
    public Result delete(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Skill deleted... ");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(
                this.skillDao.findAll()
        );
    }
}
