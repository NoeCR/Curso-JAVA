package com.springboot.datajpa.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.datajpa.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
}


