package br.ufc.crateus.events.service.http;

import java.util.List;

public class Payload {

    private String id;
    private String cpf;
    private String name;
    private String email;
    private String registry;
    private String siape;
    private List<String> types;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registry='" + registry + '\'' +
                ", siape='" + siape + '\'' +
                ", types=" + types +
                '}';
    }
}
