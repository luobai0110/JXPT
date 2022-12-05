package edu.cuit.jxpt2.servise;

import edu.cuit.jxpt2.entity.Task;
import edu.cuit.jxpt2.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class GetTaskFile {
    private final TaskMapper taskMapper;

    private final Task task;

    public GetTaskFile(TaskMapper taskMapper, Task task) {
        this.taskMapper = taskMapper;
        this.task = task;
    }

    public void workToDB(MultipartFile multipartFile) throws IOException {
        task.setWork(multipartFile.getBytes());
        task.setName(multipartFile.getName());
        task.setTags("test");
        task.setTeacher_id(1);
        taskMapper.addWork(task);
    }
}
