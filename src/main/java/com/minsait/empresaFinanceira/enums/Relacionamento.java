package com.minsait.empresaFinanceira.enums;

import java.math.BigDecimal;

public enum Relacionamento {

	BRONZE {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, Integer numeroDeEmprestimos) {
			return valorInicial.multiply(taxaBRONZE);
		}
	},
	 
    PRATA {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, Integer numeroDeEmprestimos) {
			if(valorInicial.compareTo(BigDecimal.valueOf(5000)) > 0 ) {
				return valorInicial.multiply(taxaPRATAII);
			}
			else {
				return valorInicial.multiply(taxaPRATA);
			}
		}
	},
 
    OURO {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, Integer numeroDeEmprestimos) {
			if(numeroDeEmprestimos <= 1) {
				return valorInicial.multiply(taxaOURO);
			}
			else {
				return valorInicial.multiply(taxaOUROII);
			}
		}
	};
	
	private static final BigDecimal taxaBRONZE = BigDecimal.valueOf(1.8);
	private static final BigDecimal taxaPRATA = BigDecimal.valueOf(1.6);
	private static final BigDecimal taxaPRATAII = BigDecimal.valueOf(1.5);
	private static final BigDecimal taxaOURO = BigDecimal.valueOf(1.2);
	private static final BigDecimal taxaOUROII = BigDecimal.valueOf(1.3);
 
	Relacionamento(){
	}
	
    public abstract BigDecimal calculaValorFinal(BigDecimal valorInicial, Integer numeroDeEmprestimos);

	
}
