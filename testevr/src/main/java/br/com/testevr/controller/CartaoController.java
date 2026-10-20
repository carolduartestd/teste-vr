package br.com.testevr.controller;

import br.com.testevr.domain.Cartao;
import br.com.testevr.dto.CriarCartaoRequest;
import br.com.testevr.exception.CartaoJaExisteException;
import br.com.testevr.service.CartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartaoController {

    private final CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CriarCartaoRequest> criar(@RequestBody CriarCartaoRequest request) {
        Cartao cartao = cartaoService.criar(request);

        CriarCartaoRequest response = new CriarCartaoRequest();
        response.setNumeroCartao(cartao.getNumeroCartao());
        response.setSenha(cartao.getSenha());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ExceptionHandler(CartaoJaExisteException.class)
    public ResponseEntity<CriarCartaoRequest> handleCartaoJaExiste(CartaoJaExisteException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getRequest());
    }
}