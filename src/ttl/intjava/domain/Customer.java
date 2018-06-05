package ttl.intjava.domain;

import java.util.Objects;

/**
 * Created by rmadan on 6/4/18.
 */
public class Customer {
    Integer id;
    String name;
    Status status;

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(Integer id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                status == customer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }


    public enum Status {
        PRIVILEGED("Privileged"),
        NORMAL("Normal"),
        RESTRICTED("Restricted");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
