package com.rpg;

public class EnergyLosses  {
    protected double R; // расстояние [км]
    protected double t; // температура воздуха в месте источника [C]
    protected double f; // частота [Гц]
    protected double p; // концетрация водяных паров в атмосфере [г/м3]
    protected double Wsv; // может быть прямая и загаризонтная

    public EnergyLosses(double R,double t,double f,double p, double Wsv){
        this.R= R;
        this.t= t;
        this.f= f;
        this.p=p;
        this.Wsv=Wsv;
        energyLossesStraight();
    }
    public EnergyLosses(double R,double f, double Wsv){
        this.R=R;
        this.f=f;
        this.Wsv=Wsv;
    }

    private double energyLossesStraight(){
        double gammaO2= (6.09/(Math.pow(this.f,2)+0.227)+(7.19*Math.pow(10,-3))+4.81/(Math.pow((this.f-57),2)+1.5))*Math.pow(this.f,2)*Math.pow(10,-3);
        double gammaH2O=(0.05+3.6/(Math.pow((this.f-22.2),2)+8.5)+0.021*this.p+10.6/(Math.pow((this.f-188.3),2)+9)+8.9/(Math.pow((this.f-325.4),2)+26.3))*Math.pow(this.f,2)*this.p*Math.pow(10,-4);
        double Wa = this.R*(((1-(this.t-15)*0.01)*gammaO2+(1-15)*0.06)* gammaH2O);
        return Wa+Wsv;
    }
    private double energyLossesPerHorizon(){
        double Wst;
        double lam= 299792458/this.f;
        if (R<= 100*(1+Math.log10(f))) {

        }
        return Wsv;
    }
}
