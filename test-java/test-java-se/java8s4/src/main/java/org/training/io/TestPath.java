package org.training.io;

/*	 getResourceAsStream是获取流，getResource是获取URL
 * 首先，Java中的getResourceAsStream有以下几种： 
 * 	1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath(target/classes)根下获取。
 * 	           其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源.
 * 	2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath(src)根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
 * 		ClassLoader类的getResource(String name),getResourceAsStream(String name)等方法，使用相对于当前项目的classpath的相对路径来查找资源。
 * 		Thread.currentThread().getContextClassLoader().getResource("")	同样如此
 * 	3. ServletContext. getResourceAsStream(String path)：默认从WebAPP根目录下取资源，Tomcat下path是否以’/'开头无所谓，当然这和具体的容器实现有关。
 *  4. new File("hello.txt"); 是以当前工程(project)目录为根目录(不是module目录)
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestPath
{
	public void getPath(){
		//绝对路径
//		InputStream is = this.getClass().getResourceAsStream("/test2.txt"); //正确
		// /home/anderson/GitHub/test-project/test-java/target/classes/test2.txt
		System.out.println("---->:" + this.getClass().getResource("/test2.txt").getPath());
		//相对路径
//		InputStream is = this.getClass().getResourceAsStream("test.txt");  //正确
		// /home/anderson/GitHub/test-project/test-java/target/classes/com/testio/test.txt
		System.out.println("---->>:" + this.getClass().getResource("test.txt").getPath());
		//绝对路径
		// /home/anderson/GitHub/test-project/test-java/target/classes/com/testio/test.txt
		InputStream is = this.getClass().getResourceAsStream("/com/testio/test.txt");  //正确
		System.out.println("---->>>>:" + this.getClass().getResourceAsStream("test.txt"));

		// /home/anderson/GitHub/test-project/test-java/target/classes/com/testio/test.txt
		System.out.println("---->>>:" + this.getClass().getResource("/com/testio/test.txt").getPath());

		byte[] b = new byte[20];
		try {
			is.read(b);
			String str = new String(b);
			System.out.println("is:"+is);
			System.out.println("--str:"+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public void getPath2(){
		ClassLoader loader = this.getClass().getClassLoader();
		
		InputStream is = loader.getResourceAsStream("test2.txt"); //正确 src是classpath，但是不能以'/'开头
//		System.out.println(loader.getResourceAsStream("/tmp/test3.txt"));
//		InputStream is = loader.getResourceAsStream("com/testio/test.txt");	//正确
		System.out.println("++++" + Thread.currentThread().getContextClassLoader().getResource("test2.txt").getPath());///home/anderson/GitHub/test-project/test-java/target/classes/
		byte[] b = new byte[20];
		try {
			is.read(b);
			String str = new String(b);
			System.out.println("is"+is);
			System.out.println("str:"+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void getPath3(){

		InputStream is = null;
		try {
			//相对路径，整个工程下面的路径，不是单个的module下
			is = new FileInputStream("hello.txt");	//正确
			System.out.println("====" + new File("hello.txt").getCanonicalPath());///home/anderson/GitHub/test-project/hello.txt
			//绝对路径，系统路径
//			is = new FileInputStream("/home/anderson/GitHub/test-project/hello.txt");	//正确
			byte[] b = new byte[100];
			is.read(b);
			String str = new String(b);
			System.out.println("is"+is);
			System.out.println("str:"+str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}

	public static void main(String[] args) {
//		new TestPath().getPath();
		new TestPath().getPath2();
//		new TestPath().getPath3();
	}
}
