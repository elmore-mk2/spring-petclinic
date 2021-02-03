package org.springframework.samples.petclinic.system;

public class Command {
    private StringBuffer result;
    public Command() {
        this.result = new StringBuffer();
    }

    public void setResult(String result) {
        this.result.append(result);
    }

    public void setResult(char result) {
        this.result.append(result);
    }

    public String getResult() {
        return this.result.toString();
    }
}
