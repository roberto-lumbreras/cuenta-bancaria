package org.factoriaf5;

public class CuentaCorriente extends Cuenta{
    protected Double sobregiro= 0.0;
    public CuentaCorriente(Double saldo, Double porcentajeDeTasaAnual) {
        super(saldo, porcentajeDeTasaAnual);
    }

    @Override
    public String retirar(Double cantidad) {
        if(esValidaCantidad(cantidad)){
            this.saldo-=cantidad;
            numeroDeRetiros++;
            if(saldo<0){
                sobregiro+=Math.abs(saldo);
                saldo = 0.0;
            }
            return operacionValida;
        }else{
            return operacionNoValida;
        }
        
    }

    @Override
    public String consignar(Double cantidad) {
        if(esValidaCantidad(cantidad)){
            if(sobregiro>=cantidad){
                sobregiro-=cantidad;
                cantidad = 0.0;
            }else if(sobregiro<cantidad){
                cantidad-=sobregiro;
                sobregiro = 0.0;
            }
            return super.consignar(cantidad);
        }else{
            return operacionNoValida;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaAhorro{");
        sb.append("saldo=").append(saldo);
        sb.append(", comisionMensual=").append(comisionMensual);
        sb.append(", numeroDeTransacciones=").append(numeroDeConsignaciones+numeroDeRetiros);
        sb.append(", sobregiro=").append(sobregiro);
        sb.append('}');
        return sb.toString();
    }
    
}
