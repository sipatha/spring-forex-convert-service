package cib.eureka.service.web;

import cib.eureka.service.model.ConvertRequest;
import cib.eureka.service.model.ConvertResponse;
import cib.eureka.service.srvc.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    private ForexService service;

    @PostMapping(value = "/{amount}/{from}/{to}", produces = {"application/json"})
    public ResponseEntity<ConvertResponse> get(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
        ConvertRequest req = ConvertRequest.builder()
                .amount(amount)
                .from(from)
                .to(to)
                .build();

        return ResponseEntity.ok(service.getConvert(req));
    }

}
