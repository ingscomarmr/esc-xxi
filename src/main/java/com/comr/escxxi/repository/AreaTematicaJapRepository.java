package com.comr.escxxi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comr.escxxi.entity.AreaTematica;

@Repository("areaTematicaJapRepository")
public interface AreaTematicaJapRepository extends JpaRepository<AreaTematica, Serializable>{

	public abstract AreaTematica findByAreaTematicaId(Integer areaTematicaId);
	
	public abstract List<AreaTematica> findByNombreLikeOrderByNombre(String nombre);
	
	public abstract List<AreaTematica> findByNombre(String nombre);
}
