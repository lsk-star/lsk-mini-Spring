import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.lskspringFrameWork.beans.factory.PropertyValue;
import com.lskspringFrameWork.beans.factory.PropertyValues;
import com.lskspringFrameWork.beans.factory.config.BeanDefinition;
import com.lskspringFrameWork.beans.factory.config.BeanReference;
import com.lskspringFrameWork.beans.factory.support.BeanDefinitionReader;
import com.lskspringFrameWork.beans.factory.support.DefaultListableBeanFactory;
import com.lskspringFrameWork.beans.factory.support.XmlBeanDefinitionReader;
import com.lskspringFrameWork.core.io.ClassPathResource;
import com.lskspringFrameWork.core.io.DefaultResourceLoader;
import com.lskspringFrameWork.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class ApiTest {
    private DefaultResourceLoader resourceLoader;


    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_fileConfig() throws Exception {

        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xmlConfig() throws Exception {

        DefaultListableBeanFactory beanFactory =new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

    @Test
    public void test_url() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
