package com.jevgenij.dbconf.controller;

import com.jevgenij.dbconf.domain.Conf;
import com.jevgenij.dbconf.repo.ConfRepository;
import com.jevgenij.dbconf.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    private ConfRepository confRepository;

    @Autowired
    private DbService dbService;

    @GetMapping
    public String hello() throws Exception {
        Iterable<Conf> all = confRepository.findAll();
        all.forEach(conf -> System.out.println(conf.toString()));
        dbService.createCamelRoute(all);
        return "camel routes initialised";
    }


}
