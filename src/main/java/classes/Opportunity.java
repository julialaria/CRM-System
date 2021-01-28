package classes;

import enums.Product;
import enums.Status;

import java.util.Objects;

public class Opportunity {

    private static int id;
    Product product;
    int quantity;
    Contact decisionMaker;
    Status status;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {

        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
        id++;
    }

    @Override
    public String toString() {

        return "Opportunity with product " + product +
                ", quantity = " + quantity +
                ", decision maker contact id is " + decisionMaker.getIdContact() +
                " and its status is " + status ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opportunity)) return false;
        Opportunity that = (Opportunity) o;
        return getQuantity() == that.getQuantity() && getProduct() == that.getProduct() && getDecisionMaker().equals(that.getDecisionMaker()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getQuantity(), getDecisionMaker(), getStatus());
    }

    public static int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
