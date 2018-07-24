package com.dieboldnixdorf.feigndemo;

import com.dieboldnixdorf.feigndemo.feignclients.AlunoClient;
import com.dieboldnixdorf.feigndemo.feignclients.AlunoXMLClient;
import com.dieboldnixdorf.feigndemo.model.Aluno;
import com.dieboldnixdorf.feigndemo.model.Alunos;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        AlunoClient alunoClient = Feign.builder()
            .requestInterceptor(template -> {
                //template.header("Wallace Now", LocalDateTime.now().toString());
            })
            .logger(new Logger.ErrorLogger())
            .logLevel(Logger.Level.FULL)
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .target(AlunoClient.class, "http://www.mocky.io/v2");

        List<Aluno> alunos = alunoClient.getAlunos();
       // alunos.forEach(System.out::println);


        JAXBContextFactory factory =
                new JAXBContextFactory.Builder().withMarshallerJAXBEncoding("UTF-8").build();

        AlunoXMLClient alunoXMLClient = Feign.builder()
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .encoder(new JAXBEncoder(factory))
                .decoder(new JAXBDecoder(factory))
                .target(AlunoXMLClient.class, "http://www.mocky.io/v2");


        Alunos alunosXml = alunoXMLClient.getAlunos();
        System.out.println("Count alunos --> " + alunosXml.getAlunos().size());

    }

}
