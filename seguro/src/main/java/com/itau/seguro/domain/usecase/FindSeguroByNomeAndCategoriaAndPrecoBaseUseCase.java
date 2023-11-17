package com.itau.seguro.domain.usecase;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;

public interface FindSeguroByNomeAndCategoriaAndPrecoBaseUseCase {
    SeguroModel execute(String nome, CategoriaEnum categoria, Double precoBase);
}
