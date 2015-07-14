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


		@SuppressWarnings({ "null", "unused" })
		@RequestMapping(value = "/search")
		public ModelAndView showSearch(@RequestParam(value = "search" , required = false) String search ,
									@RequestParam(value="searchchar" , required = false) String searchchar ,
									@RequestParam(value="newbtn" , required = false) String newbtn ,
									@RequestParam(value="popular" , required = false) String popular ,
									@RequestParam(value="neardeadline" , required = false) String neardeadline ,
									@RequestParam(value="highvote" , required = false) String highvote ,
									@RequestParam(value="lowvote" , required = false) String lowvote
		) {
			System.out.println(search);
			System.out.println(searchchar);
			System.out.println(newbtn);
			System.out.println(popular);
			System.out.println(neardeadline);
			System.out.println(highvote);
			System.out.println(lowvote);
			System.out.println("");

			ModelAndView mv = new ModelAndView("search");
			//変数宣言
			PostingsDao postingsDao = new PostingsDao();
			ArrayList<PostingsBean> result = null;

			//どれかボタン押されたらこの中へ
			if (newbtn != null || popular != null || neardeadline != null || highvote != null || lowvote != null ) {

				/* ----- 新規順 -----*/
				if(newbtn != null && (search == null || searchchar == null)){
					try {
						result = postingsDao.sortNew();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					return mv;
				}


				if(newbtn != null && (search != null || searchchar != null)){
					try {
						if(search != null){
							result = postingsDao.sortNew(search);
						}else if(searchchar != null){
							result = postingsDao.sortNew(searchchar);
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					mv.addObject("searchchar", search);
					return mv;
				}


				/* ----- 人気順 -----*/
				//空
				if(popular != null && (search == null || searchchar == null)){
					try {
						result = postingsDao.sortFavor();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					return mv;
				}

				//入力
				if(popular != null && (search != null || searchchar != null)){
					try {
						if(search != null){
							result = postingsDao.sortFavor(search);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}else if(searchchar != null){
							result = postingsDao.sortFavor(searchchar);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}

				/* ----- 締切 -----*/
				//空
				if(neardeadline != null && (search == null || searchchar == null)){
					try {
						result = postingsDao.sortNearDeadline();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					return mv;
				}

				//入力
				if(neardeadline != null && (search != null || searchchar != null)){
					try {
						if(search != null){
							result = postingsDao.sortNearDeadline(search);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}else if(searchchar != null){
							result = postingsDao.sortNearDeadline(searchchar);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}

				/* ----- 評価高 -----*/
				//空
				if(highvote != null && (search == null || searchchar == null)){
					try {
						result = postingsDao.sortHigh();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					return mv;
				}

				//入力
				if(highvote != null && (search != null || searchchar != null)){
					try {
						if(search != null){
							result = postingsDao.sortHigh(search);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}else if(searchchar != null){
							result = postingsDao.sortHigh(searchchar);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}

				/* ----- 評価低 -----*/
				//空
				if(lowvote != null && (search == null || searchchar == null)){
					try {
						result = postingsDao.sortLow();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					mv.addObject("result", result);
					return mv;
				}

				//入力
				if(lowvote != null && (search != null || searchchar != null)){
					try {
						if(search != null){
							result = postingsDao.sortLow(search);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}else if(searchchar != null){
							result = postingsDao.sortLow(searchchar);
							mv.addObject("result", result);
							mv.addObject("searchchar", search);
							return mv;
						}
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			}

			/* ----- 何も入れずに検索を押した場合 -----*/
			if(search == null || search.equals("")){
				try {
					result = postingsDao.getPostings();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//Collections.shuffle(result);
				mv.addObject("result", result);
				return mv;
			}

			/* ----- 検索文字列が入力 -----*/
			if(searchchar == null || searchchar.equals("")){
				try {
					result = postingsDao.searchChar(search);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					System.out.println("SQL Error");
					e.printStackTrace();
				}
				//配列の中身をランダムにする
				//Collections.shuffle(result);
				//送る
				mv.addObject("result", result);
				mv.addObject("searchchar", search);

				return mv;
			}

			return mv;
		}

}
