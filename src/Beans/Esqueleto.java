/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author plocabral
 */
public class Esqueleto {

    private int num_domcumento;
    private String cedente_documento;
    private String sacado_documento;
    private float valor_documento;
    private float valor_baixa;

    public Esqueleto() {
    }

    public Esqueleto(int num_domcumento, String cedente_documento, String sacado_documento, float valor_documento, float valor_baixa) {
        this.num_domcumento = num_domcumento;
        this.cedente_documento = cedente_documento;
        this.sacado_documento = sacado_documento;
        this.valor_documento = valor_documento;
        this.valor_baixa = valor_baixa;
    }

    public int getNum_domcumento() {
        return num_domcumento;
    }

    public void setNum_domcumento(int num_domcumento) {
        this.num_domcumento = num_domcumento;
    }

    public String getCedente_documento() {
        return cedente_documento;
    }

    public void setCedente_documento(String cedente_documento) {
        this.cedente_documento = cedente_documento;
    }

    public String getSacado_documento() {
        return sacado_documento;
    }

    public void setSacado_documento(String sacado_documento) {
        this.sacado_documento = sacado_documento;
    }

    public float getValor_documento() {
        return valor_documento;
    }

    public void setValor_documento(float valor_documento) {
        this.valor_documento = valor_documento;
    }

    public float getValor_baixa() {
        return valor_baixa;
    }

    public void setValor_baixa(float valor_baixa) {
        this.valor_baixa = valor_baixa;
    }

    @Override
    public String toString() {
        return "Esqueleto{" + "num_domcumento=" + num_domcumento + ", cedente_documento=" + cedente_documento + ", sacado_documento=" + sacado_documento + ", valor_documento=" + valor_documento + ", valor_baixa=" + valor_baixa + '}';
    }

}
