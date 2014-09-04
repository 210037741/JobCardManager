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

import za.co.dwarfsun.jobcardmanager.model.JobCardAttribute;
import za.co.dwarfsun.jobcardmanager.repository.JobCardAttributeRepository;
import za.co.dwarfsun.jobcardmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobCardAttributeRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobCardAttributeRepository jobCardAttributeRepository;
    
    public JobCardAttributeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobCardAttribute(){
        jobCardAttributeRepository = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = new JobCardAttribute.Builder(1)
                .attribute(null)
                .jobCard(null)
                .build();
        jobCardAttributeRepository.save(jobCardAttribute);
        id = jobCardAttribute.getId();
        Assert.assertNotNull(jobCardAttribute);
    }
    
    @Test(dependsOnMethods="createJobCardAttribute", enabled=true)
    public void readJobCardAttribute(){
        jobCardAttributeRepository = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = jobCardAttributeRepository.findOne(id);
        Assert.assertEquals(jobCardAttribute.getLineNum(), 1);
    }
    
    @Test(dependsOnMethods="readJobCardAttribute", enabled=true)
    public void updateJobCardAttribute(){
        jobCardAttributeRepository = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = jobCardAttributeRepository.findOne(id);
        
        JobCardAttribute updatedJobCardAttribute = new JobCardAttribute.Builder(2)
                .JobCardAttribute(jobCardAttribute)
                .build();
        jobCardAttributeRepository.save(updatedJobCardAttribute);
        JobCardAttribute newJobCardAttribute = jobCardAttributeRepository.findOne(id);
        Assert.assertEquals(newJobCardAttribute.getLineNum, 2);
    }
    
    @Test(dependsOnMethods="updateJobCardAttribute", enabled=true)
    public void deleteJobCardAttribute(){
        jobCardAttributeRepository = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = jobCardAttributeRepository.findOne(id);
        jobCardAttributeRepository.delete(jobCardAttribute);
        JobCardAttribute deletedJobCardAttribute = jobCardAttributeRepository.findOne(id);
        Assert.assertNull(deletedJobCardAttribute);
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
