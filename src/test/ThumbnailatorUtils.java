package test;

import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;

public class ThumbnailatorUtils {
	public static void ImgSourceRegion(String source, String output, Position position, int x, int y, int width,
			int height, boolean keepAspectRatio) {
		try {
			Thumbnails.of(source).sourceRegion(position, x, y).size(width, height).keepAspectRatio(keepAspectRatio)
					.toFile(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
