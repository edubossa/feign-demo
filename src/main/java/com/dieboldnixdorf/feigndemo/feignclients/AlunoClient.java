package com.dieboldnixdorf.feigndemo.feignclients;

import com.dieboldnixdorf.feigndemo.model.Aluno;
import feign.RequestLine;

import java.util.List;

public interface AlunoClient {

    //http://www.mocky.io/v2/5b5504033200005300827cec
    @RequestLine("GET /5b5504033200005300827cec")
    List<Aluno> getAlunos();

}
