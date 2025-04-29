package com.keeyo.mybatiscodehelperpj;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        classPool.insertClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
        String jarPath = "D:/workspace";
        classPool.appendClassPath(jarPath + "/instrumented-MyBatisCodeHelper-Pro241-3.4.1+2321.jar");
        CtClass ctClass = classPool.get("com.ccnode.codegenerator.af.f.e");

        CtMethod parseLicenseMethod = ctClass.getDeclaredMethod("a", new CtClass[] { classPool.get("java.lang.String") });
        StringBuffer bodyBuff = new StringBuffer();
        bodyBuff.append("{")
                .append("  com.google.gson.Gson gson = new com.google.gson.Gson();")
                .append("  com.ccnode.codegenerator.af.d.f e = (com.ccnode.codegenerator.af.d.f)gson.fromJson($1,com.ccnode.codegenerator.af.d.f.class);")
                .append("  return e;")
                .append("}");
        parseLicenseMethod.setBody(bodyBuff.toString());

//         对修改的文件，写出到一个新文件
        ctClass.writeFile("F:/Temp");
        System.out.println("""
            修改成功。
            将原有jar文件用压缩工具打开，用新生成的class类替换对应的类。再离线激活。userMac为你的机器码。
            {
                "paidKey": "XXX",
                "valid": true,
                "userMac": "XX-XX-XX-XX-XX-XX",
                "validTo": 4859711999000
            }
        """);

        // https://blog.csdn.net/weixin_37555975/article/details/147319559
    }

}
