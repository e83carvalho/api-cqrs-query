package br.com.egc.query.service;

import br.com.egc.query.model.Reclamacao;
import br.com.egc.query.repository.PedidoRepository;
import br.com.egc.query.repository.ReclamacaoRepository;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReclamacaoService {

    private final ReclamacaoRepository reclamacaoRepository;

    private final PedidoRepository pedidoRepository;

    private final AmazonS3 s3Client;
    @Value("${aws.s3.bucketname}")
    private String bucketName;


    public Reclamacao buscarReclamacao(String codigoReclamacao) {

        var reclamacao = reclamacaoRepository.findByCodigoReclamacao(codigoReclamacao);

        if (reclamacao == null) {
            throw new RuntimeException("Reclamação não localizada");
        }

        return reclamacao;
    }

    public List<Reclamacao> buscarReclamacoes(String status) {

        var reclamacaoList = reclamacaoRepository.findByStatus(status);

         return reclamacaoList;
    }

       public String buscarImagens(String codigoReclamacao, String nomeArquivo) throws RuntimeException {


        var reclamacao = buscarReclamacao(codigoReclamacao);

        if (reclamacao.getImagens().contains(nomeArquivo)) {

            var url = s3Client.getUrl(bucketName, "reclamacao/" + nomeArquivo);

            return url.toString();

        } else {
            throw new RuntimeException("Arquivo não localizado na reclamação");
        }


    }

}
