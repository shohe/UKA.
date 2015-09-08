package hal.tokyo.model;

import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageUpload {

	@Autowired
	ServletContext context;

	public ImageUpload(ServletContext context) {

		this.context = context;

	}

	public String createUploadPath() {

		String path = context.getRealPath("\\");
		System.out.println("path::"+path);
		String[] paths = path.split("\\\\", 0);
		path = "";
		//int loop = 0;
		for (String p : paths) {
			//loop++;
			//System.out.println("loop:"+loop+"___p :"+p);
			path += p+"\\";
			if (p.equals("UKA")) {
				path += "UKA.system\\src\\main\\webapp\\resources\\var\\";
				break;
			}
		}


//		String path = context.getRealPath("/");
//		String[] paths = path.split("/", 0);
//		path = "";
//		for (String p : paths) {
//			path += p+"/";
//			if (p.equals("UKA.")) {
//				path += "UKA.system/src/main/webapp/resources/var/";
//				break;
//			}
//		}
		return path;
	}

	public String getFileExtention(String file) {
		String result = String.valueOf(Calendar.getInstance().getTimeInMillis());
		return result+file;
	}

}
