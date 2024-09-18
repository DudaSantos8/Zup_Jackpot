package com.jackspot.game.service;

import com.jackspot.game.controller.enums.ValoresDoJogoEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JackspotService {


    public String runExecute(int alavanca){
        String valorAleatorioNome = "";
        int validacao = 0;
        int pontucaoBonus = 0;
        int controladorWhile = 0;
        int pontuacaoFinal = 0;
        List<String> valoresSoteados = new ArrayList<>();


        while (controladorWhile < 8) {
            ValoresDoJogoEnum valorAleatorio = gerarValorAleatorio();
            pontuacaoFinal += valorAleatorio.getPontos();

            if(controladorWhile == 0 ||valorAleatorio.getNome().equals(valorAleatorioNome)){
                valorAleatorioNome = valorAleatorio.getNome();
                pontucaoBonus += 1;
            }

            if(controladorWhile == 0){
                if (alavanca == 1){
                    controladorWhile = 5;
                    validacao = 3;
                } else if (alavanca == 2) {
                    controladorWhile = 3;
                    validacao = 5;
                } else if (alavanca == 3) {
                    controladorWhile = 1;
                    validacao = 8;
                }else throw new RuntimeException("Valor inválido");
            }

            if(pontucaoBonus == 8 && validacao == 8){
                pontuacaoFinal *= 100;
            } else if (pontucaoBonus == 5 && validacao == 5) {
                pontuacaoFinal *= 100;
            } else if (pontucaoBonus == 3 && validacao == 3) {
                pontuacaoFinal *= 100;
            }
            valoresSoteados.add(valorAleatorio.toString());
            controladorWhile++;
        }

        String retorno = "-------------------------------- \nValores sorteados: \n"+ valoresSoteados + "\n"
                + "\nPontuação final: " + pontuacaoFinal + "\n--------------------------------";

        return retorno;
    }

    private static ValoresDoJogoEnum gerarValorAleatorio() {
        int condicao = 0;
        int indexAleatorio =(int) (Math.random()*3);

        ValoresDoJogoEnum valorAleatorio = ValoresDoJogoEnum.CARRINHO;
        for(ValoresDoJogoEnum valor : ValoresDoJogoEnum.values()){
            condicao++;
            if(condicao == indexAleatorio){
                valorAleatorio = valor;
            }
        }
        return valorAleatorio;
    }

}
