package com.techvacinabackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.LembreteVacinacao;

@Repository
public interface LembreteVacinacaoRepository extends JpaRepository<LembreteVacinacao, Long> {
    LembreteVacinacao findByCliente_IdAndDoenca_Id(Long clienteId, long doencaId);
    List<LembreteVacinacao> findAllByCliente_Id(Long clienteId);
}
