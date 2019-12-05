package learn.demo;


import learn.demo.domain.TestA;
import learn.demo.domain.TestB;
import learn.demo.domain.TestC;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2019120401 {
	public static void main(String[] args) {
		/**
		 * 循环依赖：循环依赖就是循环引用，就是两个或者多个bean相互之间的持有对方。a引用b,b引用c,c引用a,则他们最终反映为一个环。
		 *
		 * 分为：构造器循环依赖和setter循环依赖
		 * 处理：构造器循环依赖，无法解决，抛出BeanCurrentlyInCreationException异常
		 */
		try {
			ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
			TestA testA = (TestA) classPathXmlApplicationContext.getBean("testA");
			TestB testB = (TestB) classPathXmlApplicationContext.getBean("testB");
			TestC testC = (TestC) classPathXmlApplicationContext.getBean("testC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
