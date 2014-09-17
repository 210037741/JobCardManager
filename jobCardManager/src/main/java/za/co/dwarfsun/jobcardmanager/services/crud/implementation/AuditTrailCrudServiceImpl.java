/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.services.crud.implementation;

import za.co.dwarfsun.jobcardmanager.domain.AuditTrail;
import za.co.dwarfsun.jobcardmanager.repository.GenericDAO;
import za.co.dwarfsun.jobcardmanager.services.crud.AuditTrailCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matthew
 */
@Service("auditTrailCrudService")
@Transactional
public class AuditTrailCrudServiceImpl  implements AuditTrailCrudService{
    @Autowired
    private GenericDAO<AuditTrail> dao;
    
    public final void setDao(final GenericDAO<AuditTrail> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(AuditTrail.class);
    }

    @Override
    public AuditTrail find(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public AuditTrail persist(AuditTrail entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public AuditTrail merge(AuditTrail entity) {
        setDao(dao);
        dao.merge(entity);
        return (entity);
    }

    @Override
    public void remove(AuditTrail entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public List<AuditTrail> findAll() {
        setDao(dao);
        return dao.findAll();
    }
}
