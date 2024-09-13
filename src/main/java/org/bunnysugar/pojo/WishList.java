package org.bunnysugar.pojo;

import java.time.LocalDateTime;

public class WishList {
    private Integer id; // 主键ID
    private Integer userId; // 使用者ID
    private Integer cartId; // 購物車ID
    private LocalDateTime createTime; // 建立時間
    private LocalDateTime updateTime; // 更新時間

    public WishList() {
        this.id = id;
        this.userId = userId;
        this.cartId = cartId;
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

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
        return "WishList{" +
                "id=" + id +
                ", userId=" + userId +
                ", cartId=" + cartId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
