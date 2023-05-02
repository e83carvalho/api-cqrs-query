package br.com.egc.query.controller;

import br.com.egc.query.converter.ReclamacaoConverter;
import br.com.egc.query.dto.ReclamacaoResponse;
import br.com.egc.query.service.ReclamacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reclamacoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReclamacaoController {

    private final ReclamacaoService reclamacaoService;

    private final ReclamacaoConverter reclamacaoConverter;


    @GetMapping("/{codigoReclamacao}")
    public ResponseEntity<ReclamacaoResponse> buscarReclamacao(@PathVariable String codigoReclamacao) {
        return ResponseEntity.ok(
                reclamacaoConverter.toReclamacaoResponse(reclamacaoService.buscarReclamacao(
                        codigoReclamacao)));
    }

    @GetMapping("/status/{statusReclamacao}")
    public ResponseEntity<List<ReclamacaoResponse>> buscarReclamacoes(@PathVariable String statusReclamacao) {
        return ResponseEntity.ok(
                reclamacaoConverter.toReclamacaoResponseList(reclamacaoService.buscarReclamacoes(statusReclamacao)));
    }


    @GetMapping("/{codigoReclamacao}/imagens/{nomeArquivo}")
    public ResponseEntity<?> buscarImagens(@PathVariable String codigoReclamacao, @PathVariable String nomeArquivo) throws IOException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, reclamacaoService.buscarImagens(codigoReclamacao, nomeArquivo))
                .build();
    }

}
