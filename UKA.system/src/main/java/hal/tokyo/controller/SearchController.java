package hal.tokyo.controller;

import hal.tokyo.beans.PostingsBean;
import hal.tokyo.dao.PostingsDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {


		@SuppressWarnings("null")
		@RequestMapping(value = "/search")
		public ModelAndView showSearch(@RequestParam(value = "search" , required = false) String search ,
									@RequestParam(value="searchchar" , required = false) String searchchar ,
									@RequestParam(value="newbtn" , required = false) String newbtn ,
									@RequestParam(value="popular" , required = false) String popular ,
									@RequestParam(value="neardeadline" , required = false) String neardeadline ,
									@RequestParam(value="highvote" , required = false) String highvote ,
									@RequestParam(value="lowvote" , required = false) String lowvote
		) {

			System.out.println("new:"+newbtn);
			System.out.println("search:"+searchchar);

			ModelAndView mv = new ModelAndView("search");
			//変数宣言
			PostingsDao postingsDao = new PostingsDao();
			ArrayList<PostingsBean> result = null;

			//どれかボタン押されたらこの中へ
			if (newbtn != null || popular != null || neardeadline != null || highvote != null || lowvote != null ) {

				//新規順番
				if(newbtn.equals("newbtn") && (searchchar != null || !searchchar.equals(""))){
					try {
						result = postingsDao.sortNew(searchchar);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}
				//人気順
				if(popular.equals("popular") && (searchchar != null || !searchchar.equals(""))){
					try {
						result = postingsDao.sortFavor(searchchar);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}
				//締切
				if(neardeadline.equals("neardeadline") && (searchchar != null || !searchchar.equals(""))){
					try {
						result = postingsDao.sortNearDeadline(searchchar);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}
				//評価高
				if(highvote.equals("highvote") && (searchchar != null || !searchchar.equals(""))){
					try {
						result = postingsDao.sortHigh(searchchar);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}
				//評価低
				if(lowvote.equals("lowvote") && (searchchar != null || !searchchar.equals(""))){
					try {
						result = postingsDao.sortLow(searchchar);
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}
			}
			//searchに何も入れないで押下された場合
			if(search == null || search.equals("")){
				try {
					result = postingsDao.getPostings();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				Collections.shuffle(result);
				mv.addObject("result", result);
				return mv;
			}

			if(searchchar == null || searchchar.equals("")){
				//検索文字列が入っていた場合
				try {
					result = postingsDao.searchChar(search);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					System.out.println("SQL Error");
					e.printStackTrace();
				}
				//配列の中身をランダムにする
				Collections.shuffle(result);
				//送る
				mv.addObject("result", result);
				mv.addObject("searchchar", search);

				return mv;
			}

			return null;
		}

}
