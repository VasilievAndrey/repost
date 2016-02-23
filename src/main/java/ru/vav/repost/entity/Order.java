package ru.vav.repost.entity;

/**
 * @author vav
 */
public class Order {

    private Long orderId;
    private String title;
    private String description;
    private String targetLink;
    private String comeBackLink;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetLink() {
        return targetLink;
    }

    public void setTargetLink(String targetLink) {
        this.targetLink = targetLink;
    }

    public String getComeBackLink() {
        return comeBackLink;
    }

    public void setComeBackLink(String comeBackLink) {
        this.comeBackLink = comeBackLink;
    }

    public boolean isNew() {
        return (this.orderId == null);
    }
}
