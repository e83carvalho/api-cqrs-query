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
public class ReclamacaoSearchRequest {

    @NotBlank(message = "C�digo Reclama��o obrigat�rio")
    private String codigoReclamacao;




}
