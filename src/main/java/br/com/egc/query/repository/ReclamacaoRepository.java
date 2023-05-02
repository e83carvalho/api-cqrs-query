package br.com.egc.query.repository;

import br.com.egc.query.model.Reclamacao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ReclamacaoRepository {

    private final DynamoDBMapper mapper;

    public Reclamacao findByCodigoReclamacao(String codigoReclamacao) {
        return mapper.load(Reclamacao.class, codigoReclamacao);

    }

    public List<Reclamacao> findByStatus(String statusReclamacao) {
        // Cria um objeto do tipo DynamoDBMapper para realizar as operações de consulta.

        // Cria um objeto do tipo AttributeValue com o valor do statusReclamacao.
        AttributeValue attributeValue = new AttributeValue(statusReclamacao);

        // Cria um objeto do tipo Reclamacao com o statusReclamacao.
        Reclamacao reclamacao = new Reclamacao();
        reclamacao.setStatusReclamacao(statusReclamacao);

        // Utiliza o método query da API do DynamoDB para buscar as reclamações com o statusReclamacao informado.
        DynamoDBQueryExpression<Reclamacao> queryExpression = new DynamoDBQueryExpression<Reclamacao>()
                .withIndexName("statusReclamacaoIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("statusReclamacao = :val")
                .withExpressionAttributeValues(ImmutableMap.of(":val", attributeValue))
                .withHashKeyValues(reclamacao);
        List<Reclamacao> reclamacoes = mapper.query(Reclamacao.class, queryExpression);

        return reclamacoes;

    }


}
