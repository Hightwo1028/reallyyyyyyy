package org.bunnysugar.pojo;

import java.time.LocalDateTime;

public class Cart {
    private Integer id; // 主键ID
    private Integer userId; // 使用者ID
    private Integer total; // 總計
    private LocalDateTime createTime; // 建立時間
    private LocalDateTime updateTime; // 更新時間

    public Cart() {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
