package com.techvacinabackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.techvacinabackend.model.VacinacaoMaisRecente;

@Repository
public interface VacinacaoMaisRecenteRepository extends JpaRepository<VacinacaoMaisRecente, Long> {
    VacinacaoMaisRecente findByCliente_IdAndDoenca_Nome(Long clienteId, String doencaNome);
    List<VacinacaoMaisRecente> findAllByCliente_Id(long id);
}