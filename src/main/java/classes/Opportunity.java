package classes;
import java.util.Objects;
import Enums.Product;
import Enums.Status;

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

        public static classes.Opportunity convertLeadToOpportunity (Lead lead, Product product, int quantity, Contact decisionMaker){

            if (quantity <= 0) {

                throw new IllegalArgumentException("Please, enter a valid number");
            }

            return new classes.Opportunity(product, quantity, decisionMaker);
        }

        public static void changeOpportunityStatus (classes.Opportunity opportunity, int oneTwo){


            if (oneTwo <1 || oneTwo > 2){

                throw new IllegalArgumentException("Please, enter a valid number");
            }


            if (oneTwo == 1){

                opportunity.setStatus(Status.CLOSED_WON);

            }

            if (oneTwo ==2){

                opportunity.setStatus(Status.CLOSED_LOST);
            }


        }

        public static void lookUpOpportunity (classes.Opportunity opportunity){

            System.out.println(opportunity.toString());

        }

        @Override
        public String toString() {

            return "Opportunity{" +
                    "product=" + product +
                    ", quantity=" + quantity +
                    ", decisionMaker=" + decisionMaker.getIdContact() +
                    ", status=" + status +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof classes.Opportunity)) return false;
            classes.Opportunity that = (classes.Opportunity) o;
            return getQuantity() == that.getQuantity() && getProduct() == that.getProduct() && getDecisionMaker().equals(that.getDecisionMaker()) && getStatus() == that.getStatus();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getProduct(), getQuantity(), getDecisionMaker(), getStatus());
        }

        public static int getId() {
            return id;
        }

        public static void setId(int id) {
            classes.Opportunity.id = id;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Contact getDecisionMaker() {
            return decisionMaker;
        }

        public void setDecisionMaker(Contact decisionMaker) {
            this.decisionMaker = decisionMaker;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }




