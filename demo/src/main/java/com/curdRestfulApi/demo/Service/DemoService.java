package com.curdRestfulApi.demo.Service;

import com.curdRestfulApi.demo.Dao.Demodao;
import com.curdRestfulApi.demo.domain.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DemoService {

    @Resource
    private Demodao demodao;

    public List<Demo> getAll(){
        return demodao.findAll();
    }

    public Optional<Demo> findOne(Integer id){
        return demodao.findById(id);
    }

    public Optional<Demo> findOneByname(String name){
        return Optional.ofNullable(demodao.findByname(name));
    }

    public Demo save(Demo demo){
        return demodao.save(demo);
    }

    public void delete(Integer id){
        demodao.deleteById(id);
    }


}
