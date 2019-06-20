task("myTask", {
    //扫描时运行
    println("scan")

    //调用时运行
    doFirst {
        println("myTask")
    }
    doLast{

    }
})
//
////依赖
task("myTask2", {
    //扫描时运行
    println("scan")

    //调用时运行
    doLast {
        println("two")
    }
    doFirst {
        println("one")
    }

}).dependsOn("myTask")
//
//task("closeDoor", {
//    //扫描时运行
//    println("scan")
//
//    //调用时运行
//    doFirst {
//        println("closeDoor")
//    }
//}).dependsOn("putElephant")
//
////任务集
////tasks{
////
////    "task1"{
////        println("scan")
////    }
////
////    "task2"{
////        println("scan")
////    }
////
////    "task3"{
////        println("scan")
////    }
////
////}
//
////查看默认任务
////T:gradlew tasks
//
task("kown_project", {
    project.properties.forEach { t, any ->
        println("$t:$any")
    }
})

//默认执行任务配置
defaultTasks("println")
//
//plugins{
//    java
//}
//
////把所有源代码的文件名称记录下来
////增量式更新
//task("getSrcName",{
//    inputs.dir("src")
//    outputs.file("info.txt")
//    doFirst{
//        var srcDir = fileTree("src")
//        var info = file("info.txt")
//        srcDir.forEach{
//            if(it.isFile){
//                Thread.sleep(100)
//                info.appendText(it.absolutePath)
//                info.appendText("\r\n")
//            }
//        }
//    }
//})
//gradle插件自定义拓展
task("myDelete",Delete::class,{
    //setDelete("src/main/java/temp")
})
task("myCopy",Copy::class,{
    from("src")
    into("haha")
})
task("myJar",Jar::class,{
    from("src")
    into("a.jar")
})
//调用外部拓展
task("useOutsideCode",{
    doFirst({
        javaexec{
            main = "Main"
            classpath(".")
        }
    })

})

//application插件
//java插件
//war插件
plugins{
    application
    `kotlin-dsl`
}

application {
    mainClassName = "MainKt"
}

dependencies{
    compile(kotlin("stdlib"))
    //依赖管理
    //gradle会自动下载三方的依赖包
    compile("commons-httpclient","commons-httpclient","3.1")
    //编译时依赖 compile
    //测试时依赖 testCompile
    testCompile("junit","junit","4.8.1")
    //解决依赖冲突
    //1、Gradle自动依赖高版本 commons-logging->1.2
    //2、手动解除依赖
    compile("org.springframework","spring-core","4.3.9.RELEASE"){
        exclude("commons-logging","commons-logging")
    }

}

repositories{
    mavenCentral()
    jcenter()
}



