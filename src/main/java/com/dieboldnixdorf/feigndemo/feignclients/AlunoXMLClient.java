package com.dieboldnixdorf.feigndemo.feignclients;

import com.dieboldnixdorf.feigndemo.model.Alunos;
import feign.RequestLine;


public interface AlunoXMLClient {

    //http://www.mocky.io/v2/5b568a57310000b0034d1de3
    @RequestLine("GET /5b568a57310000b0034d1de3")
    Alunos getAlunos();

}
