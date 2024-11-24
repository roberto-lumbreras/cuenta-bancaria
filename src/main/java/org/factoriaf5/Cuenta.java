package org.factoriaf5;

public abstract class Cuenta {
    protected Double saldo;
    protected Integer numeroDeConsignaciones = 0;
    protected Integer numeroDeRetiros = 0;
    protected Double porcentajeDeTasaAnual;
    protected Double comisionMensual = 0.0;
    protected static String operacionNoValida = "No se puede realizar la operación";
    protected static String operacionValida = "Operacion relizada exitosamente";

    public Cuenta (Double saldo, Double porcentajeDeTasaAnual){
        this.saldo = saldo;
        this.porcentajeDeTasaAnual = porcentajeDeTasaAnual;
    }

    protected static boolean esValidaCantidad(Double d){
        return d>=0&&d!=null;
    }

    public String consignar (Double cantidad){
        if(esValidaCantidad(cantidad)){
            this.saldo+=cantidad;
            numeroDeConsignaciones++;
            return operacionValida;
        }else{
            return operacionNoValida;
        }  
    }

    public String retirar(Double cantidad){
        if(this.saldo>=cantidad&&esValidaCantidad(saldo)){
            this.saldo-=cantidad;
            numeroDeRetiros++;
            return operacionValida;
        }else{
            return operacionNoValida;
        }
    }

    protected void calcularInteresMensual(){
        saldo+=saldo*((porcentajeDeTasaAnual/100)/12);
    }

    protected void calcularComisionMensual(){
        saldo-=comisionMensual;
    }

    public void extractoMensual(){
        calcularComisionMensual();
        calcularInteresMensual();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("saldo=").append(saldo);
        sb.append(", numeroDeConsignaciones=").append(numeroDeConsignaciones);
        sb.append(", numeroDeRetiros=").append(numeroDeRetiros);
        sb.append(", porcentajeDeTasaAnual=").append(porcentajeDeTasaAnual);
        sb.append(", comisionMensual=").append(comisionMensual);
        sb.append('}');
        return sb.toString();
    }





}
