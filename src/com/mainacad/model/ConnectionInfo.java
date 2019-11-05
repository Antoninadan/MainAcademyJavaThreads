package com.mainacad.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionInfo implements Serializable {
    private String ip;
    private Integer sessionId;
    private Long connectionTime;

    @Override
    public String toString() {
        return sessionId + " " + connectionTime + " " + ip;
    }
}
