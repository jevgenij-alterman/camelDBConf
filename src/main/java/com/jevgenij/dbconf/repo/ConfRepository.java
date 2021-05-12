package com.jevgenij.dbconf.repo;

import com.jevgenij.dbconf.domain.Conf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfRepository extends CrudRepository<Conf, String> {
}