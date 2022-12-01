package edu.cuit.jxpt2.servise;

import edu.cuit.jxpt2.entity.Work;
import edu.cuit.jxpt2.mapper.WorkMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;


@Service
@Slf4j
public class GetWork {
    private final WorkMapper workMapper;

    private final Work work;

    public GetWork(WorkMapper workMapper, Work work) {
        this.workMapper = workMapper;
        this.work = work;
    }

    public void workToDB(MultipartFile multipartFile) throws IOException {
        work.setWork(multipartFile.getBytes());
        work.setName(multipartFile.getName());
        work.setTags("test");
        work.setTeacher_id(1);
        log.info(Arrays.toString(work.getWork()));
        workMapper.addWork(work);
    }
}
