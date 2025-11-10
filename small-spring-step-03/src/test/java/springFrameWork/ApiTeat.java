package springFrameWork;


import com.lsk.springFrameWork.factory.config.BeanDefinition;
import com.lsk.springFrameWork.factory.support.AbstractBeanFactory;
import com.lsk.springFrameWork.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import springFrameWork.bean.UserService;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class ApiTeat {

    @Test
    public void test_BeanFactory() throws Exception {

        DefaultListableBeanFactory defaultListableBeanFactory =new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));

        UserService bean = (UserService) defaultListableBeanFactory.getBean("userService","lsk");
        bean.queryUserInfo();


        //============================================================================================================

//        AbstractBeanFactory abstractBeanFactory = new DefaultListableBeanFactory();
//
//        UserService bean3 = (UserService) abstractBeanFactory.getBean("userService");
//        bean3.queryUserInfo();
//

    }
}
