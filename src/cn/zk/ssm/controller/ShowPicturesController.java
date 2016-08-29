package cn.zk.ssm.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.service.FirstCategoryService;
import cn.zk.ssm.service.ShowPicturesService;

/**
 * 展示图片的Controller
 * 
 * @author LJaer
 * 
 */
@Controller
public class ShowPicturesController {
	File tempPathFile;
	
	@Autowired
	private ShowPicturesService showPicturesService;

	// 查询用来展示的图片
	@RequestMapping("/queryShowPictures")
	public ModelAndView queryShowPicturesList() throws Exception {
		// 调用service查询数据库，查询用来展示的图片
		List<ShowPictures> showPicturesList = showPicturesService.queryShowPictures();
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request.set的setAttribute，在jsp页面通过firstCategoryList取数据
		modelAndView.addObject("showPicturesList", showPicturesList);
		// 指定视图
		modelAndView.setViewName("jsp/show-pictures");
		return modelAndView;
	}
	
	//查询所有图片
	@RequestMapping("/queryAllPictures")
	@ResponseBody
	public List<ShowPictures> queryAllPictures() throws Exception{
		return showPicturesService.queryAllPictures();
	}
	
	//删除一条展示图片
	@RequestMapping("/delPicture")
	@ResponseBody
	public int delPicture(int id) throws Exception{
		ShowPictures  showPictures= showPicturesService.selectByPrimaryKey(id);
		String filePath = System.getProperty("user.dir");// user.dir指定了当前的路径
		filePath = filePath.substring(0, filePath.length() - 3);
		filePath += "webapps/show-message/pictures/showImg/"+showPictures.getName();
		deleteFile(filePath);
		return showPicturesService.deleteByPrimaryKey(id);
	}
	
	//改变选择状态
	@RequestMapping("/changeChoice")
	@ResponseBody
	public int changeChoice(ShowPictures showPictures) throws Exception{
		return showPicturesService.changeChoice(showPictures);
	}
	
	@RequestMapping("/insertShowPicture")
	public @ResponseBody
	String insertShowPicture(HttpServletRequest request) {
		String uploadPath = System.getProperty("user.dir");// user.dir指定了当前的路径
		uploadPath = uploadPath.substring(0, uploadPath.length() - 3);
		uploadPath += "webapps/show-message/pictures/showImg";
		try {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			factory.setRepository(tempPathFile);// 设置缓冲区目录

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			Iterator<FileItem> i = items.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				String fileName = fi.getName();
				if (fileName != null) {
					File fullFile = new File(new String(
							fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题
					File savedFile = new File(uploadPath, fullFile.getName());
					fi.write(savedFile);
					ShowPictures showPictures = new ShowPictures();
					showPictures.setName(fullFile.getName());
					showPicturesService.insert(showPictures);
					return "success";
				}
			}
			System.out.print("upload succeed");
		} catch (Exception e) {

		}
		return "failed";
	}
	
	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}
}



