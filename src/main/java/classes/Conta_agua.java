package classes;

public class Conta_agua {
	private String nome_cliente;
	private String cnpj_cliente;
	private String nome_fornecedor;
	private String cnpj_fornecedor;
	private String tipo_fornecedor;
	private int cep;
	private String endereco;
	private int numero;
	private int rgi_conta;
	private int numero_conta;
	private int gr_conta;
	private String mes_referencia_conta;
	private String codigo_cliente;
	private int consumo_conta;
	private float total_pagar_residencial_conta;
	
	public Conta_agua(int rgi_conta) {
		this.setRgi_conta(rgi_conta);
	}

	public Conta_agua() {
		
	}
	
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getCnpj_cliente() {
		return cnpj_cliente;
	}
	public void setCnpj_cliente(String cnpj_cliente) {
		this.cnpj_cliente = cnpj_cliente;
	}
	public String getNome_fornecedor() {
		return nome_fornecedor;
	}
	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}
	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}
	public void setCnpj_fornecedor(String cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}
	public String getTipo_fornecedor() {
		return tipo_fornecedor;
	}
	public void setTipo_fornecedor(String tipo_fornecedor) {
		this.tipo_fornecedor = tipo_fornecedor;
	}
	public int getRgi_conta() {
		return rgi_conta;
	}
	public void setRgi_conta(int rgi_conta) {
		this.rgi_conta = rgi_conta;
	}
	public int getNumero_conta() {
		return numero_conta;
	}
	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}
	public int getGr_conta() {
		return gr_conta;
	}
	public void setGr_conta(int gr_conta) {
		this.gr_conta = gr_conta;
	}
	public String getMes_referencia_conta() {
		return mes_referencia_conta;
	}
	public void setMes_referencia_conta(String mes_referencia_conta) {
		this.mes_referencia_conta = mes_referencia_conta;
	}
	public String getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(String codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	public int getConsumo_conta() {
		return consumo_conta;
	}
	public void setConsumo_conta(int consumo_conta) {
		this.consumo_conta = consumo_conta;
	}
	public float getTotal_pagar_residencial_conta() {
		return total_pagar_residencial_conta;
	}
	public void setTotal_pagar_residencial_conta(float total_pagar_residencial_conta) {
		this.total_pagar_residencial_conta = total_pagar_residencial_conta;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}