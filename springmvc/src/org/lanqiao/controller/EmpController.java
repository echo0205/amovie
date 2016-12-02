package org.lanqiao.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.entity.Employee;
import org.lanqiao.service.EmployeeService;
import org.lanqiao.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
@RequestMapping("/emp")
public class EmpController {
	EmployeeService employeeService = new EmployeeServiceImpl(); 
	/**
	 * 添加事件
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "add";
	}
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Employee emp,@RequestParam MultipartFile[] uploadFile,HttpServletRequest request){
		String imgUrl = upload(uploadFile, request);
		emp.setImgUrl(imgUrl);
		employeeService.addList(emp);
		return "redirect:/emp/select";
	}
	/**
	 * 删除操作
	 * @param id 用户名id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id",required=true,defaultValue="1") int id){
		employeeService.deleteEmpByid(id);
		return "redirect:/view/selectBt";
	}
	/**
	 * 修改员工信息
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Model model,int id){
		Employee emp = employeeService.queryOneEmp(id);
		model.addAttribute("emp",emp);
		return "update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Employee emp){
		employeeService.updateEmpByid(emp);
		return "redirect:/emp/select";
	}
	@RequestMapping(value="/updateImg",method=RequestMethod.POST)
	@ResponseBody
	public String updateImg(Employee emp,@RequestParam MultipartFile[] uploadFile,HttpServletRequest request){
		String upload = upload(uploadFile, request);
		return upload;
	}
//上传文件	
	/**
	 * 跳转至上传路径
	 * @return
	 */
	@RequestMapping("/upload")
	public String toUpload(){
		return "upload";
	}
	/**
	 * 上传文件
	 * @param emp
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String upload(Employee emp,@RequestParam MultipartFile[] uploadFile,HttpServletRequest request){
		String webPath = request.getServletContext().getRealPath("/");
		System.out.println("项目绝对路径："+webPath);
		File file = new File(webPath+"/upload/");
		System.out.println(file);
		if(!file.exists()){
			file.mkdir();//创建子目录
		}
		List<String> images = new ArrayList<String>();
		for (int i = 0; i < uploadFile.length; i++) {
			String fileName = uploadFile[i].getOriginalFilename();
			String prefix = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(prefix);
			fileName = createFileName()+prefix;
			System.out.println(fileName);
			
			File imageFile = new File(webPath+"/upload/"+fileName);
			try {
				uploadFile[i].transferTo(imageFile);
				images.add("upload/"+fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("images", images);
		return "main";
	}
	public String upload(@RequestParam MultipartFile[] uploadFile,HttpServletRequest request){
		String webPath = request.getServletContext().getRealPath("/");
		System.out.println("项目绝对路径："+webPath);
		File file = new File(webPath+"/upload/");
		System.out.println("文件上传路径："+file);
		if(!file.exists()){
			file.mkdir();//创建子目录
		}
		String imgUrl = null;
		for (int i = 0; i < uploadFile.length; i++) {
			String fileName = uploadFile[i].getOriginalFilename();
			String prefix = fileName.substring(fileName.lastIndexOf("."));//文件后缀名
			fileName = createFileName()+prefix;
			System.out.println(fileName);
			imgUrl = "upload/"+fileName;
			System.out.println(imgUrl);
			File imageFile = new File(webPath+"/"+imgUrl);
			try {
				uploadFile[i].transferTo(imageFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imgUrl;
	}
	
	/**
	 * 获取时间搓
	 * @return
	 */
	public String createFileName(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsss");
		String name = sdf.format(new Date());
		return name;
	}
	/**
	 * 分页查询(自己写)
	 * @param cpg
	 * @param request
	 * @return
	 */
	@RequestMapping("/select1")
	public String queryPaging(@RequestParam(value="cpg",defaultValue="1") int cpg,HttpServletRequest request){
		List<EmpQueryVo> list = employeeService.queryBypaging1(cpg, 5);
		int count = employeeService.queryList().size();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("cpg", cpg);
		int pageTotal=0;
		if(count % 5 == 0){
			pageTotal = count/5;
		}else{
			pageTotal = count/5+1;
		}
		request.setAttribute("pageTotal", pageTotal);
		return "select";
	}
	/**
	 * bootstrap table插件
	 * @param request
	 * @return
	 */
	@RequestMapping("/select")
	@ResponseBody
	public Object queryPaging(HttpServletRequest request){
		int pageSize = Integer.parseInt(request.getParameter("limit"));
		int pageNumber = Integer.parseInt(request.getParameter("offset"));
		List<EmpQueryVo> list = employeeService.queryBypaging(pageNumber, pageSize);
		int count = employeeService.queryList().size();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		String json1 = "{\"total\":"+count+",\"rows\":"+json+"}";
		return json1;
	}
}
