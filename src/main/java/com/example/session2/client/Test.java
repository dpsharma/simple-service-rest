package com.example.session2.client;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<GuideLines> list = new ArrayList<GuideLines>();
        GuideLines gl = new GuideLines();
        gl.setTopic("Analgesic");

        list.add(gl);
        list.add(gl);
        System.out.println(list.size());
        System.out.println(gl == gl);
    }
}

class GuideLines {
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
