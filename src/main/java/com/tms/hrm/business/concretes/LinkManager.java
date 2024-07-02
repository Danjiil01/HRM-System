package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.LinkService;
import com.tms.hrm.dataaccess.abstracts.LinkDao;
import com.tms.hrm.entities.concretes.Link;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        super();
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<Link>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Link>>(
                this.linkDao.findAllByCv_Id(jobSeekerId));
    }

    @Override
    public Result add(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link added... ");
    }

    @Override
    public Result update(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link updated... ");
    }

    @Override
    public Result delete(Link link) {
        this.linkDao.delete(link);
        return new SuccessResult("Link deleted... ");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(
                this.linkDao.findAll()
        );
    }
}
