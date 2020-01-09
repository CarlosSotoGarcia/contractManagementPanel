package com.adobe.boundary;

import com.adobe.control.ContractManager;
import com.adobe.entity.Contract;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ContractBacking implements Serializable {
    private List<Contract> contracts;

    private Contract contract = new Contract();

    @Inject
    private ContractManager contractManager;

    @PostConstruct
    public void init() {
        this.contracts = contractManager.loadAll();
    }

    public void delete(Contract contract) {
        contractManager.delete(contract);
        contracts.remove(contract);
    }

    public void add() {
        contractManager.addNew(contract);
        this.contracts = contractManager.loadAll();
        this.contract = new Contract();
    }

    public void update() {
        contractManager.update(contracts);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractManager getContractManager() {
        return contractManager;
    }

    public void setContractManager(ContractManager contractManager) {
        this.contractManager = contractManager;
    }
}
