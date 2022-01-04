package com.jain.bt.ejb;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Greeting implements Serializable {
    private String greetingText;

    public Greeting() {
    }

    public Greeting(String greetingText) {
        this.greetingText = greetingText;
    }

    public void setGreetingText(String greetingText) {
        this.greetingText = greetingText;
    }

    public String getGreetingText() {
        return greetingText;
    }
}
