package com.dio.base;

import java.math.BigDecimal;

/**
 * @author prof daniel
 * @version 1.0.0
 * @see java.math.BigDecimal
 * @since Release 1.0.0 - 2022
 */
public class Order{
    private final String code;
    private final BigDecimal totalValue;

    //private String[] items;

    /**
     * construtor da classe
     *
     * @param code código do pedido
     * @param totalValue valor do pedido
     */
    public Order(String code, BigDecimal totalValue){

        //attribute order code
        this.code = code;
        this.totalValue = totalValue;
    }

    /**
     * method calculate order fee .
     *
     * @return valor total do parametro com as taxas
     * @throws RuntimeException se o valor do pedido for negativo
     */
    public BigDecimal calculateFeeWithIf() {
        if (this.totalValue.signum() < 0)
            throw new RuntimeException("O preço não pode ter valor negativo");
        if (this.totalValue.compareTo(new BigDecimal("100.00")) > 0) {
            return this.totalValue.multiply(new BigDecimal("0.99"));
        }
        return this.totalValue;

    }

//    public double calculateFeeWithSwitch(){
//        switch (this.totalValue){
//            case 100:
//                return this.totalValue * 0.99;
//            case 200:
//                return  this.totalValue * 1.99;
//            default:
//                return this.totalValue;
//        }
//    }
//
//    public void printItemsWithWhile(){
//        int i=0;
//        while(i < this.items.length){
//            System.out.println(this.items[i]);
//            i++;
//        }
//    }
//
//    public void printItemsWithDoWhile(){
//        int i=0;
//        do {
//            System.out.println(this.items[i]);
//            i++;
//        }while(i < this.items.length);
//    }
//
//    public void printItemsWithFor(){
//        for(int i = 0; i < this.items.length; i++){
//            System.out.println(this.items[i]);
//        }
//    }
//
//    public void printItemsWithEnhancedFor(){
//        for(String i : this.items){
//            System.out.println(i);
//        }
//    }


    @Override
    public String toString(){
        return "Order={" +
            "code = '" + code + "'" +
            "}";
    }
}