import com.springapp.mvc.bean.RiskItem;
import com.springapp.mvc.dao.RiskItemDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by WH on 2016/11/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class RiskItemTest {

    @Autowired
    RiskItemDao riskItemDao;

    @Test
    public void testInsert() {
        RiskItem item = new RiskItem(1,1,2,"你好啊我是描述",1,0,1);
        riskItemDao.insert(item);
    }

}