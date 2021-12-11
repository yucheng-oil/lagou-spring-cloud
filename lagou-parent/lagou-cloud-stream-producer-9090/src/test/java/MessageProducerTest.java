import com.lagou.StreamSpringBootApp9090;
import com.lagou.service.IMessageLogProducer;
import com.lagou.service.IMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {StreamSpringBootApp9090.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageProducerTest {

    @Autowired
    private IMessageProducer iMessageProducer;

    @Autowired
    private IMessageLogProducer messageLogProducer;


    @Test
    public void testSendMessage() {
        iMessageProducer.sendMessage("hello world-lagou");
        messageLogProducer.sendMessage("hello world-lagou-Log");
    }



}
