package io.hedwig.blog;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

/**
 * Created by patrick on 15/10/21.
 */
public class BlogApplicationTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private String profiles;

    @Before
    public void init(){
        this.profiles=System.getProperty("spring.profiles.active");
    }

    @After
    public void after(){
        if(this.profiles!=null){
            System.setProperty("spring.profiles.active",this.profiles);
        }else{
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultSettings(){
        BlogApplication.main(new String[0]);
        String output= this.outputCapture.toString();
        assertTrue("Wrong output: "+output,output.contains("patrick"));
    }

    @Test
    public void testSettings(){
        BlogApplication.main(new String[]{"--name simon"});
        String output= this.outputCapture.toString();
        assertTrue("Wrong output: "+output,output.contains("simon"));
    }
}