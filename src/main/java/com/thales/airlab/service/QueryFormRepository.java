package com.thales.airlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.thales.airlab.model.QueryForm;

/**
 * This is the repository that holds the queries submit.
 *
 * It provides the facilities to search, save, remove and retrieve all queries
 * submit
 *
 * Usage:
 *
 * To retrieve a record
 * 		@Autowired
 * 		QueryFormRepository queryFormRepository;
 * 		queryFormRepository.findById(id);
 *
 *
 * @author Alex
 *
 * */

public interface QueryFormRepository extends CrudRepository<QueryForm, Integer> {

}


