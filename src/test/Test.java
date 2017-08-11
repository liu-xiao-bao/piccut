package test;

import java.awt.Rectangle;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/****
			 * sourceRegion(int arg0, int arg1, int arg2, int arg3)
			 * arg0 => x1
			 * arg1 => y1
			 * arg2 => 横向切多少像素
			 * arg3 => 纵向切多少像素
			 */
			//Thumbnails.of("D:\\2.jpg").scale(1f).sourceRegion(820,0, 590, 900).outputQuality(1f).toFile("D:\\cut.jpg");
			//Thumbnails.of("D:\\2.jpg").scale(0.5f).sourceRegion(820,0, 590, 900).outputQuality(1f).toFile("D:\\ thumbnail.jpg");
		
			//Thumbnails.of("D:\\3.jpg").scale(1f).sourceRegion(820,0, 590, 900).outputQuality(1f).toFile("D:\\cut3.jpg");
			
			
			Rectangle r = new Rectangle(1, 200, 200, 200);
			
			Thumbnails.of("D:\\2.jpg").scale(1f).sourceRegion(r).outputQuality(1f).toFile("D:\\cut.jpg");
			
			Thumbnails.of("D:\\3.jpg").scale(1f).sourceRegion(r).outputQuality(1f).toFile("D:\\cut3.jpg");
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
