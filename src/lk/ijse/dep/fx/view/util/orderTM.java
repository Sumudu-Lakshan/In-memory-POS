package lk.ijse.dep.fx.view.util;

public class orderTM {
    private String itemCode;
    private String description;
    private String unitPrice;
    private String qty;
    private String total;
    private String orderId;
    private String date;
    private String customerId;
    private String customerName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public orderTM() {
    }

    public orderTM(String itemCode, String description, String unitPrice, String qty, String total) {
        this.itemCode = itemCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
        System.out.println("order"+this.getOrderId());
    }

    public orderTM(String item, String description, String unitPrice, String qty, String total, String orderId, String date, String customerId, String customerName) {
        this.itemCode = item;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.customerName = customerName;
        System.out.println("order"+this.getOrderId());
    }



    public void setItem(String item) {
        this.itemCode = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String  getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
