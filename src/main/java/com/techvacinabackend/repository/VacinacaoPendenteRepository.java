package com.techvacinabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvacinabackend.model.VacinacaoPendente;

@Repository
public interface VacinacaoPendenteRepository extends JpaRepository<VacinacaoPendente, Long> {
    VacinacaoPendente findByCliente_IdAndDoenca_NomeAndVacina_Nome(Long clienteId, String doencaNome, String vacinaNome);
}
