package com.fr.adaming.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Matiere;
@Repository
public interface IMatiereDao  extends JpaRepository<Matiere, Integer>{
	
	@Query(value = "FROM Matiere WHERE matieres =:matieres")
	public List<Matiere> findMatiereByIdModule (int matieres);
	
}
