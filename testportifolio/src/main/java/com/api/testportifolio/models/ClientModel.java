package com.api.testportifolio.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_customers")
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Field not informed!")
    private String corporateName;

    @NotBlank(message = "Field not informed!")
    private String cnpj;

    @NotBlank(message = "Field not informed!")
    @Column(nullable = false, unique = true)
    private String email;

    private Boolean active;

    @ManyToOne
    public TaxRegimeModel taxRegime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TaxRegimeModel getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(TaxRegimeModel taxRegime) {
        this.taxRegime = taxRegime;
    }
}
