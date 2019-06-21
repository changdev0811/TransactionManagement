package com.model;

public class Transaction {
    public Transaction(){

    }

    private int accountNo;
    private String description;
    private String criteria;
    private String result;
    private Double stack;
    private Double price;
    private Double amount;
    private String direction;

    public int getAccountNo(){
        return accountNo;
    }
    public void setAccountNo(int accountNo){
        this.accountNo = accountNo;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double getStack(){
        return stack;
    }

    public void setStack(Double stack){
        this.stack = stack;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public String getDirection(){
        return direction;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }
}
