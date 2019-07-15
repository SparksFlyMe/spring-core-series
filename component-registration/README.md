Spring核心系列之“组件注册”

# 总结：
### 给容器中注册组件的几种方式：
##### 1、包扫描 + 组件标注注解（@Controller、@Service、@Repository、@Component）
##### 2、@Bean（导入第三方包里面的组件，比如RestTemplate）
##### 3、@Import（快速给容器中导入一个组件）

1. @Import（要导入到容器的组件）；容器中就会自动注册这个组件，id默认是全类名
2. 实现ImportSelector类：返回需要导入的组件的全类名数组
3. 实现ImportBeanDefinitionRegistrar：手动注册bean到容器中

##### 4、使用Spring提供的FactoryBean(工厂Bean)