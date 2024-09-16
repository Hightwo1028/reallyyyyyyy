package org.bunnysugar.pojo;

import java.time.LocalDateTime;

public class User {
    private Integer id; // 主键ID
    private String account; // 帳號
    private String password; // 密碼
    private String email; // 電子郵件
    private String name; // 姓名
    private Integer gender; // 性別
    private String phone; // 電話號碼
    private LocalDateTime birthday; // 生日
    private Integer bunnyCoin; // 虛擬貨幣
    private String isActive; // 是否啟用
    private String verifyingToken; // 驗證碼
    private LocalDateTime tokenExpirationTime; // 驗證碼過期時間
    private String forgetToken; // 忘記密碼碼
    private Integer loginMethod; // 登入方式
    private String googleToken; // Google 登入 token
    private String facebookToken; // Facebook 登入 token
    private LocalDateTime createTime; // 建立時間
    private LocalDateTime updateTime; // 更新時間
    private LocalDateTime lastLoginTime; // 最後登入時間
    private Integer gameTimes; // 遊戲次數

    // 全部參數的建構子
    public User(Integer id, String account, String password, String email, String name, Integer gender, String phone, LocalDateTime birthday, Integer bunnyCoin, String isActive, String verifyingToken, LocalDateTime tokenExpirationTime, String forgetToken, Integer loginMethod, String googleToken, String facebookToken, LocalDateTime createTime, LocalDateTime updateTime, LocalDateTime lastLoginTime, Integer gameTimes) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.bunnyCoin = bunnyCoin;
        this.isActive = isActive;
        this.verifyingToken = verifyingToken;
        this.tokenExpirationTime = tokenExpirationTime;
        this.forgetToken = forgetToken;
        this.loginMethod = loginMethod;
        this.googleToken = googleToken;
        this.facebookToken = facebookToken;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
        this.gameTimes = gameTimes;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getBunnyCoin() {
        return bunnyCoin;
    }

    public void setBunnyCoin(Integer bunnyCoin) {
        this.bunnyCoin = bunnyCoin;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getVerifyingToken() {
        return verifyingToken;
    }

    public void setVerifyingToken(String verifyingToken) {
        this.verifyingToken = verifyingToken;
    }

    public LocalDateTime getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(LocalDateTime tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public String getForgetToken() {
        return forgetToken;
    }

    public void setForgetToken(String forgetToken) {
        this.forgetToken = forgetToken;
    }

    public Integer getLoginMethod() {
        return loginMethod;
    }

    public void setLoginMethod(Integer loginMethod) {
        this.loginMethod = loginMethod;
    }

    public String getGoogleToken() {
        return googleToken;
    }

    public void setGoogleToken(String googleToken) {
        this.googleToken = googleToken;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getGameTimes() {
        return gameTimes;
    }

    public void setGameTimes(Integer gameTimes) {
        this.gameTimes = gameTimes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", bunnyCoin=" + bunnyCoin +
                ", isActive='" + isActive + '\'' +
                ", verifyingToken='" + verifyingToken + '\'' +
                ", tokenExpirationTime=" + tokenExpirationTime +
                ", forgetToken='" + forgetToken + '\'' +
                ", loginMethod=" + loginMethod +
                ", googleToken='" + googleToken + '\'' +
                ", facebookToken='" + facebookToken + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastLoginTime=" + lastLoginTime +
                ", gameTimes=" + gameTimes +
                '}';
    }
}
