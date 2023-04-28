package br.com.egc.query.repository;

import br.com.egc.query.model.Pedido;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PedidoRepository {

    private final DynamoDBMapper mapper;

    public Pedido findByCodigoPedido(String codigoPedido) {
        return mapper.load(Pedido.class, codigoPedido);

    }


}
