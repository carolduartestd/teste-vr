package br.com.testevr.service;

import br.com.testevr.domain.Cartao;
import br.com.testevr.dto.CriarCartaoRequest;
import br.com.testevr.exception.CartaoJaExisteException;
import br.com.testevr.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private static final BigDecimal SALDO_INICIAL = new BigDecimal("500.00");

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao criar(CriarCartaoRequest request) {
        if (cartaoRepository.existsById(request.getNumeroCartao())) {
            throw new CartaoJaExisteException(request);
        }

        Cartao cartao = new Cartao(
                request.getNumeroCartao(),
                request.getSenha(),
                SALDO_INICIAL
        );

        return cartaoRepository.save(cartao);
    }
}