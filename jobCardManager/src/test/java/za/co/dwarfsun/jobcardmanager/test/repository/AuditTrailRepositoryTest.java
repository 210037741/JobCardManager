/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.test.repository;

//import java.time.Instant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import za.co.dwarfsun.jobcardmanager.domain.AuditTrail;
import za.co.dwarfsun.jobcardmanager.repository.AuditTrailRepository;
import za.co.dwarfsun.jobcardmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class AuditTrailRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AuditTrailRepository auditTrailRepository;
    
    public AuditTrailRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(enabled=false)
    public void createAuditTrail(){
        auditTrailRepository = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = new AuditTrail.Builder(new Date())
                .username("TestCaseDummyUser")
                .tableName("NotARealTable")
                .field("column1")
                .type("INSERT")
                .oldValue(null)
                .newValue("test case data")
                .build();
        auditTrailRepository.save(auditTrail);
        id = auditTrail.getId();
        Assert.assertNotNull(auditTrail);
    }
    
    @Test(dependsOnMethods="createAuditTrail", enabled=false)
    public void readAuditTrail(){
        auditTrailRepository = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = auditTrailRepository.findOne(id);
        Assert.assertEquals(auditTrail.getField(), "column1");
    }
    
    @Test(dependsOnMethods="readAuditTrail", enabled=false)
    public void updateAuditTrail(){
        auditTrailRepository = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = auditTrailRepository.findOne(id);
        
        AuditTrail updatedAuditTrail = new AuditTrail.Builder(new Date())
                .AuditTrail(auditTrail)
                .type("UPDATE")
                .oldValue(auditTrail.getNewValue())
                .newValue("Updated")
                .build();
        auditTrailRepository.save(updatedAuditTrail);
        AuditTrail newAuditTrail = auditTrailRepository.findOne(id);
        Assert.assertEquals(newAuditTrail.getType(), "UPDATE");
    }
    
    @Test(dependsOnMethods="updateAuditTrail", enabled=false)
    public void deleteAuditTrail(){
        auditTrailRepository = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = auditTrailRepository.findOne(id);
        auditTrailRepository.delete(auditTrail);
        AuditTrail deletedAuditTrail = auditTrailRepository.findOne(id);
        Assert.assertNull(deletedAuditTrail);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //Initialise the test context
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
