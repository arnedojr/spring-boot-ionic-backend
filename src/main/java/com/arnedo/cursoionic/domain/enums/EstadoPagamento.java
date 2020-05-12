package com.arnedo.cursoionic.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE (1, "PENDENTE"),
	QUITADO (2, "QUITADO"),
	CANCELADO (3, "CANCELADO");
	
	
	private int cod;
	private String descricao;
	
	// construtor de tipo enumerado eh private
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código do enum inválido!! ID: "+ cod);
	}
}
