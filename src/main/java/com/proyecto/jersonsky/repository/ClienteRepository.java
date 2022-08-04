package com.proyecto.jersonsky.repository;
import com.proyecto.jersonsky.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer> {
}
