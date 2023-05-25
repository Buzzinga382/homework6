package hw6;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Laptop {

    private String brand;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double size;


    public Laptop(String brand, int ram, int hdd, String os, String color, double size) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString(){
        return "Brand: " + brand + "\n" +
                "RAM: " + ram + "\n" +
                "HDD: " + hdd + "\n" +
                "OS: " + os + "\n" +
                "Color: " + color + "\n" +
                "Screen size: " + size + "\n";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Laptop l) {
            return Objects.equals(brand, l.brand) &&
                    ram == l.ram &&
                    hdd == l.hdd &&
                    os.equals(l.os) &&
                    color.equals(l.color) &&
                    size == l.size;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, hdd, os, color, size);
    }


}
