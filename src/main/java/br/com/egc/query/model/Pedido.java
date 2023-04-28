package br.com.egc.query.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "pedido")
public class Pedido {


    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String codigoPedido;
    @DynamoDBAttribute
    private String codigoCliente;
    @DynamoDBAttribute
    private String status;
    @DynamoDBAttribute
    private List<String> codigoReclamacoes;


}