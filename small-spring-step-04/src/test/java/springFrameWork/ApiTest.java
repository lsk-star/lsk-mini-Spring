package springFrameWork;


import com.lsk.springFrameWork.PropertyValue;
import com.lsk.springFrameWork.PropertyValues;
import com.lsk.springFrameWork.factory.config.BeanDefinition;
import com.lsk.springFrameWork.factory.config.BeanReference;
import com.lsk.springFrameWork.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import springFrameWork.bean.UserDao;
import springFrameWork.bean.UserService;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() throws Exception {

        DefaultListableBeanFactory defaultListableBeanFactory =new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));


        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("Uid","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));


        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");

        userService.queryUserInfo();

    }
}
