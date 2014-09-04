/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jobcardmanager.test.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import za.co.dwarfsun.jobcardmanager.model.JobCard;
import za.co.dwarfsun.jobcardmanager.repository.JobCardRepository;
import za.co.dwarfsun.jobcardmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobCardRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobCardRepository jobCardRepository;
    
    public JobCardRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobCard(){
        jobCardRepository = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = new JobCard.Builder("Res DCF")
                .jobCardAttributes(null)
                .build();
        jobCardRepository.save(jobCard);
        id = jobCard.getId();
        Assert.assertNotNull(jobCard);
    }
    
    @Test(dependsOnMethods="createJobCard", enabled=true)
    public void readJobCard(){
        jobCardRepository = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = jobCardRepository.findOne(id);
        Assert.assertEquals(jobCard.getName(), "Res DCF");
    }
    
    @Test(dependsOnMethods="readJobCard", enabled=true)
    public void updateJobCard(){
        jobCardRepository = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = jobCardRepository.findOne(id);
        
        JobCard updatedJobCard = new JobCard.Builder("Res DCF")
                .JobCard(jobCard)
                .build();
        jobCardRepository.save(updatedJobCard);
        JobCard newJobCard = jobCardRepository.findOne(id);
        Assert.assertEquals(newJobCard.getName(), "Res DCF");
    }
    
    @Test(dependsOnMethods="updateJobCard", enabled=true)
    public void deleteJobCard(){
        jobCardRepository = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = jobCardRepository.findOne(id);
        jobCardRepository.delete(jobCard);
        JobCard deletedJobCard = jobCardRepository.findOne(id);
        Assert.assertNull(deletedJobCard);
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
