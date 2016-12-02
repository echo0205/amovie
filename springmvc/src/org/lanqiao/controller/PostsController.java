package org.lanqiao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lanqiao.entity.Posts;
import org.lanqiao.entity.Reply;
import org.lanqiao.service.PostsService;
import org.lanqiao.service.ReplyService;
import org.lanqiao.service.impl.PostsServiceImpl;
import org.lanqiao.service.impl.ReplyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostsController {
	private PostsService postsService = new PostsServiceImpl();
	private ReplyService replyService = new ReplyServiceImpl();
	@RequestMapping("/select")
	public String selectPosts(Model model){
		List<Posts> listPosts = postsService.queryPosts();
		model.addAttribute("listPosts", listPosts);
		return "posts";
	}
	@RequestMapping("/detail")
	public String selectPostsByid(int id,HttpServletRequest request){
		List<Posts> listPosts = postsService.queryPostsByid(id);
		List<Reply> listReply = replyService.queryReplyByid(id);
		int count = listReply.size();
		request.setAttribute("listPosts", listPosts);
		request.setAttribute("listReply", listReply);
		request.setAttribute("count", count);
		System.out.println(listPosts);
		return "detal";
	}

}
