package org.factoriaf5;

public class CuentaAhorro extends Cuenta{
    protected boolean activa;

    public CuentaAhorro(Double saldo, Double porcentajeDeTasaAnual) {
        super(saldo, porcentajeDeTasaAnual);
        this.activa = this.saldo>=10_000.0;
    }

    @Override
    public String retirar(Double cantidad) {
        return activa?
        super.retirar(cantidad):
        operacionNoValida;
    }

    @Override
    public String consignar(Double cantidad) {
        return activa?
        super.consignar(cantidad):
        operacionNoValida;
    }

    @Override
    protected void calcularComisionMensual() {
        comisionMensual = numeroDeRetiros > 4?
        1000*(numeroDeRetiros-4):
        comisionMensual;
        super.calcularComisionMensual();
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
        this.activa = this.saldo>=10_000.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaAhorro{");
        sb.append("saldo=").append(saldo);
        sb.append(", comisionMensual=").append(comisionMensual);
        sb.append(", numeroDeTransacciones=").append(numeroDeConsignaciones+numeroDeRetiros);
        sb.append('}');
        return sb.toString();
    }

}
