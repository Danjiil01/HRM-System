package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Link;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface LinkService {

    DataResult<List<Link>> getAllByCvId(int cvId);

    DataResult<List<Link>> getAll();

    Result add(Link link);

    Result update(Link link);

    Result delete(Link link);
}
