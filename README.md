# AIDL-
>
<br>**1**，app是对aidl的服务端 </br>
**2**，clientaidl是对aidl的客户端，


接口在app里定义    请求在clientaidl中传入

[参考地址:](https://www.cnblogs.com/zhujiabin/p/6080806.html)
<br>步骤</br>
1,在ServerAidl中创建aidl文件， AndroidStudio可以自动创建


2，在aidl接口中创建方法暴露到外面掉用


3，刷新AndroidStudio创建aidl相对应的java文件


4，创建java文件后，我们就能在service中拿到之前在aidl接口中定义的方法

通过这个对象new IMyAidlInterface.Stub()去拿到IBinder的对象，从service中bind返回出去

5，在clientaidl中也创建和serveraidl中一样的aidl文件，最好复制过来

6，在serveraidl中通过ServiceConnection 的回调方法中，返回IMyAidlInterface.Stub.asInterface(iBinder)活动aidl对象

7，再在sereraidl中bindserver 通过设置包名setPackage和action来bindservice

8，在bind中传入ServiceConnection的对象 bindService(intent,sc,Context.BIND_AUTO_CREATE);

9，最后一步int value = aidl.getValue(100, 100);通过ServiceConnection中的对象去调用aidl中的方法




thanks

