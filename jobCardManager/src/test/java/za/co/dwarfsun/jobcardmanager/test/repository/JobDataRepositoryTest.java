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

import za.co.dwarfsun.jobcardmanager.domain.JobData;
import za.co.dwarfsun.jobcardmanager.repository.JobDataRepository;
import za.co.dwarfsun.jobcardmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobDataRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobDataRepository jobDataRepository;
    
    public JobDataRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(enabled=false)
    public void createJobData(){
        jobDataRepository = ctx.getBean(JobDataRepository.class);
        JobData jobData = new JobData.Builder("test data")
                .attribute(null)
                .build();
        jobDataRepository.save(jobData);
        id = jobData.getId();
        Assert.assertNotNull(jobData);
    }
    
    @Test(dependsOnMethods="createJobData", enabled=false)
    public void readJobData(){
        jobDataRepository = ctx.getBean(JobDataRepository.class);
        JobData jobData = jobDataRepository.findOne(id);
        Assert.assertEquals(jobData.getValue(), "test data");
    }
    
    @Test(dependsOnMethods="readJobData", enabled=false)
    public void updateJobData(){
        jobDataRepository = ctx.getBean(JobDataRepository.class);
        JobData jobData = jobDataRepository.findOne(id);
        
        JobData updatedJobData = new JobData.Builder("changed data")
                .JobData(jobData)
                .build();
        jobDataRepository.save(updatedJobData);
        JobData newJobData = jobDataRepository.findOne(id);
        Assert.assertEquals(newJobData.getValue(), "changed data");
    }
    
    @Test(dependsOnMethods="updateJobData", enabled=false)
    public void deleteJobData(){
        jobDataRepository = ctx.getBean(JobDataRepository.class);
        JobData jobData = jobDataRepository.findOne(id);
        jobDataRepository.delete(jobData);
        JobData deletedJobData = jobDataRepository.findOne(id);
        Assert.assertNull(deletedJobData);
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
