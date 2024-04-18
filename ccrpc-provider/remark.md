### maven跳过test打包
1.` <!--打包时跳过测试-->
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>2.18.1</version>
<configuration>
<skipTests>true</skipTests>
</configuration>
</plugin>`
## ApplicationContextAware
1.当一个类实现了这个接口之后，这个类就可以方便的获得ApplicationContext对象（spring上下文），
Spring发现某个Bean实现了ApplicationContextAware接口，Spring容器会在创建该Bean之后，
自动调用该Bean的setApplicationContext（参数）方法，调用该方法时，会将容器本身ApplicationContext对象作为参数传递给该方法。
主要是获取 ApplicationContex


