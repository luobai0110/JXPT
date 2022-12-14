package edu.cuit.jxpt2.servise.dao;

import edu.cuit.jxpt2.entity.TClass;
import edu.cuit.jxpt2.mapper.TClassMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TClassDAO {
    private final TClassMapper tClassMapper;

    public TClassDAO(TClassMapper tClassMapper) {
        this.tClassMapper = tClassMapper;
    }

    public TClass getTClassById(Integer id) {
        return tClassMapper.getTClassById(id);
    }

//    public List<TClass> getTClassByTeacherId(Integer id) {
//
//    }
}
