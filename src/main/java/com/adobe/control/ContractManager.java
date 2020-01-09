package com.adobe.control;

import com.adobe.entity.Contract;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Stateless
public class ContractManager {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Contract> loadAll() {
        return this.entityManager.createQuery("SELECT c FROM Contract c", Contract.class).getResultList();
    }

    public void delete(Contract contract) {
        if (entityManager.contains(contract)) {
            entityManager.remove(contract);
        } else {
            Contract managed = entityManager.find(Contract.class, contract.getId());
            if (managed != null) {
                entityManager.remove(managed);
            }
        }
    }

    public void addNew(Contract contract) {

        Contract newContract = new Contract();
        newContract.setProjectName(contract.getProjectName());
        newContract.setStatus(contract.getStatus());
        newContract.setProjectID(contract.getProjectID());

        this.entityManager.persist(contract);
    }

    public void update(List<Contract> customers) {
        customers.forEach(entityManager::merge);
    }
}
