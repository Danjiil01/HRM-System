package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Cv;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();

    DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId);

    DataResult<String> uploadImage(int id, MultipartFile file);

    Result add(Cv cv);

    Result update(Cv cv);

    Result delete(Cv cv);
}
