package br.com.testevr.exception;

import br.com.testevr.dto.CriarCartaoRequest;
import lombok.Getter;

@Getter
public class CartaoJaExisteException extends RuntimeException {

    private final CriarCartaoRequest request;

    public CartaoJaExisteException(CriarCartaoRequest request) {
        this.request = request;
    }
}