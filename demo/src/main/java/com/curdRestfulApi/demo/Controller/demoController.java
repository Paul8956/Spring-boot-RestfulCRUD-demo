package com.curdRestfulApi.demo.Controller;

import com.curdRestfulApi.demo.Service.DemoService;
import com.curdRestfulApi.demo.domain.Demo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class demoController {
    @Resource
    private DemoService demoService;

    //GetALL
    @GetMapping("/demo/getdata/getall")
    public List<Demo> getall(){
        return demoService.getAll();
    }

    //GetOneByID
    @GetMapping("/demo/getonebyid/{id}")
    public Optional<Demo> getOne(@PathVariable Integer id){
        return demoService.findOne(id);
    }

    //GetOneByname
    @GetMapping("/demo/getonebyname/{name}")
    public Optional<Demo> getOne(@PathVariable String name){
        return demoService.findOneByname(name);
    }

    //Create
    @PostMapping("/demo/insert")
    public Demo post(Demo demo){
        return demoService.save(demo);
    }

    //Update
    @PutMapping("/demo/{id}")
    public Demo update(@PathVariable Integer id, Demo demo){
        Optional<Demo> demo1 = demoService.findOne(id);
        if(demo1.isPresent()){
            if(demo.getId() == null){ demo.setId(demo1.get().getId());}
            if(demo.getName() == null){ demo.setName(demo1.get().getName());}
            if(demo.getPhone() == null){ demo.setPhone(demo1.get().getPhone());}
            if(demo.getAddress() == null){ demo.setAddress(demo1.get().getAddress());}
        }
        return demoService.save(demo);
    }

    //Delete
    @DeleteMapping("/demo/{id}")
    public void  deleteOne(@PathVariable Integer id){
        demoService.delete(id);
    }




}
