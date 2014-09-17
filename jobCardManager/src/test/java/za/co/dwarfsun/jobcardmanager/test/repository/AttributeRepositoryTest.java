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
import za.co.dwarfsun.jobcardmanager.domain.Attribute;
import za.co.dwarfsun.jobcardmanager.repository.AttributeRepository;
import za.co.dwarfsun.jobcardmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class AttributeRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AttributeRepository attributeRepository;
    
    public AttributeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createAttribute(){
        attributeRepository = ctx.getBean(AttributeRepository.class);
        Attribute attribute = new Attribute.Builder("Parcel Number")
                .tableName("parcel")
                .field("strap")
                .iskey(Boolean.TRUE)
                .build();
        attributeRepository.save(attribute);
        id = attribute.getId();
        Assert.assertNotNull(attribute);
    }
    
    @Test(dependsOnMethods="createAttribute", enabled=true)
    public void readAttribute(){
        attributeRepository = ctx.getBean(AttributeRepository.class);
        Attribute attribute = attributeRepository.findOne(id);
        Assert.assertEquals(attribute.getField(), "strap");
    }
    
    @Test(dependsOnMethods="readAttribute", enabled=true)
    public void updateAttribute(){
        attributeRepository = ctx.getBean(AttributeRepository.class);
        Attribute attribute = attributeRepository.findOne(id);
        
        Attribute updatedAttribute = new Attribute.Builder("Use Code")
                .Attribute(attribute)
                .field("dor_cd")
                .iskey(Boolean.FALSE)
                .build();
        attributeRepository.save(updatedAttribute);
        Attribute newAttribute = attributeRepository.findOne(id);
        Assert.assertEquals(newAttribute.getDescription(), "Parcel Number");
        Assert.assertEquals(newAttribute.getField(), "dor_cd");
    }
    
    @Test(dependsOnMethods="updateAttribute", enabled=true)
    public void deleteAttribute(){
        attributeRepository = ctx.getBean(AttributeRepository.class);
        Attribute attribute = attributeRepository.findOne(id);
        attributeRepository.delete(attribute);
        Attribute deletedAttribute = attributeRepository.findOne(id);
        Assert.assertNull(deletedAttribute);
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
