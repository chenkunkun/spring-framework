package learn.demo;

import learn.demo.domain.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.testng.Assert;

public class Demo2019120301 {
	public static void main(String[] args) {
		/**
		 *加载外部资源配置文件xml
		 */
		Resource resource = new ClassPathResource("beanFactoryTest.xml");

		/**
		 * 创建容器
		 */
		BeanFactory beanFactory = new DefaultListableBeanFactory();

		/**
		 * 创建容器beand定义读取器
		 */
		BeanDefinitionReader bfr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		/**
		 * 加载配置信息，装载beanDefinition
		 */
		bfr.loadBeanDefinitions(resource);

		/**
		 * 获取bean
		 */
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		Assert.assertEquals("testStr", myTestBean.getTestStr());
	}

	//继承关系图
	//DefaultListableBeanFactory

}
