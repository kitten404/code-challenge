package com.itau.seguro.domain.service;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.usecase.CalculateFeeUseCase;
import com.itau.seguro.domain.usecase.FindSeguroByNomeAndCategoriaAndPrecoBaseUseCase;
import com.itau.seguro.domain.usecase.WriteSeguroUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.itau.seguro.domain.service.strategy.mapping.FeeCalculatorMapping.feeCalculator;

@Service
@AllArgsConstructor
@Slf4j
public class SaveOrUpdateSeguroService {
    private FindSeguroByNomeAndCategoriaAndPrecoBaseUseCase findCatetoryUseCase;
    private WriteSeguroUseCase writeSeguroUseCase;
    private CalculateFeeUseCase calculateFeeUseCase;

    SeguroModel execute(SeguroModel model) {
        try {
            var seguro = findCatetoryUseCase.execute(model.getNome(), model.getCategoria(), model.getPrecoBase());
            if (seguro == null) {
                seguro = model;
            }
            var fee = calculateFeeUseCase.execute(seguro.getCategoria(), seguro.getPrecoBase());

            seguro.setPrecoTarifado(
                    seguro.getPrecoBase() + fee
            );
            return writeSeguroUseCase.execute(seguro);
        } catch (Exception e) {
            log.error("Nao foi possível salvar seguro: ", e.getMessage());
            throw e;
        }
    }


}
