package com.example.bridee.configuracoes.domain;

public enum ImagemCasalEnum {
    PERFIL("Perfil"), FAVORITO("Favorito");

    private final String value;

    ImagemCasalEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
