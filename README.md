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