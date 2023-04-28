package br.com.egc.query.repository;

import br.com.egc.query.model.Reclamacao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReclamacaoRepository {

    private final DynamoDBMapper mapper;

    public Reclamacao findByCodigoReclamacao(String codigoReclamacao) {
        return mapper.load(Reclamacao.class, codigoReclamacao);

    }


}
