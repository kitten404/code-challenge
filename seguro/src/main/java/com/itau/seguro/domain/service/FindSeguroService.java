package com.itau.seguro.domain.service;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import com.itau.seguro.domain.usecase.FindSeguroByNomeAndCategoriaAndPrecoBaseUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FindSeguroService implements FindSeguroByNomeAndCategoriaAndPrecoBaseUseCase {
    private SeguroPersistencePort persistencePort;
    @Override
    public SeguroModel execute(String nome, CategoriaEnum categoria, Double precoBase) {
        try {
            return persistencePort.findByNameAndCategoriaAndPrecoBase(
                    nome, categoria, precoBase
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
