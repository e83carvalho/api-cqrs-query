package br.com.egc.query.converter;


import br.com.egc.query.dto.ReclamacaoRequest;
import br.com.egc.query.dto.ReclamacaoResponse;
import br.com.egc.query.model.Reclamacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReclamacaoConverter {

    private final ModelMapper modelMapper;

    public ReclamacaoResponse toReclamacaoResponse(Reclamacao reclamacao) {
        return modelMapper.map(reclamacao, ReclamacaoResponse.class);
    }

    public Reclamacao toReclamacao(ReclamacaoRequest reclamacaoRequest) {
        return modelMapper.map(reclamacaoRequest, Reclamacao.class);
    }

    public List<ReclamacaoResponse> toReclamacaoResponseList(List<Reclamacao> reclamacaoList) {
        return reclamacaoList.stream().map(this::toReclamacaoResponse).collect(Collectors.toList());
    }
}