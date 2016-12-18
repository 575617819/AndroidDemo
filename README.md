##AndroidDemo
####(Android第一行代码第二版简单示例代码)

####2016_1216_recyclerview_demo
    - RecyclerView使用步骤
            第一步：Android团队将RecyclerView定义在support库当中，所以需要在项目的build.gradle文件中添加百分比布局的依赖。
                    即打开使用RecyclerView百分比布局module目录下的build.gradle文件，在dependencies闭包中添加
                    compile 'com.android.support:recyclerview-v7:24.2.1'
            第二步：创建Adapter,继承自RecyclerView.Adapter;创建内部类，构造方法，并重写onCreateViewHolder、onBindViewHolder、getItemCount三个构造方法
            第三步：需要使用RecyclerView的activity的布局资源中添加RecyclerView控件，并设置布局方式和适配器，完成RecyclerView和数据之间的关联


####2016_1217_percentlayout_demo
    -百分比布局使用步骤
            第一步：Android团队将百分比布局定义在support库当中，所以需要在项目的build.gradle文件中添加百分比布局的依赖。
                    即打开要使用百分比布局module目录下的build.gradle文件，在dependencies闭包中添加
                    compile 'com.android.support:percent:24.2.1'
            第二步：由于百分比布局并不是内置在系统SDK当中的，所以需要把完整的包路径写出来
                    xmlns:app="http://schemas.android.com/apk/res-auto"
            第三步：使用百分比布局的属性时，需要定义一个app的命名空间
                    例如：app:layout_widthPercent="100%"
                          app:layout_heightPercent="10%"
                          

####2016_1217_menu_demo
    -如何给activity添加菜单
            第一步：在res目录下新建menu文件夹
            第二步：在menu文件夹中新建Menu resource file类型的布局资源
            第三步：在需要添加菜单的activity中重写onCreateOptionsMenu和onOptionsItemSelected两个方法
                    其中onCreateOptionsMenu用于初始话菜单布局
                    onOptionsItemSelected用于响应菜单的点击事件
                    

####2016_1217_customview_demo
    -简单的自定义view：实现统一的标题栏，并添加响应事件
            第一步：使用include标签加载重复的布局titile.xml，减少布局代码的冗余
                    注意：include只是解决了重复布局代码的问题，但是如果每个标题栏中有几个按钮需要响应事件，
                          这个时候在每个activity中都需要添加响应事件，代码也会重复很多
                          所以引入TitleLayout继承自LinearLayout来进行添加响应事件
            第二步：class TitleLayout extends LinearLayout(实现一个带两个参数的构造方法)
                    加载布局文件title.xml,并给按钮添加响应事件
            第三步：在需要使用统一风格标题栏activity加载的布局资源中，添加自定义TitleLayout，
                    并该在activity隐藏原有的标题栏
                    

####2016_1218_broadcast_demo
    -监听网络是否可用的广播接受者（动态注册）
    -监听系统开机的广播接受者（静态注册）
    
    -无序广播（标准广播）
    -有序广播
    
    -动态注册
        -即代码注册
        -动态注册的广播必须取消注册
                IntentFilter intentFilter = new IntentFilter();
                //android.net.conn.CONNECTIVITY_CHANGE是网络发生变化时，系统发出的值
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                networkReceiver = new NetworkReceiver();
                registerReceiver(networkReceiver, intentFilter);
                
                unregisterReceiver(networkReceiver);
         -优点：可以自由的控制广播的注册与注销，比较灵活
         -缺点：必须在应用程序启动之后才能接收广播
    -静态注册
        -在AndroidManifest.xml文件中注册，无需启动应用程序即可接收广播
        
    -发送无序广播
    -发送有序广播
    -本地广播的使用（解决安全性问题）
        
            
####2016_1218_offline_demo
    -模拟实现强制下线功能
        ActivityCollector:操作Activity的工具类
                静态方法：addActivity/removeActivity/removeAllActivity
        BaseActivity:项目中Activity的基类
                添加activity(onCreate)、移除activity(onDestroy)、注册广播(onResume)、注销广播(onPause)
        LoginActivity:登录activity
                用户名、密码、登录按钮
        MainActivity:发送广播
        OfflineReceiver:广播接收者
    