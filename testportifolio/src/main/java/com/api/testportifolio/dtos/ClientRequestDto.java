package com.api.testportifolio.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientRequestDto {

    @NotBlank(message = "Field not informed!")
    private String corporateName;

    @NotBlank(message = "Field not informed!")
    private String cnpj;

    @Email(message = "Email invalid")
    @NotBlank(message = "Field not informed!")
    private String email;

    private Long taxRegimeId;

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

    public Long getTaxRegimeId() {
        return taxRegimeId;
    }

    public void setTaxRegimeId(Long taxRegimeId) {
        this.taxRegimeId = taxRegimeId;
    }
}
