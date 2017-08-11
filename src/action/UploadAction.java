package action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import common.DateUtil;
import common.PathConsts;

public class UploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8920466592471253212L;
	private Logger log = Logger.getLogger(getClass());

	private File myFile;

	private String myFileFileName;

	private String myFileContentType;

	public String uploadFile() {

		if (myFile == null) {

			ServletActionContext.getRequest().setAttribute("notExist", getText("file.notExist"));

			return Action.ERROR;
		}

		String path = PathConsts.BASE_PATH + PathConsts.UPLOAD_PATH + File.separator
				+ DateUtil.dataToString(new Date(), DateUtil.YYYYMMDD);

		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		path = path + File.separator + myFileFileName;
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

}
