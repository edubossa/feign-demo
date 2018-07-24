package com.dieboldnixdorf.feigndemo.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "alunos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alunos implements Serializable {

    @XmlElement(name = "aluno")
    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
