package sps.employees.history.SpsProject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    private Long employee_id;
    private String addressName;
    private Employee employee;

    @Id
    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    @Column(name = "address_name", length = 30)
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
