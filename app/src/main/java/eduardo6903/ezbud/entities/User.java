package eduardo6903.ezbud.entities;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private Double balance;
    private Double income;
    private String dateIncome;

    public User(){

    }

    public User(Integer id, String name, Double balance, Double income, String dateIncome){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.income = income;
        this.dateIncome = dateIncome;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getDateIncome() {
        return dateIncome;
    }

    public void setDateIncome(String dateIncome) {
        this.dateIncome = dateIncome;
    }
}
