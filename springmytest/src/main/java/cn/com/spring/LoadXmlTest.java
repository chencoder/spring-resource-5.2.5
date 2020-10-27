package cn.com.spring;

import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.awt.*;

/**
 * @Description:
 * @Author:chendongchang
 * @Create: 2020-08-31 20:51
 * @Version: 1.0
 **/
public class LoadXmlTest {

	@Test
	public void testLoadXml(){
		/*ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Object users = ac.getBean("users");*/
		//加载资源
		Resource resource=new ClassPathResource("applicationContext.xml");
		//定义bean factory
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		//创建bean读取类 关联factory
		BeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		//关联资源，读取资源，把对应的bean信息放到factory中
		reader.loadBeanDefinitions(resource);
		//获取bean
		Users users = (Users)factory.getBean("users");
		System.out.println("username="+users.getUsername());
		System.out.println("sex="+users.getSex());
		System.out.println("age="+users.getAge());

	}
}
