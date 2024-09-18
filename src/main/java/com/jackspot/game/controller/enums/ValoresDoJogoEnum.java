package com.jackspot.game.controller.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ValoresDoJogoEnum {
    BANANA(10, "Banana   "),
    MORANGO(20, "Morango  "),
    ESTRELA(40, "Estrela  "),
    CARRINHO(45, "Carrinho "),
    RATO(50, "Rato     ");


    private final int pontos;
    private final String nome;

    ValoresDoJogoEnum(int pontos, String nome) {
        this.pontos = pontos;
        this.nome = nome;
    }

    @JsonValue
    public int getPontos() {
        return pontos;
    }

    @JsonValue
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "\n" + nome + ": pontuação->  "+pontos;
    }
}
