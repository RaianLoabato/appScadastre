/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby,
 C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
package br.raianlobato.mobile.scadastre.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Cliente {

    //atributos do cliente
    private String nomecompleto;
    private String numerodeCelular;
    private String numerodeIdentidade;
    private String cpf;
    private String cep;
    private String endereco;
    private String complemento;
    private String senha;
    private String repitaSenha;
    private int pais;
    private int id;

    //construtor
    public Cliente(JSONObject jo) {
        try {
            this.nomecompleto = "nomepessoa";
            this.numerodeCelular = jo.getString("celularpessoa");
            this.numerodeIdentidade = jo.getString("identidadepessoa");
            this.cpf = jo.getString("cpfpessoa");
            this.cep = jo.getString("ceppessoa");
            this.endereco = jo.getString("endecopessoa");
            this.complemento = jo.getString("complementopessoa");
            this.senha = jo.getString("senhapessoa");
            this.repitaSenha = jo.getString("repitasenhapessoa");
            this.pais = 1;
            this.id = jo.getInt("id");
        }catch (JSONException je) {
            je.printStackTrace();

        }

    }

    public Cliente() {
        this.nomecompleto = "";
        this.numerodeCelular = "+55";
        this.numerodeIdentidade = "000000";
        this.cpf = "00000000000";
        this.cep = "00000000";
        this.endereco = " ";
        this.complemento = "";
        this.senha = "";
        this.repitaSenha = "";
        this.pais = 0;
        this.id = 0;


    }

    //metodo

    //metodo retorna o objeto com dados no farmato JSON
    public JSONObject  toJsonObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("nomepessoa", null);
            json.put("celularpessoa", this.numerodeCelular);
            json.put("identidadepessoa", this.numerodeIdentidade);
            json.put("cpfpessoa", this.cpf);
            json.put("ceppessoa", this.cep);
            json.put("endecopessoa", this.endereco);
            json.put("complementopessoa", this.complemento);
            json.put("senhapessoa", this.senha);
            json.put("repitasenhapessoa", this.repitaSenha);


        }catch (JSONException je) {
            je.printStackTrace();

        }
        return json;
    }

    public int getID() {
        return this.id;
    }

    public String getNumerodeCelula() {
        return this.numerodeCelular;
    }

    public String getNomeCompleto() {
        return this.nomecompleto;

    }

    public String getNumerodeIdentidade() {
        return this.numerodeIdentidade;

    }

    public String getCPF() {
        return this.cpf;

    }

    public String getCEP() {
        return this.cep;

    }

    public String getEndeco() {
        return this.endereco;

    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getSenha() {
        return this.senha;

    }

    public String getRepitaSenha() {
        return this.repitaSenha;
    }

    public int getPais() {
        return this.pais;

    }

    //verificar id
    public void setID(int id) {
        this.id = id;

    }



    //verificando pais
    public boolean setPais(String pais) {
        boolean valido = false;
        if(pais.length() <= 3) {
            this.pais = Integer.parseInt(pais);
            valido = true;
        }
        return valido;
    }

    //verificar Repita senha
    public boolean setRepitaSenha(String repitaSenha) {
        boolean valido = false;
        if(repitaSenha.length() > 6) {
            this.repitaSenha = repitaSenha;
            valido = true;
        }
        return valido;
    }

    //verificar senha
    public boolean setSenha(String senha) {
        boolean valido = false;
        if(senha.length() > 6) {
            this.senha = senha;
            valido = true;
        }
        return valido;
    }


    //verificar complemento
    public boolean setComplemento(String complemento) {
        boolean valido = false;
        if(complemento.length() > 5) {
            this.complemento = complemento;
            valido = true;
        }
        return valido;
    }


    //Verificar endereço
    public boolean setEndereco(String endereco) {
        boolean valido = false;
        if(endereco.length() > 5)
            this.endereco = endereco;
        valido = true;
        if (this.endereco == null) {
            this.endereco = "Informar";
        }
        return valido;
    }


    //Verificar CPF
    public boolean setCPF(String cpf) {
        boolean valido = false;
        if(cpf.length() == 11) {
            this.cpf = cpf;
            valido = true;
        }
        return valido;

    }

    //Verificar CEP
    public boolean setCEP(String cep) {
        boolean valido = false;
        if(cep.length() == 8 ){
            this.cep = cep;
            valido = true;
        }
        return valido;
    }



    //Verificar Numero de de celular
    public boolean setNumerodeCelular(String numerodeCelular) {
        boolean valido = false;
        if(numerodeCelular.length()>= 7 && (numerodeCelular.length()  <= 9) ){
            this.numerodeCelular = numerodeCelular;
            valido = true;
        }
        return valido;

    }

    //verifica Numero de Identidade
    public boolean setNumerodeIdentidade(String numerodeIdentidade) {
        boolean valido = false;
        if(numerodeIdentidade.length()>= 7 && (numerodeIdentidade.length()  <= 9) ){
            this.numerodeIdentidade = numerodeIdentidade;
            valido = true;
        }
        return valido;
    }



    //verificação de nome
    public boolean setNomeCompleto(String nomecompleto) {
        boolean valido = false;
        if(nomecompleto.length() > 5) {
            this.nomecompleto = nomecompleto;
            valido = true;
        }else {
            this.nomecompleto = "Anônimo";
        }
        return valido;
    }

}


