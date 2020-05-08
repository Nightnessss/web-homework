package com.fehead.beans;

/**
 * @author Nightessss 2020/5/8 16:22
 */
public class SimpleCalculator {

    private Double first;
    private Double second;
    private String operator;
    private Double result;

    public Double calculator() {
        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            default:
                result = 0.0;
        }
        return result;
    }

    public SimpleCalculator(Double first, Double second, String operator) {
        this.first = first;
        this.second = second;
        this.operator = operator;
    }

    public SimpleCalculator() {
    }

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
