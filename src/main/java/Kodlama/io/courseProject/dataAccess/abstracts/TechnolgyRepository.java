package Kodlama.io.courseProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.courseProject.entities.concretes.Technology;

public interface TechnolgyRepository extends JpaRepository<Technology, Integer> {

}
