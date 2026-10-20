package br.com.testevr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarCartaoRequest {

    private String numeroCartao;
    private String senha;
}