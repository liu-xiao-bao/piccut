package action;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import common.PathConsts;
import net.coobird.thumbnailator.Thumbnails;

public class ImageCutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137230281458114385L;

	private Logger log = Logger.getLogger(getClass());

	private File myFile;

	private String myFileFileName;

	private String myFileContentType;

	private Integer x1;
	private Integer y1;
	private Integer width;
	private Integer height;

	public String cutImg() {
		if (myFile == null) {

			ServletActionContext.getRequest().setAttribute("notExist", getText("file.notExist"));

			return Action.ERROR;
		}

		String path = PathConsts.BASE_PATH + PathConsts.TEMP_PATH;
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		path = path + File.separator + UUID.randomUUID() + myFileFileName;
		log.info(path);

		OutputStream out = null;

		try {
			out = new FileOutputStream(path);
			FileUtils.copyFile(myFile, out);

			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Rectangle r = new Rectangle(x1, y1, width, height);

		try {
			Thumbnails.of(path).scale(1f).sourceRegion(r).outputFormat("jpg").outputQuality(1f)
					.toFile(PathConsts.BASE_PATH + PathConsts.TEMP_PATH + "\\cut" + Math.random() * 10);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Action.SUCCESS;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public Integer getX1() {
		return x1;
	}

	public void setX1(Integer x1) {
		this.x1 = x1;
	}

	public Integer getY1() {
		return y1;
	}

	public void setY1(Integer y1) {
		this.y1 = y1;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}
