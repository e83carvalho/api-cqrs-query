package br.com.egc.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReclamacaoRequest {

    @NotBlank
    private String codigoCliente;
    @NotBlank
    private String codigoPedido;
    @NotBlank
    private String descricao;

}
