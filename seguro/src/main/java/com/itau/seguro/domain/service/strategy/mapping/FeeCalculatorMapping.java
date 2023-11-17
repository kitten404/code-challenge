package com.itau.seguro.domain.service.strategy.mapping;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.service.strategy.FeeCalculatorService;
import com.itau.seguro.domain.service.strategy.impl.*;

import java.util.Map;
import java.util.function.Supplier;

import static com.itau.seguro.domain.model.enums.CategoriaEnum.*;
public class FeeCalculatorMapping {
    public static final Map<CategoriaEnum, Supplier<FeeCalculatorService>> feeCalculator =
            Map.of(VIDA, VidaFeeCalculatorService::new,
                    AUTO, AutoFeeCalculatorService::new,
                    VIAGEM, ViagemFeeCalculatorService::new,
                    RESIDENCIAL, ResidencialFeeCalculatorService::new,
                    PATRIMONIAL, PatrimonialFeeCalculatorService::new
            );
}
