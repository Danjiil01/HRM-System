package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.CvService;
import com.tms.hrm.dataaccess.abstracts.CvDao;
import com.tms.hrm.entities.concretes.Cv;
import com.tms.hrm.utils.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private cloudinaryUploadService cloudinaryUploadService;

    @Autowired
    public CvManager(CvDao cvDao, CloudinaryUploadService cloudinaryUploadService) {
        super();
        this.cvDao = cvDao;
        this.cloudinaryUploadService = cloudinaryUploadService;
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(
                this.cvDao.findAll()
        );
    }

    @Override
    public DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Cv>>(
                this.cvDao.findByJobSeeker_id(jobSeekerId)
        );
    }

    @Override
    public DataResult<String> uploadImage(int id, MultipartFile file) {
        if (!file.getContentType().toString().startsWith("image")) {
            return new ErrorDataResult<String>(
                    "Failed to load photo! The file is not an image.", file.getContentType()
            );
        } else if (!this.cvDao.existsById(id)) {
            return new ErrorDataResult<String>(
                    "Failed to load photo! Not found curriculum vitae.", null
            );
        } else {
            String secure_url = this.cloudinaryUploadService.upload(file).get("secure_url").toString();
            Cv cv = this.cvDao.findById(id).get();
            cv.setImageLink(secure_url);
            this.cvDao.save(cv);
            return new SuccessDataResult<String>(
                    "Photo uploadad ! ", secure_url
            );
        }
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv added");
    }

    @Override
    public Result update(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv updated");
    }

    @Override
    public Result delete(Cv cv) {
        this.cvDao.delete(cv);
        return new SuccessResult("Cv deleted");
    }
}
