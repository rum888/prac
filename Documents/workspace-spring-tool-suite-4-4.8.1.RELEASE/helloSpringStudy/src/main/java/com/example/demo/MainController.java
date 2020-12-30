package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//↑下の文の処理を使うために必要な準備（適宜インポートする）


@Controller //これをつけたクラスがコントローラーになる。
public class MainController {
//「localhost:8080/」にアクセスした時に以下を開くようにする。
@RequestMapping("/") 
public ModelAndView index(ModelAndView mv) {
	mv.setViewName("index");	//index.html のページを表示
	return mv;
}
//Modelクラス利用してth:text使用
@RequestMapping("/model1")
public String exam1(Model model) {
	model.addAttribute("name", "名前が入るよ。");
	return "index";
}
//Model And Viewクラスを利用してth:text使用(授業では主にこっち使う)
@RequestMapping("/model2")
public ModelAndView exam2(ModelAndView mv) { 
	mv.addObject("name","nameが入る。");
	mv.setViewName("index");
	return mv;
}
//GET POSTの導入
@RequestMapping(value="/", method=RequestMethod.GET)
public ModelAndView indexGET(ModelAndView mv) {
	mv.addObject("name","ここに名前が入ります。");
	mv.addObject("age","ここに年齢。");
	mv.addObject("height","ここに身長。");
	mv.setViewName("index");
	return mv;
	}

@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv,
			@RequestParam("nameVal")String name,
			@RequestParam("ageVal")String age,
			@RequestParam("heightVal")String height) {
	mv.addObject("name",name);
	mv.addObject("age",age);
	mv.addObject("height",height);
	mv.setViewName("index");
	return mv;
	}
	
//th:ifの導入
@RequestMapping(value="/if", method=RequestMethod.GET)
public ModelAndView ifGET(ModelAndView mv) {
	mv.addObject("suzuki",false);
	mv.setViewName("th_If");
	return mv;
	}

//テンプレートフラグメント（th:fragment）の導入
@RequestMapping(value="/if",method=RequestMethod.POST)
	public ModelAndView ifPost(ModelAndView mv) {
	mv.addObject("suzuki",true);
	mv.setViewName("th_If");
	return mv;
}

//URLに名前を入れる。
@RequestMapping("/inName/{name}")
	public ModelAndView nameIn(@PathVariable String name,
			ModelAndView mv) {
	mv.addObject("name",name);
	mv.setViewName("inName");
	return mv;
}

//URLに入れた数字の分だけ「あ」を繰り返し表示する。
@RequestMapping("/inNum/{num}")
public ModelAndView numRepeat(@PathVariable int num,
		ModelAndView mv) {
	String line="";
	for(int i=0; i<num; i++) 
		line+="あ";
	mv.addObject("num",line);
	mv.setViewName("inName");
	return mv;
	}
	
//Day23　データベース
@Autowired	//@Repositoryと繋がっている。
//　↓以降、repository と書くだけでUserdatarepository(データの保管場所)へアクセスできる
UserDataRepository repository;

@RequestMapping(value="/data", method = RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv){
List<UserData> customers = repository.findAll();
mv.addObject("customers", customers);
//現在時刻
//Date time=new Date();
//String str = String.valueOf(time);
//mv.addObject("time",time);
mv.setViewName("UserData");
return mv;
}
@RequestMapping(value="/data", method = RequestMethod.POST)
public ModelAndView indexPost(@ModelAttribute("formModel") UserData
userData, ModelAndView mv){
repository.saveAndFlush(userData);
return new ModelAndView("redirect:/data");
	}


////Day24(p9~11)　読み込み
@RequestMapping(value="/mypage/{id}",method=RequestMethod.GET)
public ModelAndView mypage(@ModelAttribute UserData userData,ModelAndView mv,
		@PathVariable long id) {
	Optional<UserData> user =repository.findById(id);
	mv.addObject("user", user.get());
	mv.setViewName("mypage");
	return mv;
}

//Day24(p13~15)　読み込み
@RequestMapping(value="/mypage2",method=RequestMethod.GET)
public ModelAndView mypage2(@ModelAttribute UserData userData,
		ModelAndView mv) {
	List<UserData> user = repository.findByIdIsNotNullOrderByIdDesc();
	mv.addObject("user", user);
	mv.setViewName("mypage2");
	return mv;
}

//Day24(p13~p20) Update
@RequestMapping(value="/mypage3/{id}",method=RequestMethod.GET)
public ModelAndView mypage3Get(@ModelAttribute UserData userData,
		ModelAndView mv, @PathVariable long id) {
	Optional<UserData> user = repository.findById(id);
	mv.addObject("userData",user.get());
	mv.setViewName("mypage3");
	return mv;
}
@RequestMapping(value="/mypage3",method=RequestMethod.POST)
public ModelAndView mypage3Post(@ModelAttribute UserData userData,
		ModelAndView mv) {
	repository.saveAndFlush(userData);
	return new ModelAndView("redirect:/data");
}

//Day24(p21~p23) Delete
@RequestMapping(value="/data/delete",method=RequestMethod.POST)
public ModelAndView delete(@RequestParam("id") long id,
		ModelAndView mv){
	repository.deleteById(id);
	return new ModelAndView("redirect:/data"); 
}

}
