/**
 * 
 */
package com.dubbo.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;

import com.dubbo.api.pojo.User;
import com.dubbo.api.service.DemoService;
import com.dubbo.api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Thunisoft
 *
 */
@RestController
@EnableSwagger2
@Api(value = "用户模块", description = "用户模块的接口信息", tags = "swagger项目管理")
public class UserController {
	@Reference(version = "${demo.service.version}")
	private DemoService demoService;

	@Reference(version = "${demo.service.version}")
	private IUserService userServiceImpl;

	// 开关判断
	private boolean flag = false;
	private int intFlag = -1;
	
	//文件上传位置
	private String namefile;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://upload/src/main/resources/static/images/";
	
	/*
	 **   首先测试dubbo的通信是不达成
	 */
	@GetMapping("/sayHello/")
	@ApiOperation(value = "发表dubbo的第一句话", notes = "dubbo发出")
	@ApiImplicitParam(paramType="query",name = "name", value = "通过dubbo打招呼的姓名",required=true, dataType = "String")
	public String sayHello(String name) {
		return demoService.sayHello(name);
	}

	// 获取用户列表的方法
	@ApiOperation(value = "获取用户列表", notes = "获取所有用户的列表")
	@GetMapping("/users")
	public List<User> users() {
		List<User> user = null;
		user=userServiceImpl.findAllUsers();
		return user;
	}

	// 根据用户的id 查询用户
	@PostMapping(value = "/findUserById")
	@ApiOperation(value = "根据用户的id 查询用户", notes = "根据用户的id 查询用户")
	@ApiImplicitParam(paramType="query",name = "userid", value = "用户的id编号",required = true, dataType = "int")
	public User findUserById(int userid) {
		return userServiceImpl.findUserById(userid);
	}

	// 添加用户
	@PostMapping(value = "/addUserInfo")
	@ApiOperation(value = "添加用户信息", notes = "添加用户的信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name = "userid", value = "账号", dataType = "String"),
		@ApiImplicitParam(paramType="query",name = "username", value = "姓名",required=true, dataType = "String"),
		@ApiImplicitParam(paramType="query",name = "password", value = "密码",required=true,dataType = "String") 
	})
  public String addUserInfo(@ModelAttribute User user) {
//	public String addUserInfo(String userid, String username, String password) {
		System.out.println("接受的参数" + user);
		intFlag = userServiceImpl.addUserInfo(user);
		if (intFlag > 0) {
			return "用户添加成功";
		} else {
			return "用户添加失败";
		}
	}

	// 删除用户
	@DeleteMapping(value = "/removeUserInfo")
	@ApiOperation(value = "根据用户的id删除用户信息", notes = "删除用户信息")
	@ApiImplicitParam(paramType="query",name = "userid", value = "删除用户",required=true,dataType="int")
	public String removeUserInfo(int userid) {
		intFlag = userServiceImpl.removeUserInfo(userid);
		if (intFlag > 0) {
			return "用户删除成功";
		} else {
			return "用户删除失败";
		}
	}

	// 修改用户
	@PutMapping(value = "/updateUserInfo")
	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
	@ApiImplicitParams({ 
		@ApiImplicitParam(paramType="query",name = "userid", value = "账号",required=true, dataType = "String"),
		@ApiImplicitParam(paramType="query",name = "username", value = "姓名",required=true, dataType = "String"),
		@ApiImplicitParam(paramType="query",name = "password", value = "密码",required=true, dataType = "String") 
	})
	public String updateUserInfo(@ModelAttribute User user) {
		intFlag = userServiceImpl.updateUserInfo(user);
		if (intFlag > 0) {
			return "用户更新成功";
		} else {
			return "用户更新失败";
		}
	}
	
	/*
	    ** 文件上传信息处理页面
	     */
	    @GetMapping("/uploadStatus")
	    public String uploadStatus(){
	        return "uploadStatus";
	    }
	    
	    
	//文件上传
	@PostMapping(value="/uploadFile")
	@ApiOperation(value = "")
	@ApiImplicitParam(paramType="query",name="filename",value="文件上传",dataType="file")
	public String uploadFile(@RequestParam("filename") MultipartFile filename, RedirectAttributes redirectAttributes)
	{
		//如果文件为空，返回一个错误体格提示信息
		if(filename.isEmpty()) 
		{
			redirectAttributes.addAttribute("msg", "上传的文件为空,请重新上传");
			return "redirect:/uploadStatus";
		}
		try {
            // 获取文件并保存到指定文件夹中
            byte[] bytes = filename.getBytes();
            namefile = filename.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "您已成功上传 '" + filename + "', 该文件大小约为 " +bytes.length/1024+" KB.");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
	}
	/*
	 ** 数据预览页面： 支持部分图片格式的预览
	 */

	@GetMapping("/review")
	public String review(Map<String, Object> map) {

		map.put("filename", namefile);
		String filetype = namefile.split("\\.")[1];
		map.put("filetype", filetype);
		System.out.println(namefile);
		return "review";
	}
	//接受别的系统的传递过来的数据
	@PostMapping(value="/receive")
	@ApiOperation(value = "接受别的系统传递过来的参数")
	public String receive(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		StringBuffer str = new StringBuffer();   
	    try {  
	         BufferedInputStream in = new BufferedInputStream(request.getInputStream());
	         int i;  
	         char c;  
	         while ((i=in.read())!=-1) {  
	              c=(char)i;  
	              str.append(c);  
	          }  
	      }catch (Exception ex) {  
	           ex.printStackTrace();  
	      }  
	      String string = str.toString();
	      System.out.println("接收的信息为："+string);
	      List<User> userList=new ArrayList<User>();
	      userList= JSONObject.parseArray(string,User.class);
	      System.out.println("输出转化后的obj"+userList);
	      Iterator<User> it=userList.iterator();
	      while(it.hasNext()) 
	      {
	    	  System.out.println("获得User为："+it.next());
	      }
	      redirectAttributes.addAllAttributes(userList);
		return "redirect:/saveOtherSystem";
	}
	
	@PostMapping(value="/saveOtherSystem")
	@ApiOperation(value = "保存用户集合",notes="note 保存用户集合" )
	public String saveOtherSystem(@ModelAttribute(value="userList")List<User> userList) 
	{
		System.out.println(userList);
		System.out.println(userList);
		return null;
	}

}
