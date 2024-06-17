package com.mountain.monk;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.MethodInfo;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class MyAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new TimeTransformer(),true);

    }



    public static class TimeTransformer implements ClassFileTransformer {


        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            // 这里我们限制下，只针对目标包下进行耗时统计
            if (!className.startsWith("com/mountain/monk/")) {
                return classfileBuffer;
            }

            CtClass cl = null;
            try {
                ClassPool classPool = ClassPool.getDefault();

                cl = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));


                for (CtMethod method : cl.getDeclaredMethods()) {
                    method.addLocalVariable("start", CtClass.longType);
                    method.insertBefore("start = System.currentTimeMillis(); ");
                    method.insertAfter("System.out.println(\"「monk」methodName:" + method.getName() + ", cost: \" + (System" +
                            ".currentTimeMillis() - start));");
                }

                return cl.toBytecode();
            } catch (Exception e) {
                System.err.println("Error transforming class: " + className);

                e.printStackTrace();
            }
            return classfileBuffer;

        }
    }
}