package org.bunnysugar.pojo;

public class VerifyRequest {
    private String token;
    private Integer userId;

    public VerifyRequest() {
    }

    public VerifyRequest(String token, Integer userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VerifyRequest{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
