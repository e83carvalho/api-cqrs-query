package br.com.egc.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReclamacaoResponse {

    private String codigoReclamacao;

    private String codigoCliente;

    private String codigoPedido;

    private String descricao;

    private String statusReclamacao;

    private List<String> imagens;
}
