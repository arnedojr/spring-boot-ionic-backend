/**
 * 
 */
package com.arnedo.cursoionic.domain.enums;

/**
 * @author arnedo
 *
 */
public enum TipoCliente {
	//COM JPA PODE GRAVAR A STRING OU NUMERO INTEIRO EM ORDEM... MELHOR CRIAR UM CÓDIGO PARA CADA UM
	// GERAR AUTOMATICAMENTE O VALOR É PERIGOSO... SE MUDAR O VALOR COLOCANDO MAIS UM, PODE GERAR PROBLEMA...
	// OS DADOS NO BANCO VAI FICAR QUEBRADO PARA COLOCAR UM NOVO... ENTAO SERAH MUDADO
	
	/*
	PESSOAFISICA,
	PESSOAJURIDICA;
	*/
	
	//FAZER ASSIM...
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	// construtor de tipo enumerado eh private
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código do enum inválido!! ID: "+ cod);
	}
	
}
