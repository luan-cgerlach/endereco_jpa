package com.example.endereco_jpa.repository;

import com.example.endereco_jpa.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT e FROM Endereco e WHERE e.CIDADE = :cidade")
    List<Endereco> findByCidade(@Param("cidade") String cidade);

    List<Endereco> findAllByCEP(String cep);

    List<Endereco> findAllByRUA(String rua);
}
