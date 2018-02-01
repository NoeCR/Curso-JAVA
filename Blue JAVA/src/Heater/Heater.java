package Heater;


/**
 * Write a description of class Heater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heater
{
    // instance variables - replace the example below with your own
    private double temperature;
    private double min, max,increment;
   
    /**
     * Constructor for objects of class Heater
     */
    public Heater(double min, double max)
    {
        // initialise instance variables
        temperature = 15.0;
        min = min;
        max = max;
        increment = 5.0;
    }

    public void warmer(){
        if((temperature + increment) > max){
            System.out.println("No se puede subir más la temperatura");
            return;
        }else{
            temperature += increment;
        }
    }
    public void cooler(){
        if((temperature - increment) < min){
            System.out.println("No se puede bajar más la temperatura");
            return;
        }else{
            temperature -= increment;
        }
    }
    public double getTemperature(){
        return temperature;
    }
    public void setIncrement(double inc){
        if(inc <= 5.0 && inc >= 1.0){
            increment = inc;
        }else{
            System.out.println("No se puede establecer el valor");
        }
    }
}
